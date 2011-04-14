import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;

@Ignore
public class CopyOfUsuarioRNTest {

    @Test
    public void inserirUsuarioSemErro() {

	UsuarioRN rn = new UsuarioRN();

	Usuario usuario;

	usuario = new Usuario();
	usuario.setAnoNascimento(1900);

	rn.inserir(usuario);
    }

    @Test
    public void tentarInserirUsuarioMenorDeIdade() {
	UsuarioRN rn = new UsuarioRN();
	Usuario usuario;

	usuario = new Usuario();
	usuario.setAnoNascimento(2000);

	try {
	    rn.inserir(usuario);
	    fail("Não era para conseguir inserir");

	} catch (Exception e) {
	    // Tudo Ok, era para acontecer isso mesmo.
	}
    }
}
