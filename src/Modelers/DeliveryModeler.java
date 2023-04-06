package Modelers;

import Database.DatabaseUtils;
import ObjectClasses.Customer;
import ObjectClasses.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryModeler implements DatabaseUtils.Modeler<Delivery> {
    @Override
    public Delivery modelFromResultSet(ResultSet rS) throws SQLException {
        return new Delivery(
                rS.getInt("MilesToDrop"),
                rS.getString("Direction"),
                rS.getInt("OrderID"),
                rS.getInt("CustomerID"),
                rS.getInt("DriverID"),
                rS.getBoolean("Delivered")
        );
    }
}
