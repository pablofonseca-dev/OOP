package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.Persona;
import cr.ac.ucenfotec.DL.DataAccess;

import java.util.ArrayList;

public class Controller {
    DataAccess dataAccess;

    public Controller(){
        dataAccess = new DataAccess();
    }

    /**
     * Envía la información a la capa lógica donde se almacenan las personas.
     * @param nombre: nombre de la persona.
     * @param apellido: apellido de la persona.
     * @param identificacion: identificacion de la persona.
     * @param genero: género de la persona.
     */
    public void guardarPersona(String nombre, String apellido, String identificacion, char genero){
        Persona tempPersona = new Persona(nombre, apellido, identificacion, genero);
        this.dataAccess.guardarPersona(tempPersona);
    }

    /**
     * Envía la información de las personas registradas en la capa lógica.
     * @return las personas que se registran en la capa lógica.
     */
    public String[] listarPersonas(){
        ArrayList<String> arrayListData = this.dataAccess.obtenerLineasPersona();
        String[] datos = new String[arrayListData.size()];
        int i = 0;
        for(String e: arrayListData){
            datos[i] = e;
            i++;
        }
        return datos;
    }
}
