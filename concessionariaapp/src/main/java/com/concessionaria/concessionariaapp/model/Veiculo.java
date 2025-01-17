package com.concessionaria.concessionariaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "veiculo")
@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "tipo",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Carro.class, name = "Carro"),
        @JsonSubTypes.Type(value = Moto.class, name = "Moto")
})
public abstract class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String tipo;
    protected String nome;
    protected int ano;
    protected String modelo;
    protected String marca;
    protected double price;

    public Veiculo() {}

    public Veiculo(@JsonProperty("tipo") String tipo, String nome, int ano, String modelo, String marca, double price) {
        this.tipo = tipo != null ? VeiculoTipoEnum.getEnumObject(tipo).getTipo() : null;
        this.nome = nome;
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return tipo == veiculo.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

}
