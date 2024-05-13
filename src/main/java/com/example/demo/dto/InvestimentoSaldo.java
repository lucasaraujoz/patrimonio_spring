package com.example.demo.dto;

import com.example.demo.entities.Investimento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvestimentoSaldo {
    public Investimento inv;
    public Double valor;
}
