package com.example.demo.controladores;

import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.servicos.RealizarMatchingEntreUsuariosServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMatching {

    @Autowired
    private UsuarioRepository repository;

    //Traz do banco todos os entregadores proximos a posicao do solicitante
    @GetMapping("/entregadores/{posicaoSolicitante}")
    public ResponseEntity getEntregadores(@PathVariable String posicaoSolicitante) {
        RealizarMatchingEntreUsuariosServico realizarMatching = new RealizarMatchingEntreUsuariosServico(repository, posicaoSolicitante);
        return realizarMatching.execute();
    }
}
