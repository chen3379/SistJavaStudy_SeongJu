package com.example.subwayfinder.controller;

import com.example.subwayfinder.dto.LocationDto;
import com.example.subwayfinder.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SubwayController {

    private final SubwayService subwayService;

    @Autowired
    public SubwayController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    @PostMapping("/find-departures-by-location")
    public List<Map<String, String>> findDeparturesByLocation(@RequestBody LocationDto location) {
        return subwayService.getDeparturesByLocation(location);
    }
}
