package controllers;


import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import entidades.Atendimento;
import model.AtendimentoServico;
import util.JSFUtil;

@Named
@RequestScoped
public class AtendimentoBean{

	private Atendimento atendimento;

	@EJB
	private AtendimentoServico servicoAtendimento;


	public AtendimentoBean() {
		this.atendimento = new Atendimento();
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public String consultaOperador(){

		return "window.location = 'infoOperador.jsf'";
	}
	
	public Atendimento iniciar(){
		
		
		
		try {
			this.atendimento.setInicio(new Date());
			this.servicoAtendimento.iniciar(this.atendimento);
			JSFUtil.addInfoMessage("Atendimento iniciado!");
		} catch (Exception e) {
			
		}
		
		return this.atendimento;
	}
	
	public void finalizar(){
		
		JSFUtil.addInfoMessage("Atendimento encerrado!");

	}
	
	
}
