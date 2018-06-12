package br.senac.rj.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOGenerico<TIPO> {
	protected EntityManager em;
	protected Class classePersistente;
	private EntityManagerFactory factory;
	
	protected DAOGenerico(){
		em = getEntityManager();
	}
	
	
	
	private EntityManager getEntityManager(){
		factory = Persistence.createEntityManagerFactory("minhaLoja");
		
		if(em == null){
			em = factory.createEntityManager();
		}
		return em;
	}
	
	public void encerrar(){
		em.close();
		factory.close();
	}
	
	//crud 
	public void gravar(TIPO obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	
	public void atualizar(TIPO obj){
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public TIPO buscaPorId(int id){
		return (TIPO) em.find(classePersistente, id);
	}
	
	public void remover(int id){
		TIPO obj = buscaPorId(id);
		
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<TIPO> getTodosObjetos(){
		
		return em.createNamedQuery("from " + classePersistente.getName()).getResultList();
		
	}
}
