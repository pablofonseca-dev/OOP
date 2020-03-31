package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.Persona;
import cr.ac.ucenfotec.DL.LogicLayer;

import java.time.LocalDate;

public class Controller {

    LogicLayer logic;

    public Controller(){
        this.logic = new LogicLayer();
    }

    public void registrarPersona(String nombre, String apellidos, LocalDate fechaNacimiento, char genero){
        Persona persona = new Persona(nombre, apellidos, fechaNacimiento, genero);
        logic.registrarPersonas(persona);
    }

    public String[] imprimirPersonas(){

        return logic.getPersonas();
    }

}
