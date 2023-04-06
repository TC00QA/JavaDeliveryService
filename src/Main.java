import AccessObjects.CustomerAO;
import AccessObjects.DriverAO;
import Database.DatabaseUtils;
import ManagmentSytem.App;
import ObjectClasses.Customer;
import ObjectClasses.Driver;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseUtils.applySchema();

        App mainApp = new App();
        mainApp.begin();


    }
}