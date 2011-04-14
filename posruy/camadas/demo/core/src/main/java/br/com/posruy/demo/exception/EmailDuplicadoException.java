package br.com.posruy.demo.exception;

@SuppressWarnings("serial")
public class EmailDuplicadoException extends ValidacaoException {

    private final String email;

    public EmailDuplicadoException(String email) {
	super("Já existe um usuário com o e-mail informado.");
	this.email = email;
    }

    public String getEmail() {
	return email;
    }
}
