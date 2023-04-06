package Database;

public class Schema {

    public final static String schema = """
            CREATE TABLE IF NOT EXISTS customers (
                ID INT NOT NULL AUTO_INCREMENT,
                FirstName VARCHAR(20),
                LastName VARCHAR(20),
                HouseNumber INT,
                StreetName VARCHAR(40),
                PostCode VARCHAR (7),
                        
                PRIMARY KEY (ID)
            );
                        
            CREATE TABLE IF NOT EXISTS drivers (
                ID INT NOT NULL AUTO_INCREMENT,
                FirstName VARCHAR(20),
                LastName VARCHAR(20),
                Vehicle VARCHAR(8),
                Capacity INT,
                        
                PRIMARY KEY (ID)
            );
                        
            CREATE TABLE IF NOT EXISTS items (
                ID INT NOT NULL AUTO_INCREMENT,
                Name VARCHAR(20),
                Description VARCHAR(50),
                Price FLOAT,
                        
                PRIMARY KEY(ID)
                        
            );
                        
            CREATE TABLE IF NOT EXISTS orders (
                ID INT NOT NULL AUTO_INCREMENT,
                ItemID INT,
                CustomerID INT,
                        
                PRIMARY KEY(ID),
                FOREIGN KEY(ItemID) REFERENCES items(ID),
                FOREIGN KEY(CustomerID) REFERENCES customers(ID)
            );
                        
                        
            CREATE TABLE IF NOT EXISTS delivery (
                ID INT NOT NULL AUTO_INCREMENT,
                MilesToDrop INT,
                Direction VARCHAR(5),
                OrderID INT,
                CustomerID INT,
                DriverID INT,
                Delivered BOOLEAN,
                        
                PRIMARY KEY(ID),
                FOREIGN KEY(OrderID) REFERENCES orders(ID),
                FOREIGN KEY(CustomerID) REFERENCES customers(ID),
                FOREIGN KEY(DriverID) REFERENCES drivers(ID)
            );          
            """;
}
