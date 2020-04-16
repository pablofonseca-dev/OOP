package cr.ac.ucenfotec.BL;

import java.time.LocalDate;
import java.util.Objects;

public class Material {
    //ATRIBUTOS
    protected String signatura;
    protected boolean restringido;
    protected String tema;
    protected String descripcion;

    //CONSTRUCTOR POR DEFECTO
    public Material(){
        this.restringido = false;
        this.tema = "";
        this.descripcion = "";
        this.signatura = "";
    }

    //CONSTRUCTOR COMPLETO
    public Material(String signatura, String descripcion, boolean restringido, String tema) {
        this.signatura = signatura;
        this.descripcion = descripcion;
        this.restringido = restringido;
        this.tema = tema;
    }

    //MÉTODOS DE ACCESO GET
    public String getSignatura() {
        return signatura;
    }

    public boolean isRestringido() {
        return restringido;
    }

    public String getTema() {
        return tema;
    }

    public String getDescripcion() {
        return descripcion;
    }


    //MÉTODOS DE ACCESO SET
    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    //MÉTODO DE ACCESO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("IDENTIFICACION").append("\t").append(":").append("\t").append(this.getSignatura().toUpperCase()).append(
                "\n");
        builder.append("DESCRIPCION").append("\t").append(":").append("\t").append(this.getDescripcion().toUpperCase()).append(
                "\n");
        builder.append("¿ESTÁ RESTRINGIDO?").append("\t").append(":").append("\t");
        if(isRestringido()){
            builder.append("SÍ").append("\n");
        }else{
            builder.append("NO").append("\n");
        }
        builder.append("TEMA").append("\t").append(":").append("\t").append(this.getTema().toUpperCase()).append("\n");
        return builder.toString();
    }

    //MÉTODO TO CSV

    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values
     * @return String en formato CSV
     */
    public String toCSV(){
        StringBuilder builder = new StringBuilder();
        builder.append("Signatura").append(":").append(this.getSignatura()).append(",");
        builder.append("Restringido").append(":").append(this.isRestringido()).append(",");
        builder.append("Tema").append(":").append(this.getTema());
        return builder.toString();
    }

    //MÉTODO EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(signatura, material.signatura);
    }
}
