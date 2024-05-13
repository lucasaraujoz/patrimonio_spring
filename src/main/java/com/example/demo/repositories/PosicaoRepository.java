package com.example.demo.repositories;

import com.example.demo.entities.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository extends JpaRepository<Posicao, Long> {
}
