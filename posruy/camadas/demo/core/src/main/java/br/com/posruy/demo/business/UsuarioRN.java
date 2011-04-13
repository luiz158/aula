package br.com.posruy.demo.business;

import java.util.List;

import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.persistence.UsuarioDAO;

public class UsuarioRN {

    private UsuarioDAO dao = new UsuarioDAO();

    public void inserir(Usuario usuario) {
	if (maiorIdade(usuario)) {
	    dao.inserir(usuario);
	} else {
	    throw new RuntimeException("Vai crescer rapá!");
	}
    }

    private boolean maiorIdade(Usuario usuario) {
	int anoNascimento = usuario.getAnoNascimento();
	int idade = 2011 - anoNascimento;

	return idade >= 18;
    }

    public List<Usuario> listar() {
	return dao.listar();
    }

}
