package com.example.subwayfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StationDto {
    private String stationName;
    private String lineNumber;
    private double latitude;
    private double longitude;
}
