package Modelers;

import Database.DatabaseUtils;
import ObjectClasses.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModeler implements DatabaseUtils.Modeler<Customer> {
    @Override
    public Customer modelFromResultSet(ResultSet rS) throws SQLException {
        return new Customer(rS.getString("FirstName"),
                rS.getString("LastName"),
                rS.getInt("HouseNumber"),
                rS.getString("StreetName"),
                rS.getString("PostCode"));
    }
}
