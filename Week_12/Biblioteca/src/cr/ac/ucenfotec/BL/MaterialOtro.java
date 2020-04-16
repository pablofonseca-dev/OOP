package cr.ac.ucenfotec.BL;

public class MaterialOtro extends Material{

    //CONSTRUCTOR POR DEFECTO
    public MaterialOtro(){
        super();
    }

    //CONSTRUCTOR COMPLETO
    public MaterialOtro(String signatura, String descripcion) {
        super.signatura = signatura;
        super.descripcion = descripcion;
    }

    //MÉTODO TO STRING
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-MATERIAL OTRO-").append("\n");
        builder.append("IDENTIFICACION").append("\t").append(":").append("\t").append(super.getSignatura()).append(
                "\n");
        builder.append("DESCRIPCIÓN").append("\t").append(":").append("\t").append(super.getDescripcion()).append("\n");
        return builder.toString();
    }

    //MÉTODO TO CSV
    /**
     * Método que se encarga establecer los atributos en formato Comma-Separated-Values
     *
     * @return String en formato CSV
     */
    @Override
    public String toCSV() {
        StringBuilder builder = new StringBuilder();
        builder.append("Signatura").append(":").append(this.getSignatura()).append(",");
        builder.append("Descripcion").append(":").append(this.getDescripcion()).append(",");
        builder.append("TipoMaterial").append(":").append("Otro");
        return builder.toString();
    }
}
