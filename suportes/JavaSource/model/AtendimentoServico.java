package model;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AtendimentoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public AtendimentoServico() {

	}

	
	

}
