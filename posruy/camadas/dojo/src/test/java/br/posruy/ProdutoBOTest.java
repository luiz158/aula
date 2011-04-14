package br.posruy;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoBOTest {

    @Test
    public void inserirSemErro() {

	ProdutoBO bo = new ProdutoBO();
	Produto produto = new Produto();
	Assert.assertEquals(true, bo.inserir(produto));

	Assert.assertNotNull(bo.obter(produto.getId()));

	Produto prodRetornado = bo.obter(produto.getId());
	Assert.assertEquals(produto.getId(), prodRetornado.getId());

    }

    @Test
    public void excluirSemErro() {

	ProdutoBO bo = new ProdutoBO();
	Produto produto = new Produto();

	Assert.assertTrue(bo.excluir(produto));

    }

    @Test
    public void naopodeinserirprodutonull() {
	ProdutoBO bo = new ProdutoBO();

	try {
	    bo.inserir(null);
	    Assert.fail();

	} catch (Exception e) {
	    // Tudo oK!
	}
    }
}
