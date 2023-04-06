package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseUtils {
    private final static String dbUri = "jdbc:h2:file:./resources;";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUri);
    }
    public static DatabaseUtils instance;
    public static DatabaseUtils getInstance(){
        if (instance == null){
            instance = new DatabaseUtils();
        }

        return instance;
    }

    public static <T> Optional<List<T>> readAll(String statement, Modeler<T> Modeler) throws SQLException{

        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmnt = conn.prepareStatement(statement);
        ) {

            ResultSet resultSet = stmnt.executeQuery();

            List<T> result = new ArrayList<T>();

            while (resultSet.next()){

                result.add(Modeler.modelFromResultSet(resultSet));

            }

            return Optional.ofNullable(result);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static <T> Optional<T> readOne(String statement, Modeler<T> Modeler) throws SQLException {

        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmnt = conn.prepareStatement(statement);
        ) {

            ResultSet resultSet = stmnt.executeQuery();
            resultSet.next();
            return Optional.ofNullable(Modeler.modelFromResultSet(resultSet));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;

    }

    public static boolean addOne(String statement) throws SQLException{
        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmt = conn.prepareStatement(statement)){
                int inserted = stmt.executeUpdate();
                if (inserted == 1) {
                    return true;
                }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean modifyItem(String statement) throws SQLException{
        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmt = conn.prepareStatement(statement)){
            int modified = stmt.executeUpdate();
            if (modified == 1) {
                return true;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean deleteItem(String statement) throws SQLException{
        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmt = conn.prepareStatement(statement)){
            int deleted = stmt.executeUpdate();
            if (deleted == 1) {
                return true;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean addItem(String statement) throws SQLException{
        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmt = conn.prepareStatement(statement)){
            int added = stmt.executeUpdate();
            if (added == 1) {
                return true;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static void applySchema() throws SQLException {

        try ( Connection conn = DatabaseUtils.getConnection();
              PreparedStatement stmt = conn.prepareStatement(Schema.schema)){
                stmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public abstract interface Modeler<T>{
        T modelFromResultSet(ResultSet rs) throws SQLException;


    }


}
