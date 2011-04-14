package br.com.posruy.demo.exception;

@SuppressWarnings("serial")
public class InformacaoObrigatoriaException extends ValidacaoException {

    public InformacaoObrigatoriaException(String message) {
	super(message);
    }
}
