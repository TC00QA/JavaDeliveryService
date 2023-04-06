package AccessObjects;

import Database.DatabaseUtils;
import Modelers.CustomerModeler;
import ObjectClasses.Customer;
import ObjectClasses.Delivery;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DeliveryAO {

    public boolean addItem(Delivery toAdd) throws SQLException {

        String statement = String.format("" + "INSERT INTO delivery" +
                        "(MilesToDrop, " +
                        "Direction, " +
                        "OrderID, " +
                        "CustomerID, " +
                        "DriverID, " +
                        "Delivered) " +
                        "VALUES ('%d', " +
                        "%s, " +
                        "'%d', " +
                        "%d, " +
                        "'%d', " +
                        "'%b') ;",
                toAdd.getMilesToDrop(),
                toAdd.getDirection(),
                toAdd.getOrderID(),
                toAdd.getCustomerID(),
                toAdd.getDriverID(),
                toAdd.getDelivered());

        boolean result = DatabaseUtils.addItem(statement);

        return result;
    }

    public boolean removeItem(int ID) throws SQLException{

        String statement = "DELETE FROM delivery WHERE ID = " + ID;

        boolean result = DatabaseUtils.deleteItem(statement);

        return result;
    }

    public boolean modifyItem(Delivery toModify, int ID) throws SQLException{


        String statement = String.format("" + "UPDATE delivery " +
                        "SET MilesToDrop = '%d', " +
                        "Direction = %s, " +
                        "OrderID = '%d', " +
                        "CustomerID = %d, " +
                        "DriverID = '%d', " +
                        "Delivered = '%b' " +
                        "WHERE ID = %d ",
                toModify.getMilesToDrop(),
                toModify.getDirection(),
                toModify.getOrderID(),
                toModify.getCustomerID(),
                toModify.getDriverID(),
                toModify.getDelivered(),
                ID);

        boolean result = DatabaseUtils.modifyItem(statement);

        return result;
    }

    public Customer readOne(int ID) throws SQLException {

        String statement = "SELECT * FROM delivery WHERE ID = " + ID;

        Optional<Customer> result = DatabaseUtils.readOne(statement, new CustomerModeler());

        if (result == null) {
            return null;
        }

        return result.get();
    }

    public List<Customer> readAll() throws SQLException {
        String statement = "SELECT * FROM delivery LIMIT 10;";

        Optional<List<Customer>> result = DatabaseUtils.readAll(statement, new CustomerModeler());

        if (result == null ) {
            return null;

        }

            return result.get();
    }
}
