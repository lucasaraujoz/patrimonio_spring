package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "posicao")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posicao {
    @Id
    @Column(name="id_posicao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="valor")
    private Double valor;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date data;
    @ManyToOne
    @JoinColumn(name="investimento_id")
    private Investimento investimento;
}