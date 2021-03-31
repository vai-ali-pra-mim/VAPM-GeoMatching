package com.example.demo.dominios;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao")
    private Integer idCartao;

    @Length(min = 3, max = 60)
    @Column(name = "nome_titular", nullable = false)
    private String nomeTitular;

    @Length(min = 16, max = 16)
    @Column(name = "numero_cartao", nullable = false)
    private String numeroCartao;

    @Column(name = "tipo_cartao", nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String bandeira;

    @Length(min = 11, max = 11)
    @Column(nullable = false)
    private String CPF;

    @Length(min = 3, max = 4)
    @Column( nullable = false)
    private String CVV;

    @Length(min = 5, max = 5)
    @Column(name = "data_validade", nullable = false)
    private String dataValidade;


    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }


    @Override
    public String toString() {
        return "Cartao{" +
                "idCartao=" + idCartao +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", bandeira='" + bandeira + '\'' +
                ", CVV='" + CVV + '\'' +
                ", CPF='" + CPF + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                '}';
    }
}
