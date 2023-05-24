package com.app.rest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class CountriesDTO {
    private String name;
    private Integer population;
    private Double area;
}
