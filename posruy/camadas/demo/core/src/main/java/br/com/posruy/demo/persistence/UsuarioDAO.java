package br.com.posruy.demo.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.util.PersistenceUtil;

public class UsuarioDAO {

    public void inserir(Usuario usuario) {
	EntityManager em = PersistenceUtil.createEntityManager();

	em.getTransaction().begin();
	em.persist(usuario);
	em.getTransaction().commit();

	em.close();
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listar() {
	EntityManager em = PersistenceUtil.createEntityManager();

	Query query = em.createQuery("select u from Usuario u");
	List<Usuario> list = query.getResultList();

	em.close();
	return list;
    }
}
