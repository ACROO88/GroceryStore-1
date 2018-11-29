package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Item;



public class ListItemHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("grocerystore");
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public void insertItem(Item i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Item toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.item = :selectedItem and i.deptID = :selectedDeptID"
				+ "and i.department = :selectedDepartment and i.price = :selectedPrice", Item.class);
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		typedQuery.setParameter("selectedDeptID", toDelete.getDeptID());
		typedQuery.setParameter("selectedDepartment", toDelete.getDepartment());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setMaxResults(1);
		Item result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Item> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.item = :selectedItem", Item.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<Item> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Item> searchForItemByDeptID(String deptIDName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.deptID = :selectedDeptID", Item.class);
		typedQuery.setParameter("selectedDeptID", deptIDName);

		List<Item> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Item> searchForItemByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.department = :selectedDepartment", Item.class);
		typedQuery.setParameter("selectedDepartment", departmentName);

		List<Item> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Item> searchForItemByPrice(String priceName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.price = :selectedPrice", Item.class);
		typedQuery.setParameter("selectedPrice", priceName);

		List<Item> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public Item searchForItemByItemID(int itemID){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Item found = em.find(Item.class, itemID);
		em.close();
		return found;
	}
	
	public List<Item> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i", Item.class);
		List<Item> allItems = typedQuery.getResultList();
		em.close();
		return allItems;
	}
	
	public void updateItem(Item toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
