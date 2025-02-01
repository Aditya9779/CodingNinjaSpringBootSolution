package com.cn.hotel.controller;

import com.cn.hotel.jwt.JwtAuthenticationHelper;
import com.cn.hotel.model.Hotel;
import com.cn.hotel.service.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = HotelController.class)
public class HotelControllerTest {

    @MockBean
    private HotelService hotelService;

    @MockBean
    private JwtAuthenticationHelper jwtAuthenticationHelper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void shouldTestGetALllHotels() throws Exception {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Raddison Hotel");
        hotel.setRating((long)4.5);
        hotel.setCity("Bangalore");

        Mockito.when(hotelService.getAllHotels()).thenReturn(asList(hotel));
        mockMvc.perform(get("/hotel/getAll"))
                .andExpect(status().is(200));

    }

}
