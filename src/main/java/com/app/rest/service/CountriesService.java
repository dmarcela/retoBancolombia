package com.app.rest.service;

import com.app.rest.dto.CountriesDTO;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
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

        String  jsonStr = restTemplate.getForObject(url + "/colombia", String.class);
        String jsonStrFinal = jsonStr.substring(1, jsonStr.length() - 1);
        JSONObject json = new JSONObject(jsonStrFinal);
        System.out.println(json);
        Integer population = (Integer) json.get("population");
        Double area = (Double) json.get("area");

        System.out.println("population " + population);
        System.out.println("area "+ area);

        return null;

    }


}
