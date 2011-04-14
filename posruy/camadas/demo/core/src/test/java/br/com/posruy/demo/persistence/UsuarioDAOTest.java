package br.com.posruy.demo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;

import br.com.posruy.demo.domain.Usuario;

public class UsuarioDAOTest {

    private UsuarioDAO dao = new UsuarioDAO();

    @Before
    public void antesDeCadaTeste() {
	limpaBase();
    }

    @Test
    public void inserirUsuarioSemErro() {
	Usuario usuario = new Usuario();

	dao.inserir(usuario);
	usuario = dao.obter(usuario.getId());

	assertNotNull(usuario);
    }

    @Test
    public void excluirUsuarioSemErro() {
	Usuario usuario = new Usuario();

	dao.inserir(usuario);
	dao.excluir(usuario.getId());
	usuario = dao.obter(usuario.getId());

	assertNull(usuario);
    }

    @Test
    public void falharSeUsuarioNaoExistir() {
	try {
	    dao.excluir(Long.valueOf(0));
	    fail("Não era para conseguir excluir. Era para falhar!");
	} catch (EntityNotFoundException cause) {
	    // Erro esperado!
	}
    }

    @Test
    public void alterarUsuarioSemErro() {
	Usuario usuario = new Usuario();

	usuario.setNome("Zé");
	dao.inserir(usuario);

	usuario.setNome("José");
	dao.alterar(usuario);

	usuario = dao.obter(usuario.getId());
	assertEquals("José", usuario.getNome());
    }

    @Test
    public void listagemCorreta() {
	Usuario usuario;

	usuario = new Usuario();
	usuario.setNome("Mike");
	dao.inserir(usuario);

	usuario = new Usuario();
	usuario.setNome("Maguila");
	dao.inserir(usuario);

	usuario = new Usuario();
	usuario.setNome("Popó");
	dao.inserir(usuario);

	assertEquals(3, dao.listar().size());
    }

    @Test
    public void obterPorEmailExistente() {
	String email = "ok@ok.com";

	Usuario usuario = new Usuario();
	usuario.setEmail(email);
	dao.inserir(usuario);

	usuario = dao.obterPorEmail(email);
	assertNotNull(usuario);
    }

    @Test
    public void obterPorEmailValidoPoremInexistente() {
	Usuario usuario = dao.obterPorEmail("no-reply@fake-mail.com");
	assertNull(usuario);
    }

    private void limpaBase() {
	for (Usuario usuario : dao.listar()) {
	    dao.excluir(usuario.getId());
	}
    }
}
