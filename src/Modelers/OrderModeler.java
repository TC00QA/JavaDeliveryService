package Modelers;

import Database.DatabaseUtils;
import ObjectClasses.Order;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderModeler implements DatabaseUtils.Modeler<Order> {

    @Override
    public Order modelFromResultSet(ResultSet rS) throws SQLException {
        return new Order(
                rS.getInt("ID"),
                rS.getInt("ItemID"),
                rS.getInt("CustomerID"));

    }
}
