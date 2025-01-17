package com.concessionaria.concessionariaapp.model;

import com.concessionaria.concessionariaapp.dto.VeiculoDetailsDto;
import jakarta.persistence.Embeddable;

@Embeddable
public class CarroDetails implements VeiculoDetails {
    private String carroTipo;
    private int portas;
    private String direcao;
    private double motor;

    public CarroDetails() {}

    public CarroDetails(VeiculoDetailsDto veiculoDetailsDto) {
        this.carroTipo = veiculoDetailsDto.carroTipo();
        this.portas = veiculoDetailsDto.portas();
        this.direcao = veiculoDetailsDto.direcao();
        this.motor = veiculoDetailsDto.motor();
    }

    public String getCarroTipo() {
        return carroTipo;
    }

    public int getPortas() {
        return portas;
    }

    public String getDirecao() {
        return direcao;
    }

    public double getMotor() {
        return motor;
    }

    @Override
    public void updateDetails(VeiculoDetailsDto veiculoDetailsDto) {
        if (veiculoDetailsDto.carroTipo() != null) {
            this.carroTipo = veiculoDetailsDto.carroTipo();
        }
        if (veiculoDetailsDto.portas() != 0) {
            this.portas = veiculoDetailsDto.portas();
        }
        if (veiculoDetailsDto.direcao() != null) {
            this.direcao = veiculoDetailsDto.direcao();
        }
        if (veiculoDetailsDto.motor() != 0) {
            this.motor = veiculoDetailsDto.motor();
        }
    }
}
