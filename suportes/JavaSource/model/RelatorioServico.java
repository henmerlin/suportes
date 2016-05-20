package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Atendimento;
import entidades.Motivo;

@Stateless
public class RelatorioServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;
	
	public RelatorioServico() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listaAtendimentos(Date dataInicio, Date dataFim) {
		
		Query query = this.entityManager.createQuery("FROM Atendimento a WHERE a.data BETWEEN :param1 AND :param2");
		query.setParameter("param1", dataInicio);
		query.setParameter("param2", dataFim);
		
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Motivo> listarMotivos() {
		
		Query query = this.entityManager.createQuery("FROM Motivo m");
		return query.getResultList();
		
	}

}
