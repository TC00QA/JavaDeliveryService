package AccessObjects;

import Database.DatabaseUtils;
import Enums.VehicleTypes;
import Modelers.CustomerModeler;
import Modelers.DriverModeler;
import ObjectClasses.Customer;
import ObjectClasses.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverAO {
    private int ID;
    private String FirstName;
    private String LastName;
    private VehicleTypes Vehicle;
    private int Capacity;

    public DriverAO(){

    }

    public boolean addItem(Driver toAdd) throws SQLException {

        String statement = String.format("" + "INSERT INTO drivers" +
                        "(FirstName, " +
                        "LastName, " +
                        "Vehicle, " +
                        "Capacity) " +
                        "VALUES ('%s', " +
                        "'%s', " +
                        "%s, " +
                        "'%d) ; " +
                toAdd.getFirstName(),
                toAdd.getLastName(),
                toAdd.getVehicle().toString(),
                toAdd.getCapacity());

        boolean result = DatabaseUtils.addItem(statement);

        return result;
    }

    public boolean removeItem(int ID) throws SQLException{

        String statement = "DELETE FROM drivers WHERE ID = " + ID;

        boolean result = DatabaseUtils.deleteItem(statement);

        return result;
    }

    public boolean modifyItem(Driver toModify, int ID) throws SQLException{


        String statement = String.format("" + "UPDATE drivers " +
                        "SET FirstName = '%s', " +
                        "LastName = '%s', " +
                        "Vehicle = %s, " +
                        "Capacity = '%d', " +
                        "WHERE ID = %d ",
                toModify.getFirstName(),
                toModify.getLastName(),
                toModify.getVehicle(),
                toModify.getCapacity(),
                ID);

        boolean result = DatabaseUtils.modifyItem(statement);

        return result;
    }

    public Driver readOne(int ID) throws SQLException {

        String statement = "SELECT * FROM drivers WHERE ID = " + ID;

        Optional<Driver> result = DatabaseUtils.readOne(statement, new DriverModeler());

        if (result == null) {
            return null;
        }

        return result.get();
    }

    public List<Driver> readAll() throws SQLException {
        String statement = "SELECT * FROM drivers LIMIT 10;";

        Optional<List<Driver>> result = DatabaseUtils.readAll(statement, new DriverModeler());

        if (result == null){
            return null;

        }

        return result.get();
    }
}
