package com.app.rest.controller;


import com.app.rest.dto.CountriesDTO;
import com.app.rest.service.impl.CountriesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CountriesControllerTest {

    @Mock
    private CountriesServiceImpl countriesService;

    @InjectMocks
    private CountriesController countriesController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCountryByName() {
        String countryName = "CountryName";
        CountriesDTO mockDTO = new CountriesDTO();
        mockDTO.setName(countryName);

        when(countriesService.getCountrieByName(countryName)).thenReturn(mockDTO);

        ResponseEntity<CountriesDTO> response = countriesController.getCountryByName(countryName);

        verify(countriesService, times(1)).getCountrieByName(countryName);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockDTO, response.getBody());
    }

}