import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;

/**
 * Classe para fazer as chamadas à camada de negócio, já que a camada de
 * apresentação não existe ainda. Em breve essa classe vai deixar de existir.
 * Coitada!
 * 
 * @author cleverson.sacramento@gmail.com
 */
public class Main {

    public static void main(String[] args) {
	Usuario usuario;
	UsuarioRN rn = new UsuarioRN();

	usuario = new Usuario();
	usuario.setNome("José");
	usuario.setAnoNascimento(1993);
	rn.inserir(usuario);

	for (Usuario u : rn.listar()) {
	    System.out.println("id: " + u.getId() + ", nome: " + u.getNome());
	}
    }
}
