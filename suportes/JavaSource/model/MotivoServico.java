package model;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Motivo;

@Stateless
public class MotivoServico {

    @PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public MotivoServico() {

	}
	
	public void cadastrar(Motivo motivo){
		
		this.entityManager.persist(motivo);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Motivo> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Motivo m");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Motivo>();
		}
	}

	public void excluir(Motivo motivo) throws Exception {
		
		try {
			this.entityManager.remove(this.entityManager.merge(motivo));
		} catch (Exception e) {
			throw new Exception("Erro ao excluir motivo!");
		}
		
	}
	
}
