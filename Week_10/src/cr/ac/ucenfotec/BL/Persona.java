package cr.ac.ucenfotec.BL;

public class Persona {

    //Object Attributes
    private String nombre;
    private String apellido;
    private String cedula;
    private char Genero;

    //Object Default Constructor
    public Persona() {

    }

    //Object Second Constructor
    public Persona(String nombre, String apellido, String cedula, char genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        Genero = genero;
    }

    //Object Getter and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char genero) {
        Genero = genero;
    }

    //Object To String Method
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre").append(":").append("\t").append(this.getNombre()).append("\n");
        builder.append("Primer Apellido").append(":").append("\t").append(this.getApellido()).append("\n");
        builder.append("Cédula de Identidad").append(":").append("\t").append(this.getCedula()).append("\n");
        builder.append("Género").append(":").append("\t");
        if(String.valueOf(getGenero()).equalsIgnoreCase("M"))
            builder.append("Masculino").append("\n");
        else
            builder.append("Femenino").append("\n");
        return builder.toString();
    }

    /**
     * Retorna los valores de la clase en Comma Separated Values.
     * @return String en formato CSV.
     */
    public String toStringCSV(){
        String CSVData = this.getNombre() + "," + this.getApellido() + "," + this.getCedula() + ",";
        if(this.getGenero() == 'M' || this.getGenero() == 'm')
            CSVData += "Masculino";
        else
            CSVData += "Femenino";
        return CSVData;
    }

    //Object Equals Method
    //Compare a cr.ac.ucenfotec.BL.Persona with its Identification.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return cedula.equals(persona.cedula);
    }
}
