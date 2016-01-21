package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Motivo;
import entidades.Tecnologia;
import model.TecnologiaServico;

@ViewScoped
@ManagedBean(name="subSelectBean")
public class SubSelectBean {
	
	private Tecnologia tecnologia;
	
	@EJB
	private TecnologiaServico servicoTecnologia;
	
	public SubSelectBean() {

	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	public List<Tecnologia> listar(){

		return this.servicoTecnologia.listar();
	}

	public List<Motivo> listarMotivos(Tecnologia tecnologia){
		
		List<Motivo> lista = this.servicoTecnologia.listarMotivos(tecnologia);
		
		this.tecnologia.setMotivos(lista);
		
		return lista;
	}
	
}
