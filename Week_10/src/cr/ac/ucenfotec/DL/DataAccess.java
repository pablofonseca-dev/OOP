package cr.ac.ucenfotec.DL;

import cr.ac.ucenfotec.BL.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase es la responsable de almacenar la información en archivos de texto.
 * Va a tener todos métodos para manipular los archivos de texto.
 */
public class DataAccess {
    private ArrayList<Persona> personas;

    private final String ARCHIVO = "Personas.txt" ;

    private BufferedWriter bufferWriter = null;
    private BufferedReader bufferedReader = null;
    FileReader reader;
    private FileWriter writer = null;


    public DataAccess(){
            personas = new ArrayList<>();
            try {
                reader = new FileReader(ARCHIVO);
                writer = new FileWriter(ARCHIVO, true);
                bufferWriter = new BufferedWriter(writer);
                bufferedReader = new BufferedReader(reader);
            }catch(IOException e){
                e.printStackTrace();
            }
    }

    /**
     * Se encarga de guardar personas en un archivo de texto "Personas.txt" y también
     * en un ArrayList para persistir la información en memoria.
     * @param objPersona Objeto de tipo persona que se va a registrar.
     * @return true si la persona se pudo registrar y si no hay una excepción.
     * @author Pablo Fonseca.
     *
     */
    public boolean guardarPersona(Persona objPersona){

        try {
            bufferWriter.write(objPersona.toStringCSV());
            bufferWriter.newLine();
            bufferWriter.close();
            this.personas.add(objPersona);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Método que se va a utilizar para listar la información persistente del arreglo.
     * @return un ArrayList con el contenido del método .toString() de la clase persona,
     * este ArrayList solo almacena toda la información temporal.
     */
    public ArrayList<String> obtenerLineasPersona(){
        //El buffer extrae cada línea y lo primero que hace es verificar si
        //el resultado es nulo. Si es nulo, entonces llegó al final de los datos.
        ArrayList<String> datos = new ArrayList<>();
        try{
            String dato;
            String[] temporal_info;
            Persona objPersona;
            while((dato = bufferedReader.readLine()) != null){
                temporal_info = dato.split(",");
                objPersona = new Persona(temporal_info[0], temporal_info[1], temporal_info[2],
                        temporal_info[3].charAt(0));
                //Se transforma en un objeto Persona
                datos.add(objPersona.toString());
            }
            return datos;
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return datos;
    }
}
