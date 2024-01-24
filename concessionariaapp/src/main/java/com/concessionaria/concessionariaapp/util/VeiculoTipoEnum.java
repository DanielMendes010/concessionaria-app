package com.concessionaria.concessionariaapp.util;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum VeiculoTipoEnum {
    CARRO("Carro"),
    MOTO("Moto");
    public String tipo;

    VeiculoTipoEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @JsonCreator
    public static VeiculoTipoEnum getEnumObject(String tipoObject) {
        for (VeiculoTipoEnum tipos : values()) {
            if (tipos.tipo.equals(tipoObject)) {
                return tipos;
            }
        }
        throw new IllegalArgumentException();
    }
}
