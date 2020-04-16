package cr.ac.ucenfotec.BL;

public class Tiquete {

    private double precio;
    private String numeroAsiento;
    private String numeroTiquete;

    public Tiquete(double precio, String numeroAsiento, String numeroTiquete) {
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
        this.numeroTiquete = numeroTiquete;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getNumeroTiquete() {
        return numeroTiquete;
    }

    public void setNumeroTiquete(String numeroTiquete) {
        this.numeroTiquete = numeroTiquete;
    }

    @Override
    public String toString() {
        return "Tiquete{" +
                "precio=" + precio +
                ", numeroAsiento='" + numeroAsiento + '\'' +
                ", numeroTiquete='" + numeroTiquete + '\'' +
                '}';
    }
}
