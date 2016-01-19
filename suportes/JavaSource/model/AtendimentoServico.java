package model;


import java.util.Date;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import entidades.Atendimento;
import entidades.Usuario;

@Stateless
public class AtendimentoServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public AtendimentoServico() {

	}

	public Atendimento iniciar(Atendimento atendimento){
		
		Date inicio = new Date();
		atendimento.setInicio(inicio);
		
		this.entityManager.persist(atendimento);

		
		return atendimento;
	}
	
	public void salvar(Atendimento atendimento){
		
		Date fim = new Date();
		atendimento.setFim(fim);
		
		this.entityManager.merge(atendimento);
	}	
	
	public Atendimento obterAtendimento(Atendimento atendimento){
		
		try {
			Query query = this.entityManager.createQuery("FROM Atendimento a WHERE a.Id =:param1");
			query.setParameter("param1", atendimento.getId());
			return (Atendimento) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
