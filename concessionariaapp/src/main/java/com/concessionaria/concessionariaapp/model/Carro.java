package com.concessionaria.concessionariaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carro")
public class Carro extends Veiculo {
    @Column(name = "carro_tipo")
    private String carroTipo;
    @Column(name = "portas")
    private int portas;
    @Column(name = "direcao")
    private String direcao;
    @Column(name = "motor")
    private double motor;

    public Carro(){};
    public Carro(int id, String tipo, String nome, int ano, String modelo,
                 String marca, double price, String carroTipo,
                 int portas, String direcao, double motor) {
        super(id, tipo, nome, ano, modelo, marca, price);
        this.carroTipo = carroTipo;
        this.portas = portas;
        this.direcao = direcao;
        this.motor = motor;
    }

    public String getCarroTipo() {
        return carroTipo;
    }

    public void setCarroTipo(String carroTipo) {
        this.carroTipo = carroTipo;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "carroTipo='" + carroTipo + '\'' +
                ", portas=" + portas +
                ", direcao='" + direcao + '\'' +
                ", motor=" + motor +
                '}';
    }

}
