package com.concessionaria.concessionariaapp.dto;

import com.concessionaria.concessionariaapp.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoInformation(
        @NotBlank String tipo,
        @NotBlank String nome,
        @NotNull int ano,
        @NotBlank String modelo,
        @NotBlank String marca,
        @NotNull double price
) {
    public VeiculoInformation(Veiculo veiculo) {
        this(veiculo.getTipo(), veiculo.getNome(), veiculo.getAno(), veiculo.getModelo(), veiculo.getMarca(), veiculo.getPrice());
    }
}
