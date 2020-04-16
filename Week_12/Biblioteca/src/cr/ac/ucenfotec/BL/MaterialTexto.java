package cr.ac.ucenfotec.BL;

import java.time.LocalDate;
import java.util.Objects;

public class MaterialTexto extends Material{
    //ATRIBUTOS
    private String titulo;
    private LocalDate fechaPublicacion;
    private String nombreAutor;
    private int cantidadPaginas;
    private String idioma;

    //CONSTRUCTOR POR DEFECTO
    public MaterialTexto(){
        super();
        this.titulo = "";
        this.cantidadPaginas = 0;
        this.idioma = "";
    }

    //CONSTRUCTOR COMPLETO
    public MaterialTexto(String signatura, boolean restringido, String tema, String titulo,
                         String nombreAutor,
                         LocalDate fechaPublicacion, int cantidadPaginas, String idioma) {
        super(signatura, "Material Textual", restringido, tema);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.cantidadPaginas = cantidadPaginas;
        this.idioma = idioma;
    }

    //MÉTODOS DE ACCESO GET
    public String getTitulo() {
        return titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    //MÉTODOS DE ACCESO SET
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    //MÉTODO DE ACCESO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-MATERIAL TEXTUAL-").append("\n");
        builder.append(super.toString());
        builder.append("TÍTULO").append("\t").append(":").append("\t").append(this.getTitulo().toUpperCase()).append("\n");
        builder.append("FECHA DE PUBLICACIÓN").append("\t").append(":").append("\t").append(this.getFechaPublicacion()).append("\n");
        builder.append("CANTIDAD DE PÁGINAS").append("\t").append(":").append("\t").append(this.getCantidadPaginas()).append("\t").append("PÁGINA" +
                "(S)").append("\n");
        builder.append("IDIOMA").append("\t").append(":").append("\t").append(this.getIdioma().toUpperCase()).append("\n");
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
        builder.append("Titulo").append(":").append(this.getTitulo()).append(",");
        builder.append("NombreAutor").append(":").append(this.getNombreAutor()).append(",");
        builder.append("FechaPublicacion").append(":").append(this.getFechaPublicacion()).append(",");
        builder.append("CantidadPaginas").append(":").append(this.getCantidadPaginas()).append(",");
        builder.append("Idioma").append(":").append(this.getIdioma()).append(",");
        builder.append("TipoMaterial").append(":").append("Texto");
        return builder.toString();
    }

    //MÉTODO EQUALS
    //COMPARA CON LA SIGNATURA Y EL NOMBRE DEL TEXTO
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaterialTexto that = (MaterialTexto) o;
        return Objects.equals(titulo, that.titulo);
    }
}
