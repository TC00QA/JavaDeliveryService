package AccessObjects;


import Database.DatabaseUtils;
import Modelers.DriverModeler;
import Modelers.OrderModeler;
import ObjectClasses.Driver;
import ObjectClasses.Item;
import ObjectClasses.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdersAO {
    public boolean addItem(Order toAdd) throws SQLException {

        String statement = String.format("" + "INSERT INTO orders" +
                        "(ItemID," +
                        "CustomerID) " +
                        "VALUES ('%d'," +
                        "'%d) ; ",
                toAdd.getItemID(),
                toAdd.getCustomerID());

        boolean result = DatabaseUtils.addItem(statement);

        return result;
    }

    public boolean removeItem(int ID) throws SQLException{

        String statement = "DELETE FROM orders WHERE ID = " + ID;

        boolean result = DatabaseUtils.deleteItem(statement);

        return result;
    }

    public boolean modifyItem(Order toModify, int ID) throws SQLException{


        String statement = String.format("UPDATE orders" +
                        "SET ItemID = %d ," +
                        "CustomerID = %d" +
                        "WHERE ID = %d;",
                toModify.getItemID(),
                toModify.getCustomerID());

        boolean result = DatabaseUtils.modifyItem(statement);

        return result;
    }

    public Driver readOne(int ID) throws SQLException {

        String statement = "SELECT * FROM orders WHERE ID = " + ID;

        Optional<Driver> result = DatabaseUtils.readOne(statement, new DriverModeler());

        if (result == null) {
            return null;
        }

        return result.get();
    }

    public List<Order> readAll() throws SQLException {
        String statement = "SELECT * FROM orders LIMIT 10;";

        Optional<List<Order>> result = DatabaseUtils.readAll(statement, new OrderModeler());

        if (result == null){
            return null;

        }

        return result.get();
    }

}
