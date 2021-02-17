package com.dev.f1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Driver {
    @Id
    private Integer driverId;
    private String driverRef;
    private Integer number;
    private String code;
    private String forename;
    private String surname;
    private LocalDate dob;
    private String nationality;
    private String url;
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(mappedBy = "driverId", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("driverId")
    private Set<DriverStandings> driverStandings;

    public Integer getDriverId() {
        return driverId;
    }

    public String getDriverRef() {
        return driverRef;
    }

    public void setDriverRef(String driverRef) {
        this.driverRef = driverRef;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<DriverStandings> getDriverStandings() {
        return driverStandings;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverRef='" + driverRef + '\'' +
                ", number=" + number +
                ", code='" + code + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
