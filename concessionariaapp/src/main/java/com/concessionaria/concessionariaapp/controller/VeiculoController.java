package com.concessionaria.concessionariaapp.controller;

import com.concessionaria.concessionariaapp.dto.VeiculoCreationDto;
import com.concessionaria.concessionariaapp.dto.VeiculoInformation;
import com.concessionaria.concessionariaapp.dto.VeiculoUpdateDto;
import com.concessionaria.concessionariaapp.model.Veiculo;
import com.concessionaria.concessionariaapp.repository.VeiculoRepository;
import com.concessionaria.concessionariaapp.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("concessionaria")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> getAllVeiculos(String nome) {
        try {
            List<Veiculo> veiculos = new ArrayList<>();

            if (nome == null) {
                veiculoRepository.findAll().forEach(veiculos::add);
            } else {
                veiculoRepository.findByNome(nome).forEach(veiculos::add);
            }

            if (veiculos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(veiculos, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<VeiculoInformation> getById(@PathVariable("id") long id) {
        VeiculoInformation veiculoInformation = veiculoService.getVeiculoById(id);

        if (veiculoInformation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(veiculoInformation, HttpStatus.OK);
    }

    @PostMapping("/veiculos")
    public ResponseEntity<VeiculoCreationDto> postVeiculo(@RequestBody VeiculoCreationDto veiculoCreationDto) {
        try {
            veiculoService.saveVeiculo(veiculoCreationDto);
            return new ResponseEntity<>(veiculoCreationDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<VeiculoUpdateDto> updateVeiculo(@PathVariable long id, @RequestBody VeiculoUpdateDto veiculoUpdateDto) {
        try {
            var veiculo = veiculoService.updateVeiculo(id, veiculoUpdateDto);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity deleteVeiculoById(@PathVariable long id) {
        try {
            veiculoService.deleteVeiculo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/veiculos")
    public ResponseEntity deleteAllVeiculos() {
        try {
            veiculoService.deleteAllVeiculos();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
