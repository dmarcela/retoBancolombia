package com.app.rest.service;

import com.app.rest.dto.CountriesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesService {

    private final RestTemplate RestTemplate;

    public List<CountriesDTO> getCountries(){

        return null;
    }
}
