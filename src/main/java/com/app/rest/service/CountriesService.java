package com.app.rest.service;

import com.app.rest.dto.CountriesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesService {

    private final RestTemplate restTemplate;
private String url="https://restcountries.com/v3.1/name";
    public List<CountriesDTO> getCountries(){
        CountriesDTO[] response = restTemplate.getForObject(url + "/colombia", CountriesDTO[].class);
        return Arrays.asList(response);

    }
}
