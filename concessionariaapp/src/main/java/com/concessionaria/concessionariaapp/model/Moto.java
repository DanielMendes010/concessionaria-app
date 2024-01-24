package com.concessionaria.concessionariaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Moto")
public class Moto extends Veiculo {
    @Column(name = "cilindradas")
    private double cilindradas;
    @Column(name = "moto_tipo")
    private String motoTipo;

    public Moto() {};
    public Moto(int id, String tipo, String nome, int ano,
                String modelo, String marca, double price,
                double cilindradas, String motoTipo) {
        super(id, tipo, nome, ano, modelo, marca, price);
        this.cilindradas = cilindradas;
        this.motoTipo = motoTipo;
    }

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getMotoTipo() {
        return motoTipo;
    }

    public void setMotoTipo(String motoTipo) {
        this.motoTipo = motoTipo;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindradas=" + cilindradas +
                ", tipo='" + motoTipo + '\'' +
                '}';
    }
}
