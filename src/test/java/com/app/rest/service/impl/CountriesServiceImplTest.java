package com.app.rest.service.impl;
import com.app.rest.dto.CountriesDTO;
import com.app.rest.exeption.ModelNotFoundException;
import com.app.rest.model.Log;
import com.app.rest.repository.ILogsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CountriesServiceImplTest {
    public static final String COLOMBIA = "colombia";
    public static final String JSON_MOCK = "[{\"name\":\"colombia\",\"population\":100000,\"area\":200.0}]";
    public static final String NO_SE_ENCONTRO_EL_REGISTRO = "No se encontro el registro";
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ILogsRepository logsRepository;

    @InjectMocks
    private CountriesServiceImpl countriesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCountryByNameSuccessful() {

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(JSON_MOCK);

        CountriesDTO result = countriesService.getCountrieByName(COLOMBIA);

        verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
        verify(logsRepository, times(1)).save(any(Log.class));

        assertEquals(COLOMBIA, result.getName());
        assertEquals(100000, result.getPopulation());
        assertEquals(200.0, result.getArea());
    }

    @Test
    public void testGetCountryByNameFailed() {

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenThrow(
                new RuntimeException());

        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> {
            countriesService.getCountrieByName(COLOMBIA);
        });

        verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
        verify(logsRepository, times(1)).save(any(Log.class));

        assertEquals(NO_SE_ENCONTRO_EL_REGISTRO, exception.getMessage());
    }


}