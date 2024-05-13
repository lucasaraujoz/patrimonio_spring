package com.example.demo.repositories;

import com.example.demo.entities.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}
