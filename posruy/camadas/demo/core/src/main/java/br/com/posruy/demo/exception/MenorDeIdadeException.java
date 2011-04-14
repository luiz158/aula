package br.com.posruy.demo.exception;

@SuppressWarnings("serial")
public class MenorDeIdadeException extends ValidacaoException {

    public MenorDeIdadeException() {
	super("Vai crescer rapá!");
    }
}
