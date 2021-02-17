package com.dev.f1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverConstructorsVO {
    private int startYear;
    private int endYear;
    private int constructorId;
    private String constructorName;
}
