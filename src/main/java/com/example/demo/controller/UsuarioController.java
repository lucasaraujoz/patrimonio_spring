package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.exceptions.RegraNegocioRunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()).build();
        try {
            Usuario salvo = usuarioService.salvar(usuario);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
