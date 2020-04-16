package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public class MaterialMedia extends Material{

    //ATRIBUTOS
    protected String formato;
    protected double duracionSegundos;
    protected String idioma;

    //CONSTRUCTOR POR DEFECTO
    public MaterialMedia(){
        super();
        this.formato = "";
        this.duracionSegundos = .0;
        this.idioma = "";
    }

    //CONSTRUCTOR COMPLETO
    public MaterialMedia(String signatura, String descripcion, boolean restringido, String tema,
                         String formato, double duracionSegundos, String idioma) {
        super(signatura, descripcion, restringido, tema);
        this.formato = formato;
        this.duracionSegundos = duracionSegundos;
        this.idioma = idioma;
    }

    //SEGUNDO CONSTRUCTOR ALTERNATIVO
    public MaterialMedia(String signatura, String descripcion, boolean restringido, String tema,
                         String formato,
                          double duracionSegundos) {
        super(signatura, descripcion, restringido, tema);
        this.formato = formato;
        this.duracionSegundos = duracionSegundos;
    }

    //MÉTODOS DE ACCESO GET
    public String getFormato() {
        return formato;
    }

    public double getDuracionSegundos() {
        return duracionSegundos;
    }

    public String getIdioma() {
        return idioma;
    }

    //MÉTODOS DE ACCESO SET
    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setDuracionSegundos(double duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    //MÉTODO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("FORMATO").append("\t").append(":").append("\t").append(this.getFormato().toUpperCase()).append("\n");
        builder.append("DURACIÓN").append("\t").append(":").append("\t").append(this.getDuracionSegundos()).append(" ").append(
                "S").append(
                "\n");
        builder.append("IDIOMA").append("\t").append(":").append("\t").append(this.getIdioma().toUpperCase()).append("\n");
        return builder.toString();
    }

    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values
     * @return String en formato CSV
     */
    @Override
    public String toCSV(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toCSV()).append(",");
        builder.append("Formato").append(":").append(this.getFormato()).append(",");
        builder.append("DuracionSegundos").append(":").append(this.getDuracionSegundos()).append(",");
        builder.append("Idioma").append(":").append(this.getIdioma());
        return builder.toString();
    }


    //MÉTODO EQUALS
    public boolean equals(Object o){
        return super.equals(o);
    }
}
