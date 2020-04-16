package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public class MaterialVideo extends MaterialMedia{
    //ATRIBUTOS
    private String director;

    //CONSTRUCTOR POR DEFECTO
    public MaterialVideo() {
        super();
        this.director = "";
    }

    //CONSTRUCTOR COMPLETO
    public MaterialVideo(String signatura, boolean restringido, String tema, String formato, double duracionSegundos, String idioma, String director) {
        super(signatura, "Material de tipo Video", restringido, tema, formato, duracionSegundos, idioma);
        this.director = director;
    }

    //MÉTODOS DE ACCESO GET
    public String getDirector() {
        return director;
    }

    //MÉTODOS DE ACCESO SET
    public void setDirector(String director) {
        this.director = director;
    }

    //MÉTODOS DE ACCESO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-MATERIAL DE VIDEO-").append("\n");
        builder.append(super.toString());
        builder.append("-DATOS ESPECÍFICOS-").append("\n");
        builder.append("DIRECTOR").append("\t").append(":").append("\t").append(this.director.toUpperCase()).append("\n");
        return builder.toString();
    }

    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values.
     * @return String en formato CSV
     */
    @Override
    public String toCSV() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toCSV()).append(",");
        builder.append("Director").append(":").append(this.getDirector()).append(",");
        builder.append("TipoMaterial").append(":").append("Video");
        return builder.toString();
    }
}
