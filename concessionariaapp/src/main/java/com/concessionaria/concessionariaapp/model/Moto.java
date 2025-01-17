package com.concessionaria.concessionariaapp.model;

import com.concessionaria.concessionariaapp.dto.VeiculoCreationDto;
import com.concessionaria.concessionariaapp.dto.VeiculoUpdateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Moto")
public class Moto extends Veiculo {
    @Column(name = "details")
    @Embedded
    private VeiculoDetails motoDetails;

    public Moto() {}

    public Moto(String tipo, String nome, int ano,
                String modelo, String marca, double price,
                double cilindradas, String motoTipo) {
        super(tipo, nome, ano, modelo, marca, price);
        this.motoDetails = new MotoDetails();
    }

    public Moto(VeiculoCreationDto dto) {
        this.tipo = dto.tipo();
        this.nome = dto.nome();
        this.ano = dto.ano();
        this.modelo = dto.modelo();
        this.marca = dto.marca();
        this.price = dto.price();
        this.motoDetails = new MotoDetails(dto.veiculoDetailsDto());
    }

    public VeiculoDetails getMotoDetails() {
        return motoDetails;
    }

    public void updateMoto(VeiculoUpdateDto veiculoUpdateDto) {
        if (veiculoUpdateDto.tipo() != null) {
            this.tipo = veiculoUpdateDto.tipo();
        }
        if (veiculoUpdateDto.nome() != null) {
            this.nome = veiculoUpdateDto.nome();
        }
        if (veiculoUpdateDto.ano() != 0) {
            this.ano = veiculoUpdateDto.ano();
        }
        if (veiculoUpdateDto.modelo() != null) {
            this.modelo = veiculoUpdateDto.modelo();
        }
        if (veiculoUpdateDto.marca() != null) {
            this.marca = veiculoUpdateDto.marca();
        }
        if (veiculoUpdateDto.price() != 0) {
            this.price = veiculoUpdateDto.price();
        }
        if (veiculoUpdateDto.veiculoDetailsDto() != null) {
            this.motoDetails.updateDetails(veiculoUpdateDto.veiculoDetailsDto());
        }
    }
}
