package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Motivo;
import entidades.Tecnologia;
import model.MotivoServico;
import model.TecnologiaServico;
import util.JSFUtil;

@ViewScoped
@ManagedBean(name="subSelectBean")
public class SubSelectBean {

	private Tecnologia tecnologia;

	@EJB
	private TecnologiaServico servicoTecnologia;
	
	private Motivo motivo;
	
	@EJB
	private MotivoServico servicoMotivo;	


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

	public void atualizar(){		

		try {
			this.servicoTecnologia.atualizar(this.tecnologia);
			JSFUtil.addInfoMessage("Tecnologia " + this.tecnologia.getNome() + " atualizada! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void atualizarMotivo(){		

		try {
			this.servicoMotivo.atualizar(this.motivo);
			JSFUtil.addInfoMessage("Motivo " + this.motivo.getNome() + " atualizado! ");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
	}	
	

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}
    	
	
}



