package com.example.subwayfinder.repository;

import com.example.subwayfinder.dto.StationDto;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StationRepository {

    private final List<StationDto> stations = new ArrayList<>();

    @PostConstruct
    public void init() {
        // TODO: The user needs to download the station coordinate file from 
        // https://www.data.go.kr/data/15041130/fileData.do
        // and place it as 'stations.csv' in the 'src/main/resources' directory.
        // The CSV should have columns: station_name,line_number,latitude,longitude
        
        // For now, using a mock list.
        stations.add(new StationDto("강남", "2호선", 37.4979, 127.0276));
        stations.add(new StationDto("역삼", "2호선", 37.5007, 127.0363));
        stations.add(new StationDto("삼성", "2호선", 37.5088, 127.0631));
        stations.add(new StationDto("신도림", "2호선", 37.5088, 126.8913));

        // This is a placeholder for the actual file loading logic.
        /*
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("stations.csv")) {
            if (is == null) {
                System.err.println("stations.csv not found in resources. Please add it.");
                return;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                // Skip header line if it exists
                // reader.readLine(); 
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    // Assuming format: station_name,line_number,latitude,longitude
                    stations.add(new StationDto(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public List<StationDto> findAll() {
        return stations;
    }
}
