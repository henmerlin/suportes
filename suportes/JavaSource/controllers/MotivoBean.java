package controllers;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entidades.Motivo;
import model.MotivoServico;
import util.JSFUtil;

@Named
@RequestScoped
public class MotivoBean{

	private Motivo motivo;

	@EJB
	private MotivoServico servicoMotivo;


	public MotivoBean() {
		this.setMotivo(new Motivo());
	}

	public Motivo cadastrar(){
		try {
			this.servicoMotivo.cadastrar(this.motivo);
			JSFUtil.addInfoMessage("Motivo " + this.motivo.getNome() + " cadastrado! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}

		
		return this.motivo;
	}
	
	public void excluir(Motivo motivo){
		
		try {
			this.servicoMotivo.excluir(motivo);
			JSFUtil.addInfoMessage("Motivo " + motivo.getNome() + " excluido! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
	public List<Motivo> listar(){

		return this.servicoMotivo.listar();
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

}
