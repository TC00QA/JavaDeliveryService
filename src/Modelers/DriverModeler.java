package Modelers;

import Database.DatabaseUtils;
import ObjectClasses.Customer;
import ObjectClasses.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverModeler implements DatabaseUtils.Modeler<Driver> {
    @Override
    public Driver modelFromResultSet(ResultSet rS) throws SQLException {
        return new Driver(
                rS.getInt("ID"),
                rS.getString("FirstName"),
                rS.getString("LastName"),
                rS.getString("Vehicle"),
                rS.getInt("Capacity"));

    }
}
