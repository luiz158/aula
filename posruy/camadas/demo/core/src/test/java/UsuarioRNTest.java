import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.persistence.UsuarioDAO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calendar.class)
public class UsuarioRNTest {

    @Test
    public void inserirUsuarioSemErro() {

	UsuarioRN rn = new UsuarioRN();

	UsuarioDAO mock = createMock(UsuarioDAO.class);
	mock.inserir(anyObject(Usuario.class));
	expectLastCall();
	Whitebox.setInternalState(rn, UsuarioDAO.class, mock);
	expect(Calendar.getInstance().get(1)).andReturn(2016);

	replay(mock, Calendar.class);

	Usuario usuario;

	usuario = new Usuario();
	usuario.setAnoNascimento(1900);

	rn.inserir(usuario);
    }

    @Ignore
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
