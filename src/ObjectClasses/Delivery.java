package ObjectClasses;

import java.awt.image.DirectColorModel;

public class Delivery {

    private int ID;
    private int CustomerID;
    private int MilesToDrop;
    private String Direction;
    private int OrderID;
    private int DriverID;
    private boolean Delivered;

    public Delivery(int MilesToDrop, String Direction, int OrderID, int CustomerID, int DriverID, boolean Delivered){
        this.CustomerID = CustomerID;
        this.MilesToDrop = MilesToDrop;
        this.Direction = Direction;
        this.OrderID = OrderID;
        this.DriverID = DriverID;
        this.Delivered = Delivered;
    }

    public Delivery(int ID,int MilesToDrop, String Direction, int OrderID, int CustomerID, int DriverID, boolean Delivered){
        this.ID = ID;
        this.CustomerID = CustomerID;
        this.MilesToDrop = MilesToDrop;
        this.Direction = Direction;
        this.OrderID = OrderID;
        this.DriverID = DriverID;
        this.Delivered = Delivered;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getMilesToDrop() {
        return MilesToDrop;
    }

    public void setMilesToDrop(int milesToDrop) {
        MilesToDrop = milesToDrop;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getDriverID() {
        return DriverID;
    }

    public void setDriverID(int driverID) {
        DriverID = driverID;
    }

    public void setDelivered(){
        Delivered = true;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getDelivered() {
        return Delivered;
    }

    public void setDelivered(boolean delivered) {
        Delivered = delivered;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }
}
