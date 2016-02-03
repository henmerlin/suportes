package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Atendimento;

@Stateless
public class AtendimentoServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public AtendimentoServico() {

	}
	
	public void salvar(Atendimento atendimento){
		
		Date data = new Date();
		atendimento.setData(data);
		this.entityManager.persist(atendimento);
		
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
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Atendimento a");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Atendimento>();
		}
	}
}
