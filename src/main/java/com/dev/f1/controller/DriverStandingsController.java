package com.dev.f1.controller;

import com.dev.f1.model.*;
import com.dev.f1.repository.DriverStandingsRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f1/api/")
public class DriverStandingsController {

    private final DriverStandingsRepositoryImpl driverStandingsRepositoryImpl;

    public DriverStandingsController(DriverStandingsRepositoryImpl driverStandingsRepositoryImpl) {
        this.driverStandingsRepositoryImpl = driverStandingsRepositoryImpl;
    }

    @GetMapping("/worldDriverChampions")
    @ResponseBody
    public List<WorldChampionsVO> findWorldDriverChampions() {
        return this.driverStandingsRepositoryImpl.findWorldDriverChampions();
    }

    @GetMapping("/driverStandingsOverTheYears/{driverId}")
    @ResponseBody
    public List<DriverStandingOverTheYearsVO> findDriverStandingsOverTheYears(@PathVariable("driverId") int driverId) {
        return this.driverStandingsRepositoryImpl.findDriverStandingsOverTheYears(driverId);
    }

    @GetMapping("/driverPodiumPositions/{driverId}")
    @ResponseBody
    public List<DriverPodiumPositionsVO> getDriverPodiumPositions(@PathVariable("driverId") int driverId) {
        return this.driverStandingsRepositoryImpl.getDriverPodiumPositions(driverId);
    }

    @GetMapping("/driverWins/{driverId}")
    @ResponseBody
    public List<Chart1VO> getDriverWinsByYear(@PathVariable("driverId") int driverId) {
        return this.driverStandingsRepositoryImpl.getDriverWinsByYear(driverId);
    }


    @GetMapping("/driverConstructors/{driverId}")
    @ResponseBody
    public List<DriverConstructorsVO> getDriverConstructors(@PathVariable("driverId") int driverId) {
        return this.driverStandingsRepositoryImpl.getDriverConstructors(driverId);
    }

    @GetMapping("/driverChampionshipYears/{driverId}")
    @ResponseBody
    public List<Integer> getDriverChampionshipYears(@PathVariable("driverId") int driverId) {
        return this.driverStandingsRepositoryImpl.getDriverChampionshipYears(driverId);
    }
}
