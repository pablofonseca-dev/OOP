package Topics;

//Introduction to TableView
public class Product {
    //Attributes
    private String name;
    private double price;
    private int quantity;

    //Default Constructor
    public Product(){
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    //Complex Constructor
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
