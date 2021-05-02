package com.example.demo.controladores;

import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.servicos.RealizarMatchingEntreUsuariosServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/coordenadas")

public class ControllerMatching {

    @Autowired()
    private UsuarioRepository repository;

    //Traz do banco todos os entregadores
    @GetMapping("/{posicaoSolicitante}/trazerTodos")
    public ResponseEntity getEntregadores(@PathVariable String posicaoSolicitante) {
        System.out.println(posicaoSolicitante);

        RealizarMatchingEntreUsuariosServico realizarMatching = new RealizarMatchingEntreUsuariosServico( repository,posicaoSolicitante);
        return realizarMatching.executeBringingAll();
    }

    //Traz do banco todos os entregadores proximos a posicao do solicitante
    @GetMapping("/{posicaoSolicitante}")
    public ResponseEntity getEntregadores1(@PathVariable String posicaoSolicitante) {
        System.out.println(posicaoSolicitante);

        RealizarMatchingEntreUsuariosServico realizarMatching = new RealizarMatchingEntreUsuariosServico( repository,posicaoSolicitante);
        return realizarMatching.execute();
    }

    @GetMapping("")
    public ResponseEntity getEntregadores1() {

        List<String> s = new ArrayList<>();
        s.add("Running");
        return ResponseEntity.ok(s);
    }
}
