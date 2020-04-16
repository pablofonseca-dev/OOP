package cr.ac.ucenfotec.BL;

import cr.ac.ucenfotec.DL.DataAccess;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    //ATRIBUTOS
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String identificacion;
    protected ArrayList<LocalDate> fechasPrestamos;

    //RELACIÓN ENTRE OBJETOS
    private ArrayList<Material> materiales;

    //VARIABLES PROPIAS DE LA CLASE
    private static FileWriter writer;
    private static BufferedWriter bufferedWriter;

    //CONSTRUCTOR POR DEFECTO
    public Usuario(){
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.identificacion = "";
    }

    //CONSTRUCTOR CON TODOS LOS ATRIBUTOS
    public Usuario(String nombre, String primerApellido, String segundoApellido, String identificacion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.identificacion = identificacion;
    }

    //MÉTODOS DE ACCESO GET
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

    public ArrayList<LocalDate> obtenerFechaPrestamos(){
        return this.fechasPrestamos;
    }

    //MÉTODO PARA AGREGAR UN MATERIAL A UN USUARIO
    public void agregarMaterial(Material objMaterial){
        if(this.materiales == null)
            this.materiales = new ArrayList<>();
        this.materiales.add(objMaterial);
    }

    //MÉTODO PARA RETORNAR LOS MATERIALES DE UN USUARIO
    public ArrayList<Material> obtenerMateriales(){
        if(materiales == null)
            this.materiales = new ArrayList<>();
        return this.materiales;
    }

    //MÉTODOS DE ACCESO SET
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

    public void asignarFechaPrestamo(LocalDate fechaPrestamo){
        if(fechasPrestamos == null)
            fechasPrestamos = new ArrayList<>();
        this.fechasPrestamos.add(fechaPrestamo);
    }


    //MÉTODO TO STRING
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(materiales != null){
            builder.append("\n\n\n");
            builder.append("{PRESTAMOS DE").append(" ").append(this.getNombre()).append("}").append("\n\n");
            int i = 0;
            for(Material e: materiales){
                builder.append("{PRESTAMO").append(" ").append(i+1).append("}").append("\n");
                if(fechasPrestamos != null) {
                    builder.append("<<FECHA DEL PRESTAMO>>").append("\n");
                    builder.append(fechasPrestamos.get(i)).append("\n");
                }
                builder.append(e.toString()).append("\n");
                i++;
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    //MÉTODO TO CSV

    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values
     * @return String en formato CSV
     */
    public String toCSV(){
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre").append(":").append(this.getNombre()).append(",");
        builder.append("PrimerApellido").append(":").append(this.getPrimerApellido()).append(",");
        builder.append("SegundoApellido").append(":").append(this.getSegundoApellido()).append(",");
        builder.append("Identificacion").append(":").append(this.getIdentificacion());
        return builder.toString();
    }

    //MÉTODO EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return identificacion.equals(usuario.identificacion);
    }


}
