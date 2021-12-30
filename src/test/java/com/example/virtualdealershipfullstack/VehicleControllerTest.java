package com.example.virtualdealershipfullstack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    VehicleRepo vehicleRepo;

    @Test
    void shouldReturnAListOfVehicles() throws Exception {
        var vehicles = List.of(
                new Vehicle(1L, "Ford", "CMax", "$9500"),
                new Vehicle(2L,"Ford", "CMax", "$9500")
        );

        var expectedResult = "[{make:Ford,model:CMax,price:$9500},{make:Ford,model:CMax,price:$9500}]";

        when(vehicleRepo.findAll()).thenReturn(vehicles);

        var request = get("/api/vehicles")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }
}