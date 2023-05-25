package com.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
@AllArgsConstructor
public class CountriesDTO {
    private String name;
    private Integer population;
    private Double area;

    public CountriesDTO() {

    }
}
