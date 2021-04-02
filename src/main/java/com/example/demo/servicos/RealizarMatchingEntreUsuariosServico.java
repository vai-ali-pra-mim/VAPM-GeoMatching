package com.example.demo.servicos;

import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.utils.CalcularDistancia;
import com.example.demo.utils.Coordenadas;
import com.example.demo.visoes.UsuarioVisao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class RealizarMatchingEntreUsuariosServico {

    @Autowired(required=true)
    private UsuarioRepository repository;
    private String posicaoSolicitante;

    public RealizarMatchingEntreUsuariosServico(String posicaoSolicitante) {
        this.posicaoSolicitante = posicaoSolicitante;
    }

    public ResponseEntity execute() {
        List<UsuarioVisao> usuarios = repository.findAllSimples();
        String[] stringPosicaoSolicitante = posicaoSolicitante.split(", ");
        Coordenadas coordenadasSolicitante = new Coordenadas(Double.parseDouble(stringPosicaoSolicitante[0]), Double.parseDouble(stringPosicaoSolicitante[1]));

        if (usuarios.isEmpty()) {

            return ResponseEntity.noContent().build();
        } else {
            List<UsuarioVisao> usuariosDentroDoRaioDistancia = new ArrayList<>();

            for (UsuarioVisao usuario : usuarios) {

                String[] stringCoordenadasEntregador = usuario.getCoordenadas().split(", ");
                Coordenadas CoordenadasEntregador = new Coordenadas(Double.parseDouble(stringCoordenadasEntregador[0]), Double.parseDouble(stringCoordenadasEntregador[1]));
                double proximidade = CalcularDistancia.distanciaEmKMEntreCoordenadas(coordenadasSolicitante, CoordenadasEntregador);

                if (proximidade <= 0.500 && proximidade != 0.0 && usuario.getEhConsumidor().equals(0))
                    usuariosDentroDoRaioDistancia.add(usuario);
            }

            if (usuariosDentroDoRaioDistancia.isEmpty())
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.ok().body(usuariosDentroDoRaioDistancia);
        }
    }
}
