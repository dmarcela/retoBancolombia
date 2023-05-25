package com.app.rest.controller;

import com.app.rest.dto.CountriesDTO;
import com.app.rest.service.CountriesService;
import com.app.rest.service.impl.CountriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountriesController {

    @Autowired
    private final CountriesServiceImpl countriesService;

    @GetMapping("/{name}")
    public ResponseEntity<CountriesDTO> getCountryByName(@PathVariable("name") String name){
        CountriesDTO countriesDTO = countriesService.getCountrieByName(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(countriesDTO);
    }

}


