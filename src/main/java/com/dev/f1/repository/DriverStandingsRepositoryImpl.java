package com.dev.f1.repository;

import com.dev.f1.model.*;
import com.dev.f1.utils.Queries;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class DriverStandingsRepositoryImpl {
    private final EntityManager entityManager;

    public DriverStandingsRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<WorldChampionsVO> findWorldDriverChampions() {
        Query query = entityManager.createNativeQuery(Queries.
                WORLD_DRIVER_CHAMPIONS_QUERY.query, "worldChampionsMapping");
        List<WorldChampionsVO> results = (List<WorldChampionsVO>) query.getResultList();
        return results;
    }

    public List<DriverStandingOverTheYearsVO> findDriverStandingsOverTheYears(int driverId) {
        Query query = entityManager.createNativeQuery(Queries.
                        DRIVER_STANDINGS_OVER_THE_YEARS_QUERY.query,
                "driverStandingsOverTheYearsMapping");
        query.setParameter("driverId", driverId);
        List<DriverStandingOverTheYearsVO> results =
                (List<DriverStandingOverTheYearsVO>) query.getResultList();
        return results;

    }

    public List<DriverPodiumPositionsVO> getDriverPodiumPositions(int driverId) {
        Query query = entityManager.createNativeQuery(Queries
                        .DRIVERS_POSITIONS_IN_ALL_RACES.query,
                "driverPodiumResultsMapping");
        query.setParameter("driverId", driverId);
        return (List<DriverPodiumPositionsVO>) query.getResultList();
    }

    public List<Chart1VO> getDriverWinsByYear(int driverId) {
        Query query = entityManager.createNativeQuery(Queries
                .DRIVER_WINS_QUERY.query, "driverWinsMapping");
        query.setParameter("driverId", driverId);
        return (List<Chart1VO>) query.getResultList();
    }


    public List<DriverConstructorsVO> getDriverConstructors(int driverId) {
        Query query = entityManager.createNativeQuery(Queries
                .DRIVER_CONSTRUCTORS_QUERY.query, "driversConstructorsMapping");
        query.setParameter("driverId", driverId);
        return (List<DriverConstructorsVO>) query.getResultList();
    }

    public List<Integer> getDriverChampionshipYears(int driverId) {
        Query query = entityManager.createNativeQuery(Queries
                .DRIVER_CHAMPIONSHIP_YEARS.query);
        query.setParameter("driverId", driverId);
        return (List<Integer>) query.getResultList();
    }
}
