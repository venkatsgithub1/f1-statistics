package com.dev.f1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverStandingOverTheYearsVO {
    private int year;
    private int position;
    private float points;
}
