package br.posruy;

public class ProdutoBO {

    ProdutoDAO dao = new ProdutoDAO();

    public boolean inserir(Produto produto) {

	if (produto == null) {
	    throw new RuntimeException("Nao pode nulo!");
	}

	dao.inserir(produto);
	return true;
    }

    public Produto obter(Long id) {
	return dao.obter(id);
    }

    public boolean excluir(Produto produto2) {
	return true;
    }
}
