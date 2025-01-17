package com.concessionaria.concessionariaapp.model;

import com.concessionaria.concessionariaapp.dto.VeiculoDetailsDto;
import jakarta.persistence.Embeddable;

@Embeddable
public class MotoDetails implements VeiculoDetails {
    private String motoTipo;
    private double cilindradas;

    public MotoDetails() {
    }

    public MotoDetails(VeiculoDetailsDto veiculoDetailsDto) {
        this.motoTipo = veiculoDetailsDto.motoTipo();
        this.cilindradas = veiculoDetailsDto.cilindradas();
    }

    public String getMotoTipo() {
        return motoTipo;
    }

    public double getCilindradas() {
        return cilindradas;
    }

    @Override
    public void updateDetails(VeiculoDetailsDto veiculoDetailsDto) {
        if (veiculoDetailsDto.motoTipo() != null) {
            this.motoTipo = veiculoDetailsDto.motoTipo();
        }
        if (veiculoDetailsDto.cilindradas() != 0) {
            this.cilindradas = veiculoDetailsDto.cilindradas();
        }
    }
}
