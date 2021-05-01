package com.example.demo.servicos;

import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.utils.CalcularDistancia;
import com.example.demo.utils.Coordenadas;
import com.example.demo.visoes.UsuarioVisao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RealizarMatchingEntreUsuariosServico {

    private final UsuarioRepository repository;
    private final String posicaoSolicitante;

    public RealizarMatchingEntreUsuariosServico( UsuarioRepository repository,String posicaoSolicitante) {
        this.posicaoSolicitante = posicaoSolicitante;
        this.repository = repository;
    }

    public ResponseEntity execute() {
        List<UsuarioVisao> usuarios = repository.findAllEntregadoresSimples();
        String[] stringPosicaoSolicitante = posicaoSolicitante.split(",");
        Coordenadas coordenadasSolicitante = new Coordenadas(Double.parseDouble(stringPosicaoSolicitante[0].trim()), Double.parseDouble(stringPosicaoSolicitante[1]));

        if (usuarios.isEmpty()) {

            return ResponseEntity.noContent().build();
        } else {
            List<UsuarioVisao> usuariosDentroDoRaioDistancia = new ArrayList<>();

            for (UsuarioVisao usuario : usuarios) {
                if(usuario.getCoordenadas().equals("") ||usuario.getCoordenadas() == null )
                    continue;

                String[] stringCoordenadasEntregador = usuario.getCoordenadas().split(",");
                Coordenadas CoordenadasEntregador = new Coordenadas(Double.parseDouble(stringCoordenadasEntregador[0]), Double.parseDouble(stringCoordenadasEntregador[1].trim()));
                double proximidade = CalcularDistancia.distanciaEmKMEntreCoordenadas(coordenadasSolicitante, CoordenadasEntregador);

                if (proximidade <= 0.500 && proximidade != 0.0)
                    usuariosDentroDoRaioDistancia.add(usuario);
            }

            System.out.println("QTD USUARIOS: " + usuariosDentroDoRaioDistancia.size());
            if (usuariosDentroDoRaioDistancia.isEmpty())
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.ok().body(usuariosDentroDoRaioDistancia);
        }
    }

    public ResponseEntity executeBringingAll() {
        List<UsuarioVisao> usuarios = repository.findAllEntregadoresSimples();
        String[] stringPosicaoSolicitante = posicaoSolicitante.split(",");
        Coordenadas coordenadasSolicitante = new Coordenadas(Double.parseDouble(stringPosicaoSolicitante[0].trim()), Double.parseDouble(stringPosicaoSolicitante[1]));

        if (usuarios.isEmpty()) {

            return ResponseEntity.noContent().build();
        } else {
            List<UsuarioVisao> usuariosDentroDoRaioDistancia = new ArrayList<>();

            for (UsuarioVisao usuario : usuarios) {
                if(usuario.getCoordenadas().equals("") ||usuario.getCoordenadas() == null )
                    continue;

                String[] stringCoordenadasEntregador = usuario.getCoordenadas().split(",");
                Coordenadas CoordenadasEntregador = new Coordenadas(Double.parseDouble(stringCoordenadasEntregador[0]), Double.parseDouble(stringCoordenadasEntregador[1].trim()));
                double proximidade = CalcularDistancia.distanciaEmKMEntreCoordenadas(coordenadasSolicitante, CoordenadasEntregador);

                if (proximidade != 0.0 )
                    usuariosDentroDoRaioDistancia.add(usuario);
            }

            System.out.println("QTD USUARIOS: " + usuariosDentroDoRaioDistancia.size());
            if (usuariosDentroDoRaioDistancia.isEmpty())
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.ok().body(usuariosDentroDoRaioDistancia);
        }
    }
}
