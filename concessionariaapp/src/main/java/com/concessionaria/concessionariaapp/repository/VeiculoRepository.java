package com.concessionaria.concessionariaapp.repository;

import com.concessionaria.concessionariaapp.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByNome(String name);

}
