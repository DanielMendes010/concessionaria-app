package com.concessionaria.concessionariaapp.service;

import com.concessionaria.concessionariaapp.dto.VeiculoCreationDto;
import com.concessionaria.concessionariaapp.dto.VeiculoInformation;
import com.concessionaria.concessionariaapp.dto.VeiculoUpdateDto;
import com.concessionaria.concessionariaapp.model.Carro;
import com.concessionaria.concessionariaapp.model.Moto;
import com.concessionaria.concessionariaapp.model.Veiculo;
import com.concessionaria.concessionariaapp.model.VeiculoTipoEnum;
import com.concessionaria.concessionariaapp.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void saveVeiculo(VeiculoCreationDto veiculoCreationDto) {
        if (veiculoCreationDto.tipo().equals(VeiculoTipoEnum.CARRO.getTipo())) {
            veiculoRepository.save(new Carro(veiculoCreationDto));
        } else {
            veiculoRepository.save(new Moto(veiculoCreationDto));
        }
    }

    public VeiculoInformation getVeiculoById(long id) {
        Optional<Veiculo> veiculosData = veiculoRepository.findById(id);

        return new VeiculoInformation(veiculosData.get());
    }

    public VeiculoUpdateDto updateVeiculo(Long id, VeiculoUpdateDto veiculoUpdateDto) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.get().getTipo().equals(VeiculoTipoEnum.CARRO.getTipo())) {
            Carro carro = (Carro) veiculo.get();
            carro.updateCarro(veiculoUpdateDto);
        } else {
            Moto moto = (Moto) veiculo.get();
            moto.updateMoto(veiculoUpdateDto);
        }
        return veiculoUpdateDto;
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

    public void deleteAllVeiculos() {
        veiculoRepository.deleteAll();
    }
}
