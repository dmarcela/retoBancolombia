package com.app.rest.controler;

import com.app.rest.dto.CountriesDTO;
import com.app.rest.service.CountriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountriesController {

    @Autowired
    private final CountriesService countriesService;
    @GetMapping
    public ResponseEntity<List<CountriesDTO>> getCountryByName() {
        return new ResponseEntity<>(countriesService.getCountries(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCountries(@RequestBody CountriesDTO countries) {

    }

}


