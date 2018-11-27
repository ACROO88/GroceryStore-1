package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int itemID;
    private String item;
    private String deptID;
    private String department;
    private double price;
    /**
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }
    /**
     * @param itemID the itemID to set
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }
    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }
    /**
     * @return the deptID
     */
    public String getDeptID() {
        return deptID;
    }
    /**
     * @param deptID the deptID to set
     */
    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }
    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }
    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}


