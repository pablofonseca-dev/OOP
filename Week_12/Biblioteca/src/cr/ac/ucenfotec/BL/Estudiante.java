package cr.ac.ucenfotec.BL;

public class Estudiante extends Usuario{

    //ATRIBUTOS
    private String carrera;
    private int creditos;

    //CONSTRUCTOR POR DEFECTO
    public Estudiante(){
        super();
        carrera = "";
        creditos = 0;
    }

    //CONSTRUCTOR COMPLETO
    public Estudiante(String nombre, String primerApellido, String segundoApellido, String carne, String carrera,
                      int creditos) {
        super(nombre, primerApellido, segundoApellido, carne);
        this.carrera = carrera;
        this.creditos = creditos;
    }

    //MÉTODOS DE ACCESO GET
    public String getCarrera() {
        return carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    //MÉTODOS DE ACCESO SET
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


    //MÉTODO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-ESTUDIANTE-").append("\n");
        builder.append("NOMBRE").append("\t").append(":").append("\t").append(this.getNombre().toUpperCase()).append("\n");
        builder.append("PRIMER APELLIDO").append("\t").append(":").append("\t").append(this.getPrimerApellido().toUpperCase()).append("\n");
        builder.append("SEGUNDO APELLIDO").append("\t").append(":").append("\t").append(this.getSegundoApellido().toUpperCase()).append("\n");
        builder.append("NÚMERO DE CARNÉ").append("\t").append(":").append("\t").append(this.getIdentificacion().toUpperCase()).append("\n");
        builder.append("-DATOS ESPECÍFICOS-").append("\n");
        builder.append("CARRERA").append("\t").append(":").append("\t").append(this.getCarrera().toUpperCase()).append("\n");
        builder.append("NÚMERO DE CRÉDITOS MATRICULADOS").append("\t").append(":").append("\t").append(this.getCreditos()).append("\n");
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
        builder.append("Carrera").append(":").append(this.getCarrera()).append(",");
        builder.append("Creditos").append(":").append(this.getCreditos()).append(",");
        builder.append("TipoUsuario").append(":").append("Estudiante");
        return builder.toString();
    }
}
