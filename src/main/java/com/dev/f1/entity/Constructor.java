package com.dev.f1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "constructors")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Constructor {
    @Id
    private Integer constructorId;
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;
    @OneToMany(mappedBy = "constructorId", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("constructorId")
    private Set<ConstructorResult> constructorResults;

    public Integer getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(Integer constructorId) {
        this.constructorId = constructorId;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public void setConstructorRef(String constructorRef) {
        this.constructorRef = constructorRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<ConstructorResult> getConstructorResults() {
        return constructorResults;
    }

    public void setConstructorResults(Set<ConstructorResult> constructorResults) {
        this.constructorResults = constructorResults;
    }
}
