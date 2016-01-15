package model;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Tecnologia;

@Stateless
public class TecnologiaServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public TecnologiaServico() {
		
	}
	
	public void cadastrar(Tecnologia tecnologia){
		
		this.entityManager.persist(tecnologia);
		
	}

	@SuppressWarnings("unchecked")
	public List<Tecnologia> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Tecnologia t");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Tecnologia>();
		}
	}
	
}
