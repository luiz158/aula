package br.posruy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Classe responsável por persistir e obter os dados da entidade {@link Usuario}
 * . Esta classe representa a camada de persistência da funcionalidade CRUD de
 * {@link Usuario}. Para não escrever queries na mão, decidi delegar esta
 * responsabilidade para o Hibernate (uma implementação do JPA2), mas a camada
 * de negócio não terá conhecimento disso (nem precisa saber e nem deve).
 * 
 * Praticamente todos os métodos desta classe vão utilizar o gerenciador de
 * entidades do JPA2, o famoso {@link EntityManager}, que é criado pela fábrica
 * {@link EntityManagerFactory}. A fábrica cria uma ligação com o banco de dados
 * utilizando o nome da unidade de persitência definida no arquivo
 * persistence.xml. Neste caso utilizamos o nome "banco1".
 * 
 * @author cleverson.sacramento@gmail.com
 */
public class ProdutoDAO {

    /**
     * Insere o usuário utilizando o método de persistência de novos dados do
     * {@link EntityManager}.
     * 
     * @param usuario
     *            Objeto a ser persistido.
     */
    public void inserir(Produto produto) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	em.persist(produto);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }

    /**
     * Altera os dados persistidos de um usuário
     * 
     * @param usuario
     *            Objeto a ser modificado.
     */
    public void alterar(Produto produto) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	produto = em.merge(produto);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }

    /**
     * Exclui um usuário do banco de dados utilizando o objeto {@link Query}.
     * Poderia ser excluído utilizando o método "remove" do
     * {@link EntityManager}, mas utilizei o query para exemplificar o seu uso.
     * 
     * @param usuario
     *            Usuário a ser excluído.
     */
    public void excluir(Produto produto) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	Query query = em.createQuery("delete Produto p where p.id = :id");
	query.setParameter("id", produto.getId());

	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	em.close();
	emf.close();
    }

    @SuppressWarnings("unchecked")
    public List<Produto> listar() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	Query query = em.createQuery("select p from Produto p");
	List<Produto> list = query.getResultList();

	em.close();
	emf.close();
	return list;
    }

    public Produto obter(Long id) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	Produto produto = em.find(Produto.class, id);

	em.close();
	emf.close();
	return produto;
    }
}
