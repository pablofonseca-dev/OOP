package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public class Profesor extends Usuario{

    //ATRIBUTOS
    private String tipoContrato;
    private LocalDate fechaContratacion;

    //CONSTRUCTOR POR DEFECTO
    public Profesor(){
        super();
        this.tipoContrato = "";
        this.fechaContratacion = LocalDate.now();
    }

    //CONSTRUCTOR COMPLETO
    public Profesor(String nombre, String primerApellido, String segundoApellido, String cedula,
                    String tipoContrato, LocalDate fechaContratacion) {
        super(nombre, primerApellido, segundoApellido, cedula);
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    //MÉTODOS DE ACCESO GET
    public String getTipoContrato() {
        return tipoContrato;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    //MÉTODOS DE ACCESO SET
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }


    //MÉTODO TO STRING
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-PROFESOR-").append("\n");
        builder.append("NOMBRE").append("\t").append(":").append("\t").append(this.getNombre().toUpperCase()).append(
                "\n");
        builder.append("PRIMER APELLIDO").append("\t").append(":").append("\t").append(this.getPrimerApellido().toUpperCase()).append("\n");
        builder.append("SEGUNDO APELLIDO").append("\t").append(":").append("\t").append(this.getSegundoApellido().toUpperCase()).append("\n");
        builder.append("NÚMERO DE CÉDULA").append("\t").append(":").append("\t").append(this.getIdentificacion().toUpperCase()).append("\n");
        builder.append("-DATOS ESPECÍFICOS-").append("\n");
        builder.append("TIPO DE CONTRATO").append("\t").append(":").append("\t").append(this.getTipoContrato()).append("\n");
        builder.append("FECHA DE CONTRATACIÓN").append("\t").append(":").append("\t").append(this.getFechaContratacion()).append("\n");
        builder.append(super.toString()).append("\n");
        return builder.toString();
    }

    //MÉTODO EQUALS
    @Override
    public boolean equals(Object o){
       return super.equals(o);
    }

    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values
     *
     * @return String en formato CSV
     */
    @Override
    public String toCSV() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toCSV()).append(",");
        builder.append("TipoContrato").append(":").append(this.getTipoContrato()).append(",");
        builder.append("FechaContratacion").append(":").append(this.getFechaContratacion()).append(",");
        builder.append("TipoUsuario").append(":").append("Profesor");
        return builder.toString();
    }
}
