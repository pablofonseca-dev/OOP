package cr.ac.ucenfotec.UI;

import cr.ac.ucenfotec.BL.Persona;
import cr.ac.ucenfotec.TL.Controller;

import java.io.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller controller = new Controller();
    public static void main(String[] args) throws IOException{
        // write your code here
        int opcion = -1;
        do{
            out.println("1. Imprimir todos los caracteres.");
            out.println("2. Imprimir todas las líneas.");
            out.println("3. Escribir y guardar líneas.");
            out.println("4. Actualizar el archivo");
            out.println("5. Registrar Persona");
            out.println("6. Imprimir Personas");
            out.println("7. Indicar Nombre del Archivo");
            out.println("0. Salir");
            opcion = Integer.parseInt(in.readLine());
            if(opcion != 0)
                procesarOpcion(opcion);
        }while(opcion != 0);

    }

    /**
     * Recibe el número de una opción dentro de la UI y con ella llama a un método.
     * @author Pablo Fonseca
     * @param argOpcion número de la opción que se va a proesar.
     * @throws IOException en caso de que haya una complicación de tipo IOException.
     */
    public static void procesarOpcion(int argOpcion) throws IOException{
        switch(argOpcion){
            case 1:
                imprimirCaracteres();
                break;
            case 2:
                imprimirLineas();
                break;
            case 3:
                guardar();
                break;
            case 4:
                actualizar();
                break;
            case 5:
                registrarPersona();
                break;
            case 6:
                imprimirPersonas();
                break;
            default:
                out.println("Opción Inválida");
        }
    }

    /**
     * Registra una persona
     * @author Pablo Fonseca
     * @throws IOException en caso de que haya una complicación de tipo IOException.
     */
    public static void registrarPersona() throws IOException{
        String nombre, apellido, identificacion;
        char genero;

        out.println("Nombre");
        nombre = in.readLine();

        out.println("Primer Apellido");
        apellido = in.readLine();

        out.println("Identificación");
        identificacion = in.readLine();

        out.println("Género (M/F)");
        genero = (in.readLine()).charAt(0);

        controller.guardarPersona(nombre, apellido, identificacion, genero);

    }

    /**
     * Imprime las personas registradas en el sistema.
     * @author Pablo Fonseca
     * @throws IOException excepción lanzada en caso de que haya un error leyendo los archivos.
     */
    public static void imprimirPersonas() throws IOException{
        String[] personas = controller.listarPersonas();
        for(String e: personas){
            System.out.println(e);
        }
    }
    /**
     * Método que se encarga de leer un archivo e imprimir los caracteres uno a uno.
     * La clase FileReader es una clase abstracta que se usa para leer texto almacenado en Streams.
     * @author Pablo Fonseca
     * @throws IOException excepción que se lanza en caso de que haya un fallo en la lectura.
     */
    public static void imprimirCaracteres() throws IOException{
        FileReader reader = new FileReader("Archivo.txt");
        try{
            int caracter;
            //El método read() de la clase FileReader retorna el número del caracter que se está leyendo en la tabla
            // ASCII, y luego este caracter se convierte en una letra.
            while((caracter = reader.read()) != -1){
                System.out.print((char) caracter);
;           }
            System.out.println("\n");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Imprime cada una de las líneas del archivo "Archivo.txt"
     * @throws IOException excepción que se lanza en caso de que haya un fallo en la lectura.
     */
    public static void imprimirLineas() throws IOException{
        FileReader reader = new FileReader("Archivo.txt");
        BufferedReader buffer = new BufferedReader(reader);
        //El buffer extrae cada línea y lo primero que hace es verificar si
        //el resultado es nulo. Si es nulo, entonces llegó al final de los datos.
        try{
            String datos;
                while((datos = buffer.readLine()) != null){
                    System.out.println(datos);
                }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public static void guardar(){
        try{
            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            //Nos permite ir escribiendo sobre un archivo
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(stream, "UTF-8");
            //Para escribir los datos
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            //Empezamos a escribir
            bufferedWriter.write("Esto es una prueba");
            bufferedWriter.newLine();
            bufferedWriter.write("Esta es una segunda línea de prueba");
            bufferedWriter.newLine();


        } catch (FileNotFoundException e) {
            System.err.println("El archivo no fue encontrado");
        } catch (UnsupportedEncodingException e) {
            System.err.println("La codificación no es soportada");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void actualizar(){
        try{
            FileWriter writer = new FileWriter("Archivo.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("El archivo se actualizó con esta línea.");
            bufferWriter.newLine();
            bufferWriter.close();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

}
