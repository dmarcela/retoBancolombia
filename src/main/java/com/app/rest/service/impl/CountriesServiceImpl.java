package com.app.rest.service.impl;

import com.app.rest.dto.CountriesDTO;
import com.app.rest.exeption.ModelNotFoundException;
import com.app.rest.model.Log;
import com.app.rest.repository.ILogsRepository;
import com.app.rest.repository.impl.CRUDImpl;
import com.app.rest.service.ICountrieService;
import com.app.rest.utils.Status;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class CountriesServiceImpl extends CRUDImpl<Log, Integer> implements ICountrieService {

  public static final String SE_INTENTO_EJECUTAR_LA_CONSULTA_DEL_PAIS = "Se intento ejecutar la consulta del pais: ";
  public static final String NO_SE_ENCONTRO_EL_REGISTRO = "No se encontro el registro";
  private final RestTemplate restTemplate;
  private final ILogsRepository logsRepository;

  @Override
  protected JpaRepository<Log, Integer> getRepository() {
    return logsRepository;
  }

  @Override
  public CountriesDTO getCountrieByName(String name) {
    CountriesDTO countriesDTO = null;
    Log log = new Log();
    try {
      String jsonStr = restTemplate.getForObject(buildUrl(name), String.class);
      countriesDTO = extractJson(jsonStr, name);
      saveLog(log, name, Status.EXITOSO);
    } catch (RuntimeException re) {
      saveLog(log, name, Status.FALLIDO);
      throw new ModelNotFoundException(NO_SE_ENCONTRO_EL_REGISTRO);
    }
    return countriesDTO;
  }

  private static CountriesDTO extractJson(String jsonStr, String name) {
    CountriesDTO.CountriesDTOBuilder countrieBuilder = CountriesDTO.builder();
    String jsonStrFinal = jsonStr.substring(1, jsonStr.length() - 1);
    JSONObject json = new JSONObject(jsonStrFinal);
    var population = (Integer) json.get("population");
    var area = (Double) json.get("area");
    return countrieBuilder
        .name(name)
        .population(population)
        .area(area)
        .build();
  }

  private void saveLog(Log log, String name, Status status) {
    log.setCountrie(name);
    log.setDescription(SE_INTENTO_EJECUTAR_LA_CONSULTA_DEL_PAIS + name);
    log.setStatus(status.getStatus());
    logsRepository.save(log);
  }

  private String buildUrl(String name) {
    String url = "https://restcountries.com/v3.1/name/";
    return UriComponentsBuilder.fromUriString(url)
        .pathSegment(name)
        .build()
        .toUriString();
  }
}
