package com.dev.f1.entity;

import com.dev.f1.model.DriverPodiumPositionsVO;
import com.dev.f1.model.WorldChampionsVO;

import javax.persistence.*;
import javax.persistence.ConstructorResult;

@SqlResultSetMappings({
        @SqlResultSetMapping(name = "driverPodiumResultsMapping", classes = {
                @ConstructorResult(targetClass = DriverPodiumPositionsVO.class, columns = {
                        @ColumnResult(name = "position", type = String.class),
                        @ColumnResult(name = "times", type = Integer.class)
                })
        })
})
@Entity
@Table(name = "results")
public class Result {
    @Id
    private int resultId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    private Race raceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driverId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructorId")
    private Constructor constructorId;
    private int number;
    private int grid;
    private int position;
    private String positionText;
    private int positionOrder;
    private Float points;
    private int laps;
    private int time;
    private int milliseconds;
    private int fastestLap;
    private int rank;
    private String fastestLapTime;
    private String fastestLapSpeed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    private Status statusId;
}
