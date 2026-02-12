package com.example.subwayfinder.service;

import com.example.subwayfinder.dto.LocationDto;
import com.example.subwayfinder.dto.StationDto;
import com.example.subwayfinder.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class SubwayService {

    private final StationRepository stationRepository;

    public SubwayService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Map<String, String>> getDeparturesByLocation(LocationDto userLocation) {
        List<StationDto> allStations = stationRepository.findAll();

        if (allStations.isEmpty()) {
            return Collections.emptyList();
        }

        // Find the closest station
        StationDto closestStation = allStations.stream()
                .min(Comparator.comparing(station ->
                        distance(userLocation.getLatitude(), userLocation.getLongitude(),
                                 station.getLatitude(), station.getLongitude())))
                .orElse(null);

        System.out.println("Closest station found: " + closestStation.getStationName());

        // TODO: Call the real-time API for the closestStation.getStationName()
        // For now, return a mock list of departures for the found station.
        return List.of(
                Map.of("trainNo", "2112", "subwayNm", "2호선", "statnTnm", "잠실 방면", "recptnDt", "1분 전", "trainSttus", "출발"),
                Map.of("trainNo", "2113", "subwayNm", "2호선", "statnTnm", "신도림 방면", "recptnDt", "2분 전", "trainSttus", "도착"),
                Map.of("trainNo", "2114", "subwayNm", "2호선", "statnTnm", "잠실 방면", "recptnDt", "5분 후", "trainSttus", "진입")
        );
    }

    /**
     * Calculate distance between two points in latitude and longitude.
     * Uses Haversine method as its base.
     * @return Distance in Meters
     */
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        return distance;
    }
}
