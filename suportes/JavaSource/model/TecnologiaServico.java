package model;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import entidades.Motivo;
import entidades.Tecnologia;

@Stateless
public class TecnologiaServico {

    @PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public TecnologiaServico() {

	}

	public void cadastrar(Tecnologia tecnologia) throws Exception{


		if ( !(this.consultaPorNome(tecnologia.getNome()) == null)){
			throw new Exception("A tecnologia " + tecnologia.getNome() + " já foi cadastrada!");
		}
		
		this.entityManager.persist(tecnologia);

	}

	public Tecnologia atualizar(Tecnologia tecnologia) throws Exception{
		try {
			this.entityManager.merge(tecnologia);
		} catch (RollbackException e) {
			throw new Exception(e.getMessage());
		}
		
		return tecnologia;
	}	
	
	public Tecnologia consultaPorNome(String nome){
		
		try {
			Query query = this.entityManager.createQuery("FROM Tecnologia t WHERE t.nome =:param1");
			query.setParameter("param1", nome);
			return (Tecnologia) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Tecnologia consultar(Integer id){
		
		try {
			Query query = this.entityManager.createQuery("FROM Tecnologia t WHERE t.id =:param1");
			query.setParameter("param1", id);
			return (Tecnologia) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
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

	public void excluir(Tecnologia tecnologia) throws Exception {
		
		if (tecnologia.getMotivos().size() == 0) {
			this.entityManager.remove(this.entityManager.merge(tecnologia));
		} else {
			throw new Exception(
					"Não é possível remover a tecnologia " + tecnologia.getNome() + " porque existem motivos associados.");
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Motivo> listarMotivos(Tecnologia tecnologia) {
		try {
			Query query = this.entityManager.createQuery("FROM Motivo m WHERE m.tecnologia =:param1 ORDER BY m.nome");
			query.setParameter("param1", tecnologia);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Motivo>();
		}
	}

}
