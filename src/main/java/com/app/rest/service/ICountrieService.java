package com.app.rest.service;

import com.app.rest.dto.CountriesDTO;

public interface ICountrieService {

  CountriesDTO getCountrieByName(String name);


}
