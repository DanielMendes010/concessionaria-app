package com.concessionaria.concessionariaapp.service;

import com.concessionaria.concessionariaapp.dto.VeiculoCreationDto;
import com.concessionaria.concessionariaapp.dto.VeiculoDetailsDto;
import com.concessionaria.concessionariaapp.model.Carro;
import com.concessionaria.concessionariaapp.model.Veiculo;
import com.concessionaria.concessionariaapp.model.VeiculoTipoEnum;
import com.concessionaria.concessionariaapp.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    @Captor
    private ArgumentCaptor<Veiculo> veiculoArgumentCaptor;

    @Test
    void shouldCreateAndSaveVeiculoWithSuccess() {
        //Arrange
        VeiculoCreationDto veiculoCreationDto = createVeiculoDto();
        Veiculo veiculo = new Carro(veiculoCreationDto);
        when(veiculoRepository.save(veiculoArgumentCaptor.capture())).thenReturn(veiculo);

        //Act
        veiculoService.saveVeiculo(veiculoCreationDto);

        //Assert
        var veiculoCaptor = veiculoArgumentCaptor.getValue();
        assertEquals(veiculoCreationDto.tipo(), veiculoCaptor.getTipo());
        assertEquals(veiculoCreationDto.nome(), veiculoCaptor.getNome());
        assertEquals(veiculoCreationDto.ano(), veiculoCaptor.getAno());
    }

    private VeiculoCreationDto createVeiculoDto() {
        return new VeiculoCreationDto(
                VeiculoTipoEnum.CARRO.getTipo(),
                "vectra",
                2000,
                "flex",
                "chevrolet",
                20.0,
                new VeiculoDetailsDto(
                        "seda",
                        4,
                        "hidraulica",
                        2.0,
                        null,
                        0.0
                )
        );
    }

}