package com.example.demo.repositories;

import com.example.demo.entities.Investimento;
import com.example.demo.entities.Posicao;
import com.example.demo.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioRepositoryTest {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InvestimentoRepository investimentoRepository;
    @Autowired
    PosicaoRepository posicaoRepository;

    @Test
    public void deveVerificarSalvarUsuario() {
        // cenario
        Usuario user = Usuario.builder().nome("Teste").email("teste@teste.com").senha("123").build();

        // ação
        Usuario salvo = usuarioRepository.save(user); // salva?
        // verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(user.getNome(), salvo.getNome());
        Assertions.assertEquals(user.getEmail(), salvo.getEmail());
        Assertions.assertEquals(user.getSenha(), salvo.getSenha());
        Assertions.assertEquals(user.getNome(), salvo.getNome());
    }

    @Test
    public void deveVerificarRemoverUsuario() {
        //cenário
        Usuario user = Usuario.builder().nome("Teste")
                .email("teste@teste.com")
                .senha("123").build();
        //ação
        Usuario salvo = usuarioRepository.save(user);  //salva
        Long id = salvo.getId();
        usuarioRepository.deleteById(salvo.getId());
        //verificação
        Optional<Usuario> temp = usuarioRepository.findById(id);
        Assertions.assertFalse(temp.isPresent());
    }

    @Test
    public void deveVerificarSaldoInvestimentos() {
        //cenário
        Usuario user = Usuario.builder().nome("Teste")
                .email("teste@teste.com")
                .senha("123").build();
        Usuario salvo = usuarioRepository.save(user);
        Investimento inv1 = Investimento.builder()
                .nome("Primeiro")
                .usuario(salvo).build();
        Investimento inv1Salvo = investimentoRepository.save(inv1);
        Posicao p1 = Posicao.builder()
                .valor(500.0)
                .data(new Date())
                .investimento(inv1Salvo).build();
        Posicao p2 = Posicao.builder().valor(500.0).data(new Date()).investimento(inv1Salvo).build();
        Posicao p1salvo = posicaoRepository.save(p1);
        Posicao p2salvo = posicaoRepository.save(p2);
    }
}
