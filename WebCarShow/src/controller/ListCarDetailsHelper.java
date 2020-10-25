package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCarDetails;

public class ListCarDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarShow");

	public void insertNewListCarDetails(ListCarDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListCarDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListCarDetails> allDetails = em.createQuery("SELECT d FROM ListCarDetails d").getResultList();
		return allDetails;
	}

	public ListCarDetails searchForListCarDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCarDetails found = em.find(ListCarDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(ListCarDetails ToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCarDetails> typedQuery = 
				em.createQuery("select detail from ListCarDetails detail where detail.id = :selectedId", ListCarDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", ToDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		ListCarDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateList(ListCarDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();	
	}
}
