package cr.ac.ucenfotec.BL;

public class Administrativo extends Usuario{

    //ATRIBUTOS
    private char tipoNombramiento;
    private int horasSemanales;

    //CONSTRUCTOR POR DEFECTO
    public Administrativo(){
        super();
        this.tipoNombramiento = ' ';
        this.horasSemanales = 0;
    }

    //CONSTRUCTOR COMPLETO
    public Administrativo(String nombre, String primerApellido, String segundoApellido, String cedula,
                          char tipoNombramiento, int horasSemanales) {
        super(nombre, primerApellido, segundoApellido, cedula);
        this.tipoNombramiento = tipoNombramiento;
        this.horasSemanales = horasSemanales;
    }

    //MÉTODOS DE ACCESO GET
    public char getTipoNombramiento() {
        return tipoNombramiento;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    //MÉTODOS DE ACCESO SET
    public void setTipoNombramiento(char tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    //MÉTODO DE ACCESO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-ADMINISTRATIVO-").append("\n");
        builder.append("NOMBRE").append("\t").append(":").append("\t").append(this.getNombre().toUpperCase()).append("\n");
        builder.append("PRIMER APELLIDO").append("\t").append(":").append("\t").append(this.getPrimerApellido().toUpperCase()).append("\n");
        builder.append("SEGUNDO APELLIDO").append("\t").append(":").append("\t").append(this.getSegundoApellido().toUpperCase()).append("\n");
        builder.append("NÚMERO DE CÉDULA").append("\t").append(":").append("\t").append(this.getIdentificacion().toUpperCase()).append("\n");
        builder.append("-DATOS ESPECÍFICOS-").append('\n');
        builder.append("TIPO DE NOMBRAMIENTO").append("\t").append(":").append("\t").append(String.valueOf(this.getTipoNombramiento()).toUpperCase()).append(
                "\n");
        builder.append("CANTIDAD DE HORAS SEMANALES ASIGNADAS").append("\t").append(":").append("\t").append(this.getHorasSemanales()).append("H").append("\n");
        builder.append(super.toString());
        return builder.toString();
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
        builder.append("TipoNombramiento").append(":").append(this.getTipoNombramiento()).append(",");
        builder.append("HorasSemanales").append(":").append(this.getHorasSemanales()).append(",");
        builder.append("TipoUsuario").append(":").append("Administrativo");
        builder.append(super.toString()).append("\n");
        return builder.toString();
    }


}
