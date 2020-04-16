package cr.ac.ucenfotec.UI;

import cr.ac.ucenfotec.BL.Empleado;
import cr.ac.ucenfotec.BL.Jefatura;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

//import cr.ac.ucenfotec.TL.Controller;
public class UI{

    /**
     * @author Pablo Fonseca.
     * @version 1.0
     */

    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static PrintStream err = System.err;

    public static enum Selection {S, N};

    //public static Controller controller = new Controller();

    /**
     * Program Main Stage
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Empleado objEmpleado_1 = new Empleado();
        Empleado objEmpleado_2 = new Empleado();

        Jefatura objJefatura_1 = new Jefatura();

        objEmpleado_1.setNombreEmpleado("Jose Pablo");
        objEmpleado_1.setPrimerApellidoEmpleado("Fonseca");
        objEmpleado_1.setSegundoApellidoEmpleado("Vindas");
        objEmpleado_1.setIdentificacionEmpleado("118110147");
        objEmpleado_1.setSueldoEmpleado(2500.45);

        objEmpleado_2.setNombreEmpleado("John");
        objEmpleado_2.setPrimerApellidoEmpleado("Fonseca");
        objEmpleado_2.setSegundoApellidoEmpleado("Gehrels");
        objEmpleado_2.setIdentificacionEmpleado("112112138");
        objEmpleado_2.setSueldoEmpleado(2500.45);

        //out.println(objEmpleado.toString());

        objJefatura_1.setNombreEmpleado("Pablo");
        objJefatura_1.setPrimerApellidoEmpleado("Fonseca");
        objJefatura_1.setSegundoApellidoEmpleado("Moncada");
        objJefatura_1.setIdentificacionEmpleado("118110145");
        objJefatura_1.setMontoAdicional(500);
        objJefatura_1.setSueldoEmpleado(2500.45);

        //out.println(objJefatura.toString());

        Empleado[] collectionEmpleados = new Empleado[3];

        collectionEmpleados[0] = objEmpleado_1;
        collectionEmpleados[1] = objEmpleado_2;
        collectionEmpleados[2] = objJefatura_1;

        err.println(collectionEmpleados.getClass().getName());

        // Ordena los empleados de la colección
        Arrays.sort(collectionEmpleados);

        for(Empleado e: collectionEmpleados){
            out.println(e.toString());
        }

        Jefatura objJefatura_2 = (Jefatura) collectionEmpleados[2];

        err.println(objJefatura_2.toString());



    }
}