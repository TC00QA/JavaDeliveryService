package ObjectClasses;

public class Item {

    private int ID;
    private String Name;
    private String Description;
    private Float Price;

    public Item(String Name, String Description, Float Price){
        this.Name = Name;
        this.Description =Description;
        this.Price = Price;

    }
    public Item(int ID, String Name, String Description, Float Price){
        this.ID = ID;
        this.Name = Name;
        this.Description =Description;
        this.Price = Price;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }
}
