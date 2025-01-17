package com.concessionaria.concessionariaapp.model;

import com.concessionaria.concessionariaapp.dto.VeiculoCreationDto;
import com.concessionaria.concessionariaapp.dto.VeiculoUpdateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carro")
public class Carro extends Veiculo {
    @Column(name = "details")
    @Embedded
    private VeiculoDetails carroDetails;

    public Carro(){}

    public Carro(String tipo, String nome, int ano, String modelo,
                 String marca, double price, String carroTipo,
                 int portas, String direcao, double motor) {
        super(tipo, nome, ano, modelo, marca, price);
        this.carroDetails = new CarroDetails();
    }

    public Carro(VeiculoCreationDto dto) {
        this.tipo = dto.tipo();
        this.nome = dto.nome();
        this.ano = dto.ano();
        this.modelo = dto.modelo();
        this.marca = dto.marca();
        this.carroDetails = new CarroDetails(dto.veiculoDetailsDto());
    }

    public VeiculoDetails getCarroDetails() {
        return carroDetails;
    }

    public void updateCarro(VeiculoUpdateDto veiculoUpdateDto) {
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
                this.carroDetails.updateDetails(veiculoUpdateDto.veiculoDetailsDto());
            }
    }
}
