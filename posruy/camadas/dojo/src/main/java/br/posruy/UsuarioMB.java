package br.posruy;

import javax.faces.bean.ManagedBean;

import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;
import br.com.posruy.demo.exception.ValidacaoException;

@ManagedBean
public class UsuarioMB {

    private Usuario dto = new Usuario();

    public void cadastrar() {
	UsuarioRN rn = new UsuarioRN();

	try {
	    rn.inserir(dto);
	} catch (ValidacaoException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	System.out.println(dto.getNome());
    }

    public Usuario getDto() {
	return dto;
    }

}
