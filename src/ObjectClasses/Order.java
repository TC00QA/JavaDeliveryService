package ObjectClasses;

public class Order {

    public int ID;
    public int ItemID;
    public int CustomerID;

    public Order(int ID, int ItemID, int CustomerID){
        this.ID = ID;
        this.ItemID = ItemID;
        this.CustomerID = CustomerID;

    }

    public Order(int ItemID, int CustomerID){
        this.ItemID = ItemID;
        this.CustomerID = CustomerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }
}
