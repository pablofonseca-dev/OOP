package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public class MaterialAudio extends MaterialMedia{

    //CONSTRUCTOR POR DEFECTO
    public MaterialAudio(){
        super();
    }

    //CONSTRUCTOR COMPLETO
    public MaterialAudio(String signatura, boolean restringido, String tema, String formato, double duracionSegundos) {
        super(signatura, "Material Auditivo", restringido, tema, formato, duracionSegundos, "IDENTIFIDO");
    }

    //SEGUNDO CONSTRUCTOR ALTERNATIVO
    public MaterialAudio(String signatura, boolean restringido, String tema, String formato, double duracionSegundos, String idioma) {
        super(signatura, "Material Auditivo", restringido, tema, formato, duracionSegundos, idioma);
    }

    //MÉTODO TO STRING
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("-MATERIAL AUDITIVO-").append("\n");
        builder.append(super.toString()).append("\n");
        return builder.toString();
    }

    @Override
    public String toCSV(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toCSV()).append(",");
        builder.append("TipoMaterial").append(":").append("Audio");
        return builder.toString();
    }
}
