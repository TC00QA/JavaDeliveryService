package AccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract interface AOInterface<T> {

    T modelFromResultSet(ResultSet resultSet) throws SQLException;
    T addItem(T t);
    boolean removeItem(T t);
    boolean modifyItem(T t);
    T readOne(T t);
    List<T> readAll();

}
