package AccessObjects;

import Database.DatabaseUtils;
import Modelers.CustomerModeler;
import ObjectClasses.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerAO {

    public boolean addItem(Customer toAdd) throws SQLException {

        String statement = String.format("" + "INSERT INTO customers" +
                        "(FirstName, " +
                        "LastName, " +
                        "HouseNumber, " +
                        "StreetName, " +
                        "PostCode) " +
                        "VALUES ('%s', " +
                        "'%s', " +
                        "%d, " +
                        "'%s', " +
                        "'%s') ;",
                toAdd.getFirstName(),
                toAdd.getLastName(),
                toAdd.getHouseNumber(),
                toAdd.getStreetName(),
                toAdd.getPostCode());

        boolean result = DatabaseUtils.addItem(statement);

        return result;
    }

    public boolean removeItem(int ID) throws SQLException{

        String statement = "DELETE FROM customers WHERE ID = " + ID;

        boolean result = DatabaseUtils.deleteItem(statement);

        return result;
    }

    public boolean modifyItem(Customer toModify, int ID) throws SQLException{


        String statement = String.format("" + "UPDATE customers " +
                "SET FirstName = '%s', " +
                "LastName = '%s', " +
                "HouseNumber = %d, " +
                "StreetName = '%s', " +
                "PostCode = '%s' " +
                "WHERE ID = %d ",
                toModify.getFirstName(),
                toModify.getLastName(),
                toModify.getHouseNumber(),
                toModify.getStreetName(),
                toModify.getPostCode(),
                ID);

        boolean result = DatabaseUtils.modifyItem(statement);

        return result;
    }

    public Customer readOne(int ID) throws SQLException {

        String statement = "SELECT * FROM customers WHERE ID = " + ID;

        Optional<Customer> result = DatabaseUtils.readOne(statement, new CustomerModeler());

        if (result == null) {
            return null;
        }

        return result.get();
    }

    public List<Customer> readAll() throws SQLException {
        String statement = "SELECT * FROM customers LIMIT 10;";

        Optional<List<Customer>> result = DatabaseUtils.readAll(statement, new CustomerModeler());

        if (result == null){
            return null;

        }

        return result.get();
    }


}
