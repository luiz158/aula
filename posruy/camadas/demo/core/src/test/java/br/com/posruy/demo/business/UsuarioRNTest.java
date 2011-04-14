package br.com.posruy.demo.business;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.fail;
import static org.powermock.reflect.Whitebox.setInternalState;

import java.util.Calendar;

import org.junit.Test;

import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.exception.MenorDeIdadeException;
import br.com.posruy.demo.exception.ValidacaoException;
import br.com.posruy.demo.persistence.UsuarioDAO;

public class UsuarioRNTest {

    private static final int ANO_CORRENTE = Calendar.getInstance().get(Calendar.YEAR);

    @Test
    public void inserirUsuarioSemErro() throws Exception {
	UsuarioRN rn = new UsuarioRN();
	UsuarioDAO dao = createMock(UsuarioDAO.class);

	dao.inserir(anyObject(Usuario.class));
	expectLastCall();
	expect(dao.obter(null)).andReturn(null);
	expect(dao.obterPorEmail(null)).andReturn(null);
	setInternalState(rn, UsuarioDAO.class, dao);

	replay(dao);

	Usuario usuario = new Usuario();
	usuario.setAnoNascimento(ANO_CORRENTE - 18);

	rn.inserir(usuario);
    }

    @Test
    public void tentarInserirUsuarioMenorDeIdade() throws ValidacaoException {
	UsuarioRN rn = new UsuarioRN();
	Usuario usuario;

	usuario = new Usuario();
	usuario.setAnoNascimento(ANO_CORRENTE - 10);

	try {
	    rn.inserir(usuario);
	    fail("Não era para conseguir inserir");

	} catch (MenorDeIdadeException e) {
	    // Tudo Ok, era para acontecer isso mesmo.
	}
    }
}
