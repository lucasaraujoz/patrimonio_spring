package com.example.demo.service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.InvestimentoRepository;
import com.example.demo.repositories.PosicaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.service.exceptions.RegraNegocioRunTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    UsuarioService service;
    @Autowired
    UsuarioRepository repository;
    @Autowired
    InvestimentoRepository investimentoRep;
    @Autowired
    PosicaoRepository posicaoRep;

    @Test
    public void deveGerarErroAoTentarSalvarSemNome() {
        Usuario usr = Usuario.builder()
                .email("teste")
                .senha("123")
                .build();
        Assertions.assertThrows(RegraNegocioRunTime.class,
                () -> service.salvar(usr),
                "Nome do usuário deve ser informado");
    }
}
