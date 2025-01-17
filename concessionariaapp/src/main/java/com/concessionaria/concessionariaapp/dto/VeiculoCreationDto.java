package com.concessionaria.concessionariaapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoCreationDto(
        @NotBlank String tipo,
        @NotBlank String nome,
        @NotNull int ano,
        @NotBlank String modelo,
        @NotBlank String marca,
        @NotNull double price,
        VeiculoDetailsDto veiculoDetailsDto) {
}
