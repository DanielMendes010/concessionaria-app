package com.concessionaria.concessionariaapp.model;

import com.concessionaria.concessionariaapp.util.VeiculoTipoEnum;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "tipo")
    protected String tipo;
    @Column(name = "nome")
    protected String nome;
    @Column(name = "ano")
    protected int ano;
    @Column(name = "modelo")
    protected String modelo;
    @Column(name = "marca")
    protected String marca;
    @Column(name = "price")
    protected double price;

    public Veiculo() {}

    public Veiculo(int id, @JsonProperty("tipo") String tipo, String nome, int ano, String modelo, String marca, double price) {
        this.id = id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano='" + ano + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", price=" + price +
                '}';
    }
}
