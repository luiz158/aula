import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;

public class Main {

    public static void main(String[] args) {

	Usuario usuario = new Usuario();
	usuario.setNome("José");
	usuario.setAnoNascimento(1993);

	UsuarioRN rn = new UsuarioRN();
	rn.inserir(usuario);

	for (Usuario u : rn.listar()) {
	    System.out.println("id: " + u.getId() + ", nome: " + u.getNome());
	}
    }
}
