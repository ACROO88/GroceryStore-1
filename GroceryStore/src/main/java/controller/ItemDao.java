package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Item;

public class ItemDao {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("grocerystore");

	public List<Item> getAllItems() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i", Item.class);
		List<Item> all = typedQuery.getResultList();
		em.close();
		return all;
	}

}
