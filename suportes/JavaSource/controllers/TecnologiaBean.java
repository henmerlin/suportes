package controllers;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entidades.Motivo;
import entidades.Tecnologia;
import model.TecnologiaServico;
import util.JSFUtil;

@Named
@RequestScoped
public class TecnologiaBean{

	private Tecnologia tecnologia;

	@EJB
	private TecnologiaServico servicoTecnologia;


	public TecnologiaBean() {
		this.tecnologia = new Tecnologia();
	}


	public Tecnologia getTecnologia() {
		return tecnologia;
	}


	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	public Tecnologia cadastrar(){
		
		try {
			servicoTecnologia.cadastrar(this.tecnologia);
			JSFUtil.addInfoMessage("Tecnologia " + this.tecnologia.getNome() + " cadastrada! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
		
		return new Tecnologia();
	}
	
	public List<Tecnologia> listar(){

		return this.servicoTecnologia.listar();
	}
	
	public void excluir(Tecnologia tecnologia){
		
		try {
			this.servicoTecnologia.excluir(tecnologia);
			JSFUtil.addInfoMessage("Tecnologia " + tecnologia.getNome() + " excluida! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());		
		}

		
	}	
	
	
	public List<Motivo> listarMotivos(Tecnologia tecnologia){
		
		List<Motivo> lista = this.servicoTecnologia.listarMotivos(tecnologia);
		
		this.tecnologia.setMotivos(lista);
		
		return lista;
	}	
	
}
