package controllers;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Usuario;
import model.LoginServico;
import util.JSFUtil;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = -3645902541993768134L;

	private Usuario usuario;

	@EJB
	private LoginServico servicoLogin;

	private Boolean logado;

	public LoginBean() {
		this.usuario = new Usuario();
		this.logado = false;
	}

	public void validarLogin(){

		FacesContext fc = FacesContext.getCurrentInstance();

		if (!this.logado){

			ConfigurableNavigationHandler nav  = (ConfigurableNavigationHandler) 
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("login.jsf");

		}

	}
	
	public void validaAdmin(){
		
		FacesContext fc = FacesContext.getCurrentInstance();

		if (this.usuario.getNivel() < 8){

			ConfigurableNavigationHandler nav  = (ConfigurableNavigationHandler) 
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("restrito.jsf");

		}
	}
	

	public String logar(){

		try {
			servicoLogin.consultar(usuario.getLogin(), usuario.getSenha());
			this.logado = true;
			return "index.jsf";

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			this.usuario = new Usuario();
			return "login.jsf";

		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}


}