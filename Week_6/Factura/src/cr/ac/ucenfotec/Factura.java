package cr.ac.ucenfotec;

import java.util.ArrayList;

public class Factura {
    private String number;
    private String client;
    private double tax;
    private Fecha date;

    private ArrayList<Linea> lines;

    public Factura(String number, String client, double tax) {
        this.number = number;
        this.client = client;
        this.tax = tax;
    }

    public double calculateSubtotal(){
        double subtotalCounter = .0;
        if(lines != null){
            for(Linea e: lines){
                subtotalCounter += e.getPrice() * e.getQuantity();
            }
        }
        return subtotalCounter;
    }

    public double calculateTotal(){
        double totalCounter = .0;
        totalCounter = calculateSubtotal();
        if(this.tax > 0){
            totalCounter += this.tax;
        }
        return totalCounter;
    }

    //Getters


    public Fecha getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }

    public String getClient() {
        return client;
    }

    public double getTax() {
        return tax;
    }

    public ArrayList<Linea> getLines() {
        return lines;
    }

    //Setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void addLine(Linea lineObject) {
        if(this.lines != null) {
            this.lines.add(lineObject);
        }else {
            this.lines = new ArrayList<Linea> ();
            this.lines.add(lineObject);
        }
    }

    public void setDate(Fecha date) {
        this.date = date;
    }

    //To String Method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(
                "-------------------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        builder.append(" CLIENTE: " ).append(this.client).append("\n");
        builder.append(" NUM: ").append(this.number).append("\n");
        if(this.date != null) {
            builder.append(" FECHA DE COMPRA: ").append(this.date).append("\n");
        }
        builder.append(
                "-------------------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        if(this.lines != null){
            for(Linea e: lines){
                builder.append(e.toString());
            }
        }
        builder.append(
                "-------------------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        if(calculateSubtotal() > 0) {
            builder.append("SUBTOTAL : ").append(this.calculateSubtotal()).append("\n");
        }
        builder.append("TAX : ").append(this.tax).append("\n");
        if(calculateTotal() > 0) {
            builder.append("TOTAL: ").append(this.calculateTotal()).append("\n");
        }
        return builder.toString();
    }
}
