package com.example.demo.service;


import com.example.demo.dto.InvestimentoSaldo;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.service.exceptions.RegraNegocioRunTime;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
//    public boolean efetuarLogin(String email, String senha){
//        Optional<Usuario> usr = usuarioRepository.findByEmail(email);
//        if(!usr.isPresent())
//            throw new RegraNegocioRunTime("Erro de autenticação. Email informado não encontrado.");
//        if(usr.get().getSenha().equals(senha))
//            throw new RegraNegocioRunTime("Erro de autenticação. Senha inválida");
//        return true;
//    }
    private void verificarUsuario(Usuario usuario) {
        if (usuario == null)
            throw new RegraNegocioRunTime("Um usuário válido deve ser informado");
        if ((usuario.getNome() == null) || (usuario.getNome().equals("")))
            throw new RegraNegocioRunTime("Nome do usuário deve ser informado");
        if ((usuario.getEmail() == null) || (usuario.getEmail().equals("")))
            throw new RegraNegocioRunTime("Email deve ser informado");
        boolean teste = usuarioRepository.existsByEmail(usuario.getEmail());
        if (teste)
            throw new RegraNegocioRunTime("Email informado já existe na base");
        if ((usuario.getSenha() == null) || (usuario.getSenha().equals("")))
            throw new RegraNegocioRunTime("Usuário deve possui senha");
    }
    @Transactional
    public Usuario salvar(Usuario usuario) {
        verificarUsuario(usuario);
        return usuarioRepository.save(usuario);
    }

//    public List<InvestimentoSaldo> obterSaldos(Long idUsuario) {
//        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
//        if (usuario.isPresent())
//            return usuarioRepository.obterSaldosInvestimentos(usuario.get());
//        throw new RegraNegocioRunTime("Usuario inválido");
//    }
}
