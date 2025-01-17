package com.concessionaria.concessionariaapp.dto;

public record VeiculoDetailsDto(
        String carroTipo,
        int portas,
        String direcao,
        double motor,
        String motoTipo,
        double cilindradas
) {
}
