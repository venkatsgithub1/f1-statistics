package com.dev.f1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldChampionsVO {
    private int driverId;
    private int year;
    private String driverName;
}
