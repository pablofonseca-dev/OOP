package cr.ac.ucenfotec;

import cr.ac.ucenfotec.BL.Persona;
import cr.ac.ucenfotec.BL.PersonaFisica;
import cr.ac.ucenfotec.BL.PersonaJuridica;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PersonaFisica pf = new PersonaFisica("Pablo", "Fonseca Moncada", LocalDate.now(), 'M');
        Persona p = new Persona("Pablo", "Fonseca Moncada", LocalDate.now(), 'M');
        PersonaJuridica pj = new PersonaJuridica();
        example(pf);
    }

    public static void example(Persona temporalPerson){
        generateOutputLines(temporalPerson);
        System.out.println(temporalPerson.toString());
        System.out.println("Output person name: " + temporalPerson.getNombre());
        generateOutputLines(temporalPerson);
    }
    public static void logPerson(Persona temporalPerson){

    }

    public static void generateOutputLines(Object o){
        for(int i = 0; i < o.toString().length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }
}
