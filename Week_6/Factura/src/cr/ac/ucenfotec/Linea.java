package cr.ac.ucenfotec;

public class Linea {
    private int quantity;
    private String code;
    private int price;
    private String description;

    public Linea(){
        this.quantity = 0;
        this.code = "";
        this.price = 0;
        this.description = "";
    }

    public Linea(int quantity, String code, int price, String description) {
        this.quantity = quantity;
        this.code = code;
        this.price = price;
        this.description = description;
    }

    //Getters
    public int getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //To String Method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(
                "-------------------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        builder.append(" DESC ").append(this.description).append("|").append(" CANT ").append(this.quantity).append(
                "|").append(" CODE ").append(this.code).append(
                "|").append(" PRICE ").append(this.price).append("|").append("\n");
        builder.append(
                "-------------------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        return builder.toString();
    }
}
