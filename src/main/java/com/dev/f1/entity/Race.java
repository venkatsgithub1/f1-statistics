package com.dev.f1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "races")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Race {
    @Id
    private Integer raceId;
    private Integer year;
    private Integer round;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuitId")
    @JsonIgnoreProperties("races")
    private Circuit circuitId;
    private String name;
    private LocalDate date;
    private Time time;
    private String url;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "raceId")
    @JsonIgnoreProperties("raceId")
    private Set<ConstructorResult> constructorResults;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "raceId")
    @JsonIgnoreProperties("raceId")
    private Set<DriverStandings> driverStandings;

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Circuit getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Circuit circuitId) {
        this.circuitId = circuitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Races{" +
                "raceId=" + raceId +
                ", year=" + year +
                ", round=" + round +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", url='" + url + '\'' +
                '}';
    }

    public Set<DriverStandings> getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(Set<DriverStandings> driverStandings) {
        this.driverStandings = driverStandings;
    }
}
