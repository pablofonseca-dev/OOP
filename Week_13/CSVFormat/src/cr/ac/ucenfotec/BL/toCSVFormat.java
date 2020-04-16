package cr.ac.ucenfotec.BL;

/**
 * Interface que tiene la responsabilidad de obligar a sus hijos a crear
 * las funcionalidades necesarias para que puedan trabajar correctamente con archivos CSV
 * (Comma-Separated-Values).
 */
public interface toCSVFormat {

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */

    public String toCSVString();

}
