package cr.ac.ucenfotec.BL;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements toCSVFormat{

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    private String detalleDireccion;

    private ArrayList<CuentaBancaria> cuentasBancarias;

    public Cliente(){
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.identificacion = "";
        this.detalleDireccion = "";

        this.cuentasBancarias = new ArrayList<>();
    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, String identificacion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.identificacion = identificacion;

        this.cuentasBancarias = new ArrayList<>();
    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, String identificacion, String detalleDireccion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.identificacion = identificacion;
        this.detalleDireccion = detalleDireccion;

        this.cuentasBancarias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDetalleDireccion() {
        return detalleDireccion;
    }

    public ArrayList<CuentaBancaria> obtenerCuentas(){
        return cuentasBancarias;
    }

    public void agregarCuentaBancaria(CuentaBancaria objCuentaBancaria){
        this.cuentasBancarias.add(objCuentaBancaria);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDetalleDireccion(String detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    @Override
    public String toString(){
        StringBuilder format = new StringBuilder();
        format.append("-----------------------CLIENTE--------------------------").append("\n");
        format.append("Nombre : ").append(getNombre()).append("\n");
        format.append("Primer Apellido : ").append(getPrimerApellido()).append("\n");
        format.append("Segundo Apellido : ").append(getSegundoApellido()).append("\n");
        format.append("Identificación : ").append(getIdentificacion()).append("\n");
        if(getDetalleDireccion() != null)
            format.append("Localidad : ").append(getDetalleDireccion()).append("\n\n");
        if(cuentasBancarias.size() > 0){
            format.append("-----------------CUENTAS DEL CLIENTE---------------------").append("\n");
            for(CuentaBancaria e: cuentasBancarias){
                format.append(e.toString()).append("\n");
            }
        }
        format.append("---------------------------------------------------------").append("\n");
        return String.valueOf(format);
    }

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */
    @Override
    public String toCSVString() {
        StringBuilder format = new StringBuilder();
            format.append("Nombre").append(":").append(this.getNombre()).append(",");
            format.append("PrimerApellido").append(":").append(this.getPrimerApellido()).append(",");
            format.append("SegundoApellido").append(":").append(this.getSegundoApellido()).append(",");
            format.append("Identificacion").append(":").append(this.getIdentificacion()).append(",");
            format.append("DetalleDireccion").append(":").append(this.getDetalleDireccion().replace(",", " "));
        return String.valueOf(format);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(identificacion, cliente.identificacion);
    }

}
