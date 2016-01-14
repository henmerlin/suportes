package controllers;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import entidades.Atendimento;
import model.AtendimentoServico;

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
	
	
}
