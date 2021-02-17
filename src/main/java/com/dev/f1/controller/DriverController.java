package com.dev.f1.controller;

import com.dev.f1.entity.Driver;
import com.dev.f1.model.DriverWithIdAndNameVO;
import com.dev.f1.repository.DriverRepository;
import com.dev.f1.repository.DriverRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DriverController {
    private final DriverRepository driverRepository;
    private final DriverRepositoryImpl driverRepositoryImpl;

    public DriverController(DriverRepository driverRepository, DriverRepositoryImpl driverRepositoryImpl) {
        this.driverRepository = driverRepository;
        this.driverRepositoryImpl = driverRepositoryImpl;
    }

    @GetMapping("/driversByNationality")
    public ResponseEntity<List<Driver>> getDriversByNationality(@RequestParam("nationality") String nationality) {
        return new ResponseEntity<>(this.driverRepository.findByNationality(nationality), HttpStatus.OK);
    }

    @GetMapping("/getAllDriversByToken")
    @ResponseBody
    public List<DriverWithIdAndNameVO> getAllByDrivers(@RequestParam("token") String token) {
        return this.driverRepositoryImpl.findDriversWithIdAndName(token);
    }
}
