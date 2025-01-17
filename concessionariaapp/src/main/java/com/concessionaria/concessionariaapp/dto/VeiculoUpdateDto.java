package com.concessionaria.concessionariaapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VeiculoUpdateDto(
        String tipo,
        String nome,
        int ano,
        String modelo,
        String marca,
        double price,
        @JsonProperty("details")
        VeiculoDetailsDto veiculoDetailsDto
) {
}
