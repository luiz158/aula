import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class X {

    public static void main(String[] args) {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco1");

	EntityManager em = factory.createEntityManager();

	Produto produto = new Produto();
	produto.setNome("xx");

	em.getTransaction().begin();
	em.persist(produto);
	em.getTransaction().commit();

	Query query = em.createQuery("select x from Produto x");
	query.getResultList();

	System.out.println("xxxxxx");
    }
}
