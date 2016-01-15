package controllers;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
		
		servicoTecnologia.cadastrar(this.tecnologia);
		JSFUtil.addInfoMessage("Tecnologia " + this.tecnologia.getNome() + " cadastrada! ");

		return this.tecnologia;
	}
	
	public List<Tecnologia> listar(){

		return this.servicoTecnologia.listar();
	}
}
