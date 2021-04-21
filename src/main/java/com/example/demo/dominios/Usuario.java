package com.example.demo.dominios;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Usuario {

    //-----Atributos Usuários-----
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

    @Length(min = 3, max = 60)
    @Column(name = "nome_completo",nullable = false)
    private String nomeCompleto;

    @Length(min = 11, max = 11)
    @NumberFormat
    @Column()
    private String cPF;

    @Past
    @Column(name = "data_nascimento",nullable = false)
    private LocalDate dataNascimento;

    @Email
    @Length(min = 7, max = 65)
    @Column(unique = true,nullable = false)
    private String email;

    @Length(min = 10, max = 11)
    @NumberFormat
    @Column(nullable = false)
    private String telefone;

    @Column()
    @NumberFormat
    @Length(min = 8, max = 9)
    private String cEP;

    @Column()
    @Length(min = 3, max = 20)
    private String complemento;

    @Column()
    private Double saldo;

    @Column()
    private String RG;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Length(min = 7, max = 15)
    @Column(nullable = false)
    private String senha;

    @Column()
    private String coordenadas;

    @Column(name = "foto_rg")
    private String fotoRG;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "eh_consumidor")
    private Integer ehConsumidor;

    @ManyToOne()
    private Cartao cartao;


    //-----Construtor para auxiliar nos cadastros na classe "controller"-----


    public Usuario(@Length(min = 3, max = 60) String nomeCompleto, @Length(min = 11, max = 11) String CPF, @Past LocalDate dataNascimento, @Length(min = 7, max = 65) String email, @Length(min = 10, max = 11) String telefone, @Length(min = 8, max = 9) String CEP, @Length(min = 3, max = 20) String complemento, Double saldo, String RG, String pontoReferencia, @Length(min = 7, max = 15) String senha, String coordenadas, String fotoRG, String fotoPerfil, Integer ehConsumidor, Cartao cartao) {
        this.nomeCompleto = nomeCompleto;
        this.cPF = CPF;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cEP = CEP;
        this.complemento = complemento;
        this.saldo = saldo;
        this.RG = RG;
        this.pontoReferencia = pontoReferencia;
        this.senha = senha;
        this.coordenadas = coordenadas;
        this.fotoRG = fotoRG;
        this.fotoPerfil = fotoPerfil;
        this.ehConsumidor = ehConsumidor;
        this.cartao = cartao;
    }

    public Usuario(){

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }



    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public void depositarSaldo(Double saldo) {
        if(this.saldo == null){
            this.saldo = 0.0;
        }
        this.saldo += saldo;
    }

    public void sacarSaldo(Double saque) {
        if(this.saldo - saque >= 0.0 ){
            this.saldo -= saque;
        }
    }

    public String getcPF() {
        return cPF;
    }

    public void setcPF(String cPF) {
        this.cPF = cPF;
    }

    public String getcEP() {
        return cEP;
    }

    public void setcEP(String cEP) {
        this.cEP = cEP;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getFotoRG() {
        return fotoRG;
    }

    public void setFotoRG(String fotoRG) {
        this.fotoRG = fotoRG;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Integer getEhConsumidor() {
        return ehConsumidor;
    }

    public void setEhConsumidor(Integer ehConsumidor) {
        this.ehConsumidor = ehConsumidor;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cPF='" + cPF + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cEP='" + cEP + '\'' +
                ", complemento='" + complemento + '\'' +
                ", saldo=" + saldo +
                ", RG='" + RG + '\'' +
                ", pontoReferencia='" + pontoReferencia + '\'' +
                ", senha='" + senha + '\'' +
                ", coordenadas='" + coordenadas + '\'' +
                ", fotoRG='" + fotoRG + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", ehConsumidor=" + ehConsumidor +
                ", cartao=" + cartao +
                '}';
    }
}