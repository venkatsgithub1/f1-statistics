package com.dev.f1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "circuits")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Circuit {
    @Id
    private Integer circuitId;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private Float lat;
    private Float lng;
    private Integer alt;
    private String url;
    @OneToMany(mappedBy = "circuitId", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("circuitId")
    private Set<Race> races;

    public Integer getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Integer circuitId) {
        this.circuitId = circuitId;
    }

    public String getCircuitRef() {
        return circuitRef;
    }

    public void setCircuitRef(String circuitRef) {
        this.circuitRef = circuitRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Integer getAlt() {
        return alt;
    }

    public void setAlt(Integer alt) {
        this.alt = alt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public void setRaces(Set<Race> races) {
        this.races = races;
    }

    @Override
    public String toString() {
        return "Circuits{" +
                "circuitId=" + circuitId +
                ", circuitRef='" + circuitRef + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", alt=" + alt +
                ", url='" + url + '\'' +
                '}';
    }
}
