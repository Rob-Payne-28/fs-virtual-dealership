package com.example.virtualdealershipfullstack;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class VehicleController {

    @Autowired
    private VehicleRepo vehicleRepo;

    @GetMapping("/api/vehicles")
    public Iterable<Vehicle> getVehicles() {
        return vehicleRepo.findAll();
    }
}
