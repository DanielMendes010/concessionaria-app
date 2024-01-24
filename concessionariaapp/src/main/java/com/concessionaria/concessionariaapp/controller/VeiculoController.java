package com.concessionaria.concessionariaapp.controller;

import com.concessionaria.concessionariaapp.model.Carro;
import com.concessionaria.concessionariaapp.model.Moto;
import com.concessionaria.concessionariaapp.model.Veiculo;
import com.concessionaria.concessionariaapp.repository.VeiculoRepository;
import com.concessionaria.concessionariaapp.util.VeiculoTipoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("concessionaria")
public class VeiculoController {
    @Autowired
    VeiculoRepository veiculoRepository;

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
    public ResponseEntity<Veiculo> getById(@PathVariable("id") long id) {
            Optional<Veiculo> veiculosData = veiculoRepository.findById(id);

            if (veiculosData.isPresent()) {
                return new ResponseEntity<>(veiculosData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

    @PostMapping("/veiculos")
    public ResponseEntity<Veiculo> postVeiculo(@RequestBody Veiculo veiculo) {
        try {
            if (veiculo.getTipo().equals(VeiculoTipoEnum.CARRO.getTipo())) {
                Carro postCarro = (Carro) veiculo;
                Carro newCarro =
                        new Carro(postCarro.getId(),
                                postCarro.getTipo(),
                                postCarro.getNome(),
                                postCarro.getAno(),
                                postCarro.getModelo(),
                                postCarro.getMarca(),
                                postCarro.getPrice(),
                                postCarro.getCarroTipo(),
                                postCarro.getPortas(),
                                postCarro.getDirecao(),
                                postCarro.getMotor());

                saveVeiculo(newCarro);

            return new ResponseEntity<>(newCarro, HttpStatus.CREATED);
            } else {
                Moto postMoto = (Moto) veiculo;
                Moto newMoto =
                        new Moto(postMoto.getId(),
                                postMoto.getTipo(),
                                postMoto.getNome(),
                                postMoto.getAno(),
                                postMoto.getModelo(),
                                postMoto.getMarca(),
                                postMoto.getPrice(),
                                postMoto.getCilindradas(),
                                postMoto.getMotoTipo());

                saveVeiculo(newMoto);

                return new ResponseEntity<>(newMoto, HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable long id, @RequestBody Veiculo veiculo) {
        Optional<Veiculo> veiculoData = veiculoRepository.findById(id);

        if (veiculoData.isPresent()) {
            if (veiculoData.get().getTipo().equals(VeiculoTipoEnum.CARRO.getTipo())) {
                Carro veiculoToCarro = (Carro) veiculo;
                Carro updateCarro = (Carro) veiculoData.get();
                updateCarro.setNome(veiculoToCarro.getNome());
                updateCarro.setAno(veiculoToCarro.getAno());
                updateCarro.setMarca(veiculoToCarro.getMarca());
                updateCarro.setModelo(veiculoToCarro.getModelo());
                updateCarro.setPrice(veiculoToCarro.getPrice());
                updateCarro.setCarroTipo(veiculoToCarro.getCarroTipo());
                updateCarro.setDirecao(veiculoToCarro.getDirecao());
                updateCarro.setMotor(veiculoToCarro.getMotor());
                updateCarro.setPortas(veiculoToCarro.getPortas());

                return new ResponseEntity<>(veiculoRepository.save(updateCarro), HttpStatus.OK);
            } else {
                Moto veiculoToMoto = (Moto) veiculo;
                Moto updateMoto = (Moto) veiculoData.get();
                updateMoto.setNome(veiculoToMoto.getNome());
                updateMoto.setAno(veiculoToMoto.getAno());
                updateMoto.setMarca(veiculoToMoto.getMarca());
                updateMoto.setModelo(veiculoToMoto.getModelo());
                updateMoto.setPrice(veiculoToMoto.getPrice());
                updateMoto.setMotoTipo(veiculoToMoto.getMotoTipo());
                updateMoto.setCilindradas(veiculoToMoto.getCilindradas());

                return new ResponseEntity<>(veiculoRepository.save(updateMoto), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<Veiculo> deleteVeiculoById(@PathVariable long id) {
        try {
            veiculoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/veiculos")
    public ResponseEntity<Veiculo> deleteAllVeiculos() {
        try {
            veiculoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void saveVeiculo(Veiculo veiculo) {
        if (veiculo.getTipo().equals(VeiculoTipoEnum.CARRO.getTipo())) {
            Carro newCarro = (Carro) veiculo;
            veiculoRepository.save(
                    new Carro(newCarro.getId(),
                            newCarro.getTipo(),
                            newCarro.getNome(),
                            newCarro.getAno(),
                            newCarro.getModelo(),
                            newCarro.getMarca(),
                            newCarro.getPrice(),
                            newCarro.getCarroTipo(),
                            newCarro.getPortas(),
                            newCarro.getDirecao(),
                            newCarro.getMotor()));
        } else {
            Moto newMoto = (Moto) veiculo;
            veiculoRepository.save(
                    new Moto(newMoto.getId(),
                            newMoto.getTipo(),
                            newMoto.getNome(),
                            newMoto.getAno(),
                            newMoto.getModelo(),
                            newMoto.getMarca(),
                            newMoto.getPrice(),
                            newMoto.getCilindradas(),
                            newMoto.getMotoTipo()));
        }
    }

}
