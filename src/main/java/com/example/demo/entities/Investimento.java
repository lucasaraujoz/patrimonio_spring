package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investimento")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investimento")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn (name="usuario_id")
    private Usuario usuario;
}