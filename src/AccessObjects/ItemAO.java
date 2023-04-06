package AccessObjects;

import Database.DatabaseUtils;
import Modelers.DriverModeler;
import ObjectClasses.Driver;
import ObjectClasses.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ItemAO {

    public boolean addItem(Item toAdd) throws SQLException {

        String statement = String.format("" + "INSERT INTO items" +
                        "(Name," +
                        "Description, " +
                        "Price) " +
                        "VALUES ('%s'," +
                        "%s, " +
                        "'%d) ; ",
                toAdd.getName(),
                toAdd.getDescription(),
                toAdd.getPrice());

        boolean result = DatabaseUtils.addItem(statement);

        return result;
    }

    public boolean removeItem(int ID) throws SQLException{

        String statement = "DELETE FROM items WHERE ID = " + ID;

        boolean result = DatabaseUtils.deleteItem(statement);

        return result;
    }

    public boolean modifyItem(Item toModify, int ID) throws SQLException{


        String statement = String.format("UPDATE items" +
                "SET Name = '%s'," +
                "Description = '%s'," +
                "Price = '%d'" +
                "WHERE ID = %d;",
                toModify.getName(),
                toModify.getDescription(),
                toModify.getPrice());

        boolean result = DatabaseUtils.modifyItem(statement);

        return result;
    }

    public Driver readOne(int ID) throws SQLException {

        String statement = "SELECT * FROM items WHERE ID = " + ID;

        Optional<Driver> result = DatabaseUtils.readOne(statement, new DriverModeler());

        if (result == null) {
            return null;
        }

        return result.get();
    }

    public List<Driver> readAll() throws SQLException {
        String statement = "SELECT * FROM items LIMIT 10;";

        Optional<List<Driver>> result = DatabaseUtils.readAll(statement, new DriverModeler());

        if (result == null){
            return null;

        }

        return result.get();
    }
}
