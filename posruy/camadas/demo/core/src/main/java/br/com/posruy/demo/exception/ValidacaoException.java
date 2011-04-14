package br.com.posruy.demo.exception;

@SuppressWarnings("serial")
public abstract class ValidacaoException extends Exception {

    public ValidacaoException() {
	super();
    }

    public ValidacaoException(String message) {
	super(message);
    }
}
