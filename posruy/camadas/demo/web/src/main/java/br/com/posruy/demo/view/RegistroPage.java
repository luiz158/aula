package br.com.posruy.demo.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.exception.EmailDuplicadoException;
import br.com.posruy.demo.exception.MenorDeIdadeException;
import br.com.posruy.demo.exception.ValidacaoException;

@ManagedBean
public class RegistroPage {

    private final Usuario dto = new Usuario();

    public Usuario getDto() {
	return dto;
    }

    public String salvar() {
	String mensagem = null;
	String campo = null;
	String destino = "/index.xhtml";

	UsuarioRN rn = new UsuarioRN();

	try {
	    rn.inserir(dto);

	} catch (EmailDuplicadoException cause) {
	    mensagem = cause.getMessage();
	    campo = "email";

	} catch (MenorDeIdadeException cause) {
	    mensagem = cause.getMessage();
	    campo = "ano";

	} catch (ValidacaoException cause) {
	    mensagem = cause.getMessage();
	}

	if (mensagem != null) {
	    FacesMessage facesMessage = new FacesMessage(mensagem);
	    getFacesContext().addMessage(campo, facesMessage);

	    destino = null;
	}

	return destino;
    }

    private FacesContext getFacesContext() {
	return FacesContext.getCurrentInstance();
    }
}
