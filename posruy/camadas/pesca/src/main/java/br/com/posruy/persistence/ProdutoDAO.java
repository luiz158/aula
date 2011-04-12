package br.com.posruy.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.posruy.domain.Produto;
import br.com.posruy.util.PersistenceUtil;

public class ProdutoDAO {

    public void inserir(Produto produto) {
	EntityManager em = PersistenceUtil.createEntityManager();

	em.getTransaction().begin();
	em.persist(produto);
	em.getTransaction().commit();

	em.close();
    }

    @SuppressWarnings("unchecked")
    public List<Produto> obterTodos() {
	EntityManager em = PersistenceUtil.createEntityManager();
	Query query = em.createQuery("select p from Produto p");

	List<Produto> list = query.getResultList();

	em.close();
	return list;
    }

}
