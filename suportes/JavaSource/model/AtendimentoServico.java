package model;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Atendimento;

@Stateless
public class AtendimentoServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public AtendimentoServico() {

	}

	public void iniciar(Atendimento atendimento){

		this.entityManager.persist(atendimento);
		
	}
	
	

}
