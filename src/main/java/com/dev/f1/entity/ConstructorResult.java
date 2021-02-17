package com.dev.f1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "constructorresults")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ConstructorResult {
    @Id
    private Integer constructorResultsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    @JsonIgnoreProperties("constructorResults")
    private Race raceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructorId")
    @JsonIgnoreProperties("constructorResults")
    private Constructor constructorId;
    private Float points;
    private String status;

    public Integer getConstructorResultsId() {
        return constructorResultsId;
    }

    public void setConstructorResultsId(Integer constructorResultsId) {
        this.constructorResultsId = constructorResultsId;
    }

    public Race getRaceId() {
        return raceId;
    }

    public void setRaceId(Race raceId) {
        this.raceId = raceId;
    }

    public Constructor getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(Constructor constructorId) {
        this.constructorId = constructorId;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
