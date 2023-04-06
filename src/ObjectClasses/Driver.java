package ObjectClasses;

import Enums.VehicleTypes;

public class Driver {

    private int ID;
    private String FirstName;
    private String LastName;
    private VehicleTypes Vehicle;
    private int Capacity;

    public Driver(String FirstName, String LastName, String Vehicle, int Capacity){
        this.FirstName = FirstName;
        this.LastName = LastName;

        if (Vehicle == "CAR"){
            this.Vehicle = VehicleTypes.CAR;
        } else if (Vehicle == "VAN"){
            this.Vehicle = VehicleTypes.VAN;
        }else if (Vehicle == "TRUCK"){
            this.Vehicle = VehicleTypes.TRUCK;
        } else {
            this.Vehicle = null;
        }

        this.Capacity = Capacity;
    }
    public Driver(int ID, String FirstName, String LastName, String Vehicle, int Capacity){
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;

        if (Vehicle == "CAR"){
            this.Vehicle = VehicleTypes.CAR;
        } else if (Vehicle == "VAN"){
            this.Vehicle = VehicleTypes.VAN;
        }else if (Vehicle == "TRUCK"){
            this.Vehicle = VehicleTypes.TRUCK;
        } else {
            this.Vehicle = null;
        }

        this.Capacity = Capacity;
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

    public VehicleTypes getVehicle() {
        return Vehicle;
    }

    public void setVehicle(VehicleTypes vehicle) {
        Vehicle = vehicle;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
