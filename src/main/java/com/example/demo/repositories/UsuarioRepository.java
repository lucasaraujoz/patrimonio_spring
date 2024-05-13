package com.example.demo.repositories;

import com.example.demo.dto.InvestimentoSaldo;
import com.example.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);


//    @Query("select new com.labprog.patrimonio.model.dto.InvestimentoSaldo(i, sum(p.valor)) " +
//            "from Posicao p join p.investimento i "+
//            "where i.usuario = :usuario " +
//            "group by i")
//    List<InvestimentoSaldo> obterSaldosInvestimentos(@Param("usuario") Usuario usuario);
}
