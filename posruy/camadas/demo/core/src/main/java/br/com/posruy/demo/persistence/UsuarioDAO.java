package br.com.posruy.demo.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.posruy.demo.domain.Usuario;

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
public class UsuarioDAO {

    /**
     * Insere o usuário utilizando o método de persistência de novos dados do
     * {@link EntityManager}.
     * 
     * @param usuario
     *            Objeto a ser persistido.
     */
    public void inserir(Usuario usuario) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	em.persist(usuario);
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
    public void alterar(Usuario usuario) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	usuario = em.merge(usuario);
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
    public void excluir(Usuario usuario) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	Query query = em.createQuery("delete Usuario u where u.id = :id");
	query.setParameter("id", usuario.getId());

	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	em.close();
	emf.close();
    }

    /**
     * Obtém uma listagem com todos os usuários persistidos no banco de dados.
     * 
     * @return Todos os usuários persistidos.
     */
    @SuppressWarnings("unchecked")
    public List<Usuario> listar() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1");
	EntityManager em = emf.createEntityManager();

	Query query = em.createQuery("select u from Usuario u");
	List<Usuario> list = query.getResultList();

	em.close();
	emf.close();
	return list;
    }
}
