package Modelers;

import Database.DatabaseUtils;
import ObjectClasses.Driver;
import ObjectClasses.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemModeler implements DatabaseUtils.Modeler<Item> {


    @Override
    public Item modelFromResultSet(ResultSet rS) throws SQLException {
        return new Item(
                rS.getInt("ID"),
                rS.getString("Name"),
                rS.getString("Description"),
                rS.getFloat("Price"));

    }
}
