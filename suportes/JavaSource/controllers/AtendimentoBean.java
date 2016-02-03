package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Atendimento;
import model.AtendimentoServico;
import util.JSFUtil;

@ViewScoped
@ManagedBean(name="atendimentoBean")
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

	public Atendimento finalizar(){

		this.servicoAtendimento.salvar(this.atendimento);
		JSFUtil.addWarnMessage("Atendimento encerrado!");
		
		return this.atendimento = new Atendimento();
	}
	
	public List<Atendimento> listar(){
		
		return this.servicoAtendimento.listar();
	}	


}
