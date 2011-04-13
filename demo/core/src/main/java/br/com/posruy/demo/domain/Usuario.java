package br.com.posruy.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Integer anoNascimento;

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return nome;
    }

    public void setAnoNascimento(Integer anoNascimento) {
	this.anoNascimento = anoNascimento;
    }

    public Integer getAnoNascimento() {
	return anoNascimento;
    }

    public Long getId() {
	return id;
    }
}
