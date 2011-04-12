package br.com.posruy;

import br.com.posruy.domain.Produto;
import br.com.posruy.persistence.ProdutoDAO;

public class Main {

    public static void main(String[] args) {

	ProdutoDAO dao = new ProdutoDAO();

	Produto produto = new Produto();
	produto.setNome("xx");

	dao.inserir(produto);

	for (Produto p : dao.obterTodos()) {
	    System.out.println("id: " + p.getId());
	}
    }
}
