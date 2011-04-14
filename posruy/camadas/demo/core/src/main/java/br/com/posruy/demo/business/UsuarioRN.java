package br.com.posruy.demo.business;

import java.util.Calendar;
import java.util.List;

import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.exception.EmailDuplicadoException;
import br.com.posruy.demo.exception.InformacaoObrigatoriaException;
import br.com.posruy.demo.exception.MenorDeIdadeException;
import br.com.posruy.demo.exception.ValidacaoException;
import br.com.posruy.demo.persistence.UsuarioDAO;

/**
 * Elemento da camada de negócio que contém as operações que podem ser
 * executadas sobre o objeto de transferência de dados {@link Usuario}. Esta
 * classe será referenciada pela camada de apresentação e referenciará a camada
 * de persistência.
 * 
 * Vale lembrar que esta classe não faz idéia de como os dados serão persistidos
 * pela camada de persistência, e nem deve saber. Os detalhes de persistência
 * (tais como local, formato, banco, tecnologia) não são da sua conta. A
 * responsabilidade desta classe é implementar as regras de negócio referentes
 * as operações sobre os dados de usuários.
 * 
 * @author cleverson.sacramento@gmail.com
 */
public class UsuarioRN {

    /**
     * Referência ao DAO de usuário.
     */
    private UsuarioDAO dao;

    /**
     * Inciializa o {@link UsuarioDAO} ou então retorna o que já estiver
     * inicializado. Todos os métodos desta classe que precisarem acessar
     * {@link UsuarioDAO} devem utilizar este método ao invés de acessar o
     * atributo {@link #dao} diretamente.
     * 
     * @return {@link UsuarioDAO} inicializado.
     */
    private UsuarioDAO getDAO() {
	if (dao == null) {
	    dao = new UsuarioDAO();
	}

	return dao;
    }

    /**
     * Insere um usuário verificando se ele é maior de idade.
     * 
     * @param usuario
     *            Usuário a ser inserido.
     * @throws MenorDeIdadeException
     */
    public void inserir(Usuario usuario) throws ValidacaoException {
	if (!maiorIdade(usuario)) {
	    throw new MenorDeIdadeException();
	}

	if (emailDuplicado(usuario)) {
	    throw new EmailDuplicadoException(usuario.getEmail());
	}

	getDAO().inserir(usuario);
    }

    private boolean emailDuplicado(Usuario usuario) {
	Usuario aux = obterPorEmail(usuario.getEmail());

	boolean duplicado = false;
	if (aux != null && aux.getId().equals(usuario.getId())) {
	    duplicado = true;
	}

	return duplicado;
    }

    /**
     * Verifica se o usuário já atingiu a maioridade.
     * 
     * @param usuario
     *            Usuário a ser verificado.
     * @return É de maior ou não é?
     */
    private boolean maiorIdade(Usuario usuario) {
	int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
	int anoNascimento = usuario.getAnoNascimento();

	return (anoCorrente - anoNascimento) >= 18;
    }

    /**
     * Simplesmente exclui um usuário.
     * 
     * @param id
     *            Identificação do usuário a ser excluído.
     * @throws InformacaoObrigatoriaException
     */
    public void excluir(Long id) throws ValidacaoException {
	if (id == null) {
	    throw new InformacaoObrigatoriaException("Informe a identificação do usuário");
	}

	getDAO().excluir(id);
    }

    /**
     * Obtém todos os uauários.
     * 
     * @return Listagem contendo todos os usuários.
     */
    public List<Usuario> listar() {
	return getDAO().listar();
    }

    public Usuario obter(Long id) {
	return getDAO().obter(id);
    }

    public Usuario obterPorEmail(String email) {
	Usuario usuario = null;

	if (email != null && !email.trim().isEmpty()) {
	    usuario = getDAO().obterPorEmail(email);
	}

	return usuario;
    }
}
