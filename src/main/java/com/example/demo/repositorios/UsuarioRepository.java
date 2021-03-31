package com.example.demo.repositorios;

import com.example.vaialipramim.dominios.Usuario;
import com.example.demo.visoes.UsuarioVisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   // c.idUsuario, c.nomeCompleto, c.CPF, c.dataNascimento, c.complemento,c.CEP, c.email,c.senha,c.telefone, c.pontoReferencia, c.fotoRG, c.fotoPerfil, c.ehConsumidor,c.coordenadas, c.saldo, c.RG

    @Query("select new com.example.vaialipramim.visoes.UsuarioVisao(c.idUsuario, c.nomeCompleto, c.CPF, c.dataNascimento, c.complemento,c.CEP,c.email,c.senha,c.telefone, c.pontoReferencia, c.fotoRG, c.fotoPerfil,c.ehConsumidor,c.coordenadas,c.RG,c.saldo) from Usuario c")
    List<UsuarioVisao> findAllSimples();

    @Query("select new com.example.vaialipramim.visoes.UsuarioVisao(c.idUsuario, c.nomeCompleto, c.CPF, c.dataNascimento, c.complemento,c.CEP,c.email,c.senha,c.telefone, c.pontoReferencia, c.fotoRG, c.fotoPerfil,c.ehConsumidor,c.coordenadas,c.RG,c.saldo) from Usuario c where id_usuario = :id")
    UsuarioVisao findByIdUsuarioVisao(@Param("id") int id);

    @Query("select new com.example.vaialipramim.visoes.UsuarioVisao(c.idUsuario, c.nomeCompleto, c.CPF, c.dataNascimento, c.complemento,c.CEP,c.email,c.senha,c.telefone, c.pontoReferencia, c.fotoRG, c.fotoPerfil,c.ehConsumidor,c.coordenadas,c.RG,c.saldo) from Usuario c where email = :email and senha = :senha")
    UsuarioVisao findByEmailESenha(@Param("email") String email, @Param("senha") String senha);
}
