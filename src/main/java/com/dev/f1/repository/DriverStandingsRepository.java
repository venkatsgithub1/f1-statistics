package com.dev.f1.repository;

import com.dev.f1.model.WorldChampionsVO;
import com.dev.f1.entity.DriverStandings;
import com.dev.f1.utils.Queries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverStandingsRepository extends JpaRepository<DriverStandings, Integer> {
    @Query(value = "select c.driverId, b.year as year, concat(c.forename, ' ', c.surname) as driverName " +
            "             from driverstandings a inner join (select max(raceId) raceId, year " +
            "             from races group by year order by year) b on " +
            "             a.raceId=b.raceId inner join drivers c on a.driverId=c.driverId where " +
            "             a.position=1 order by b.year desc", nativeQuery = true)
    List<WorldChampionsVO> findWorldDriverChampions();
}
