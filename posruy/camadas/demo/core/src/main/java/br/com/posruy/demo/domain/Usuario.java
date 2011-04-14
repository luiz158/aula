package br.com.posruy.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

/**
 * Objeto de transferência de dados utilizado para transportar informações do
 * usuário entre as camadas. É uma classe simples composta por atributos
 * privados contendo os métodos acessores "get" e "set" públicos.
 * 
 * Adicionalmente esta classe foi anotada com {@link Entity}, uma anotação da
 * JPA2 utilizada para fazer o mapeamento do Objeto para a tabela no banco de
 * dados. Isso poderia ser feito utizando arquivos de configuração XML, mas o
 * uso de anotações é mais intuitivo e, por isso, recomendado.
 * 
 * @author cleverson.sacramento@gmail.com
 */
@Entity
public class Usuario {

    /**
     * Campo identificador de um usuário.
     * 
     * Adicionalmente foi anotado com @{@link Id} para indicar ao JPA2 que
     * trata-se de uma chave na base de dados. O seu valor será gerada
     * automaticamente pelo JPA2, que delegará esta atribuição ao banco de
     * dados.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Representa o nome do usuário.
     * 
     * Adicionalmente, o JPA2 criará uma coluna na tabela de usuário para
     * armazenar esta informação.
     */
    private String nome;

    @Email
    private String email;

    private String senha;

    /**
     * Representa o nao de nascimento do usuário.
     * 
     * Adicionalmente, o JPA2 criará uma coluna na tabela de usuário para
     * armazenar esta informação.
     */
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

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEmail() {
	return email;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getSenha() {
	return senha;
    }
}
