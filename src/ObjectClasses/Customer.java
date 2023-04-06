package ObjectClasses;

public class Customer {

    private int ID;
    private String FirstName;
    private String LastName;
    private int HouseNumber;
    private String StreetName;
    private String PostCode;

    public Customer(String FirstName, String LastName, int HouseNumber, String StreetName, String PostCode){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.HouseNumber = HouseNumber;
        this.StreetName = StreetName;
        this.PostCode = PostCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
