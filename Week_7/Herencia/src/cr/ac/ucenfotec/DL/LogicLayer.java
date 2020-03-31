package cr.ac.ucenfotec.DL;

import cr.ac.ucenfotec.BL.Persona;

import java.util.ArrayList;

public class LogicLayer {

    private ArrayList<Persona> personas;


    public LogicLayer(){
        personas = new ArrayList<Persona>();
    }


    public void registrarPersonas(Persona tempPersona){
        this.personas.add(tempPersona);
    }

    public String[] getPersonas(){
        String[] information = new String[personas.size()];
        int i = 0;
        for(Persona tempPersona: personas){
            information[i] = tempPersona.toString();
            i++;
        }
        return information;
    }

}
