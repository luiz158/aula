package br.com.posruy.demo.view;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.posruy.demo.business.UsuarioRN;
import br.com.posruy.demo.domain.Usuario;

@ManagedBean
public class AdministracaoPage {

    public List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
	UsuarioRN rn = new UsuarioRN();
	return rn.listar();
    }
}
