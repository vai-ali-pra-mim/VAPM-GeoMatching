package com.example.demo.visoes;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioVisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

    @Length(min = 3, max = 60)
    @Column(name = "nome_completo",nullable = false)
    private String nomeCompleto;

    @Length(min = 11, max = 11)
    @Column(nullable = false)
    private String CPF;

    @Past
    @Column(name = "data_nascimento",nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String complemento;

    @Column(nullable = false)
    @Length(min = 8, max = 9)
    private String CEP;

    @Length(min = 7, max = 65)
    @Column(unique = true,nullable = false)
    private String email;

    @Length(min = 7, max = 15)
    @Column(nullable = false)
    private String senha;

    @Length(min = 10, max = 11)
    @Column(nullable = false)
    private String telefone;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Column(name = "foto_rg")
    private String fotoRG;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "eh_consumidor")
    private Integer ehConsumidor;

    @Column()
    private String coordenadas;

    @Column()
    private String RG;

    @Column()
    private Double saldo;

    public UsuarioVisao() {
    }

    public UsuarioVisao(Integer idUsuario, @Length(min = 3, max = 60) String nomeCompleto, @Length(min = 11, max = 11) String CPF, @Past LocalDate dataNascimento, @Length(min = 3, max = 20) String complemento, @Length(min = 8, max = 9) String CEP,
                        @Length(min = 7, max = 65) String email, @Length(min = 7, max = 15) String senha, @Length(min = 10, max = 11) String telefone,
                        String pontoReferencia, String fotoRG, String fotoPerfil,
                        Integer ehConsumidor,
                        String coordenadas, String RG, Double saldo
                        ) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.complemento = complemento;
        this.CEP = CEP;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.pontoReferencia = pontoReferencia;
        this.fotoRG = fotoRG;
        this.fotoPerfil = fotoPerfil;
        this.ehConsumidor = ehConsumidor;
        this.coordenadas = coordenadas;
        this.RG = RG;
        this.saldo = saldo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFotoRG() {
        return fotoRG;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public Integer getEhConsumidor() {
        return ehConsumidor;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public String getRG() {
        return RG;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "UsuarioVisao{" +
                "idUsuario=" + idUsuario +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", CPF='" + CPF + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", complemento='" + complemento + '\'' +
                ", CEP='" + CEP + '\'' +
                ", pontoReferencia='" + pontoReferencia + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", fotoRG='" + fotoRG + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", ehConsumidor=" + ehConsumidor +
                ", coordenadas='" + coordenadas + '\'' +
                ", RG='" + RG + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}