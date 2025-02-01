package com.cn.hotel.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.cn.hotel.model.Hotel;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelRepositoryTest {

	@Autowired
	private HotelRepository hotelRepository;

	private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest")
				.withDatabaseName("hotel-test-db")
				.withUsername("testUser")
				.withPassword("password");

	static {
		MY_SQL_CONTAINER.start();
	}

	@DynamicPropertySource
	static void registerDatabaseProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
		registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
	}

	@Test
	public void shouldTestSaveHotelRepo() {
		Hotel hotel = new Hotel();
		hotel.setId(1L);
 		hotel.setName("Raddison Hotel");
 		hotel.setRating((long)4.5);
 		hotel.setCity("Bangalore");

 		Hotel expectedHotel = hotelRepository.save(hotel);

 		assertThat(expectedHotel)
 			.usingRecursiveComparison()
 			.ignoringFields("id")
 			.isEqualTo(hotel);
	}
}
