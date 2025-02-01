package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentsDal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDalTestTestContainers {
    private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer("mysql:latest").withDatabaseName("student-test-db").withUsername("testUser").withPassword("password");

    static {
        MY_SQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void registerDataBaseProperties(DynamicPropertyRegistry register) {
        register.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
        register.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
        register.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
    }
    @Autowired
    private StudentsDal studentsDal;
    @Test
    @DisplayName("Testing for the Save Student")
    public void shouldSaveStudent(){
        Student student= new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978");
        Student resultTest=studentsDal.save(student);
        assertThat(resultTest).usingRecursiveComparison().ignoringFields("sid").isEqualTo(student);
    }

}
