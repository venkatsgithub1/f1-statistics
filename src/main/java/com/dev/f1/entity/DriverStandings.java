package com.dev.f1.entity;

import com.dev.f1.model.Chart1VO;
import com.dev.f1.model.DriverConstructorsVO;
import com.dev.f1.model.DriverStandingOverTheYearsVO;
import com.dev.f1.model.WorldChampionsVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.persistence.ConstructorResult;

@SqlResultSetMappings({
        @SqlResultSetMapping(name = "worldChampionsMapping" , classes = {
                @ConstructorResult(targetClass = WorldChampionsVO.class, columns = {
                        @ColumnResult(name = "driverId" , type = Integer.class),
                        @ColumnResult(name = "year" , type = Integer.class),
                        @ColumnResult(name = "driverName" , type = String.class)
                })
        }),
        @SqlResultSetMapping(name = "driverStandingsOverTheYearsMapping" , classes = {
                @ConstructorResult(targetClass = DriverStandingOverTheYearsVO.class, columns = {
                        @ColumnResult(name = "year" , type = Integer.class),
                        @ColumnResult(name = "position" , type = Integer.class),
                        @ColumnResult(name = "points" , type = Float.class)
                })
        }),
        @SqlResultSetMapping(name = "driverWinsMapping" , classes = {
                @ConstructorResult(targetClass = Chart1VO.class, columns = {
                        @ColumnResult(name = "year" , type = String.class),
                        @ColumnResult(name = "wins" , type = Integer.class)
                })
        }),
        @SqlResultSetMapping(name = "driversConstructorsMapping" , classes = {
                @ConstructorResult(targetClass = DriverConstructorsVO.class, columns = {
                        @ColumnResult(name = "startYear" , type = Integer.class),
                        @ColumnResult(name = "endYear" , type = Integer.class),
                        @ColumnResult(name = "constructorId" , type = Integer.class),
                        @ColumnResult(name = "constructorName" , type = String.class)
                })
        })
})
@Entity
@Table(name = "driverstandings")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class DriverStandings {
    @Id
    private int driverStandingsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    @JsonIgnoreProperties("driverStandings")
    private Race raceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    @JsonIgnoreProperties("driverStandings")
    private Driver driverId;
    private float points;
    private int position;
    private String positionText;
    private int wins;

    public int getDriverStandingsId() {
        return driverStandingsId;
    }

    public void setDriverStandingsId(int driverStandingsId) {
        this.driverStandingsId = driverStandingsId;
    }

    public Race getRaceId() {
        return raceId;
    }

    public void setRaceId(Race raceId) {
        this.raceId = raceId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "DriverStandings{" +
                "driverStandingsId=" + driverStandingsId +
                ", raceId=" + raceId +
                ", points=" + points +
                ", position=" + position +
                ", positionText='" + positionText + '\'' +
                ", wins=" + wins +
                '}';
    }
}
