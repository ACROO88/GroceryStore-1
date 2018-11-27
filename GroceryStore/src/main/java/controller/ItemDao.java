package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Item;



public class ItemDao {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Item");
/*
	public List<Item> getAllItems() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select i from Item i"; //< this isnt the name of the table
		TypedQuery<Item> typedQuery = em.createQuery(q, Item.class);
		List<Item> all = typedQuery.getResultList();
		return all;
	}
	
}
*/

//How I used it in my DAO

public List<Item> getAllItems() {
EntityManager em = emfactory.createEntityManager();
TypedQuery<Item> typedQuery = em.createQuery("select g from grocerystore g", Item.class);
List<Item> all = typedQuery.getResultList();
em.close();
return all;
}

}
