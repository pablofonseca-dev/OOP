package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public class PersonaFisica extends Persona{

    private String identificacion;

    public PersonaFisica(String nombre, String apellidos, LocalDate fechaNacimiento, char genero) {
        super(nombre, apellidos, fechaNacimiento, genero);
    }

    public PersonaFisica() {

    }

}
