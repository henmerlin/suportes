package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import entidades.Atendimento;
import entidades.ObservacaoAtendimento;
import model.AtendimentoServico;
import util.JSFUtil;

@ViewScoped
@ManagedBean(name="atendimentoBean")
public class AtendimentoBean{
	
	@Inject
	private LoginBean sessao;

	private Atendimento atendimento;
	
	private ObservacaoAtendimento observacao;

	@EJB
	private AtendimentoServico servicoAtendimento;

	public AtendimentoBean() {
		this.atendimento = new Atendimento();
		this.observacao = new ObservacaoAtendimento();
		
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Atendimento finalizar(){
		
		this.atendimento.setTecnico(this.sessao.getUsuario());
		
		this.servicoAtendimento.salvar(this.atendimento, this.observacao);
		JSFUtil.addInfoMessage("Atendimento encerrado!");
		
		this.atendimento = new Atendimento();
		
		this.observacao = new ObservacaoAtendimento();
		
		return new Atendimento();
	}
	
	public List<Atendimento> listar(){
		
		return this.servicoAtendimento.listar();
	}

	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}

	public ObservacaoAtendimento getObservacao() {
		return observacao;
	}

	public void setObservacao(ObservacaoAtendimento observacao) {
		this.observacao = observacao;
	}
	
}
