package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCar;

public class ListCarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarShow");

	public void insertCar(ListCar li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListCar> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<ListCar> allCars = em.createQuery("SELECT i FROM ListCar i").getResultList();
		return allCars;
	}

	public void deleteCar(ListCar toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar> typedQuery = em.createQuery(
				"select	li from ListCar li where li.make = :selectedMake and li.model = :selectedModel and li.year = :selectedYear",
				ListCar.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		ListCar result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListCar searchForCarById(int idToEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCar	found	=	em.find(ListCar.class,	idToEdit);
		em.close();
		return	found;
	}

	public void updateCar(ListCar toEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListCar> searchForCarByMake(String makeName) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery(
				"select	li	from ListCar li where li.make = :selectedMake", ListCar.class);
		typedQuery.setParameter("selectedMake",	makeName);
		List<ListCar>	foundCars	=	typedQuery.getResultList();
		em.close();
		return	foundCars;
		}

	

	public List<ListCar> searchForCarByModel(String modelName) {
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery(
				"select	li	from ListCar li where li.model	= :selectedModel", ListCar.class);
		typedQuery.setParameter("selectedItem",	modelName);
		List<ListCar>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public List<ListCar> searchForCarByYear(String year) {
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery(
				"select	li	from ListCar li where li.year	= :selectedYear", ListCar.class);
		typedQuery.setParameter("selectedItem",	year);
		List<ListCar>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public	void	cleanUp(){
		emfactory.close();
	}
}