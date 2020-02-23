
package cr.ac.ucenfotec.UI;
import cr.ac.ucenfotec.TL.Controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    /**
     * @author Pablo Fonseca.
     * @version 4.0
     */

    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static Controller controller;

    /**
     * Program Main Stage
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        controller = new Controller();
        program_start();
    }

    /**
     * Starts the program.
     *
     * @throws IOException
     */
    public static void program_start() throws IOException {
        int userSelection;
        boolean programFlow;
        programFlow = true;
        final int EXIT = -1;
        final int MENU = 5;
        String mainMenu = getMainMenu();
        out.println(mainMenu);
        do {
            out.print("[A]>>>");
            try {
                userSelection = Integer.parseInt(in.readLine());
                if (userSelection == EXIT) {
                    programFlow = false;
                } else if (userSelection == MENU) {
                    out.println(getMainMenu());
                } else {
                    uiFunctionCaller(userSelection);
                }
            } catch (NumberFormatException exception) {
                out.println("[La acción debe ser un número]");
            }

        } while (programFlow);

    }

    /**
     * Prints the command line main menu.
     *
     * @return a string which contains the menu.
     */
    public static String getMainMenu() {
        String menu_formatter = "";
        menu_formatter += "##############################################" + "\n";
        menu_formatter += "# [1] Registrar Computadoras                 #" + "\n";
        menu_formatter += "# [2] Registrar Empleados                    #" + "\n";
        menu_formatter += "# [3] Listar Computadoras                    #" + "\n";
        menu_formatter += "# [4] Listar Empleados                       #" + "\n";
        menu_formatter += "# [5] Imprimir Menu                          #" + "\n";
        menu_formatter += "# [-1] Salir                                 #" + "\n";
        menu_formatter += "##############################################" + "\n";
        return menu_formatter;
    }

    /**
     * Call different routines and specific processes depending
     * on the value sent by the user.
     *
     * @param user_selection: Gets the user selection depending of the main method number.
     * @throws IOException
     */
    public static void uiFunctionCaller(int user_selection) throws IOException {
        switch (user_selection) {
            case 1:
                logComputerUI();
                break;
            case 2:
                logEmployeeUI();
                break;
            case 3:
                listComputers();
                break;
            case 4:
                listEmployees();
                break;
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }

    public static void logComputerUI() throws IOException{
        String brand;
        String serialCode;
        String question;
        out.println("Marca");
        out.print(">>> ");
        brand = in.readLine();
        out.println("Número de Serie");
        out.print(">>> ");
        serialCode = in.readLine();
        out.println("¿Desea registrar el empleado responsable? (S/N)");
        prompt();
        question = in.readLine();
        if(question.equalsIgnoreCase("S")){
            String name;
            String identification;
            out.println("Nombre");
            prompt();
            name = in.readLine();
            out.println("Identificación");
            prompt();
            identification = in.readLine();
            controller.logComputer(brand, serialCode, name, identification);
            controller.logEmployee(name, identification);
        }else {
            controller.logComputer(brand, serialCode);
        }
    }

    public static void logEmployeeUI() throws IOException{
        String name;
        String identification;
        out.println("Nombre");
        prompt();
        name = in.readLine();
        out.println("Identificación");
        prompt();
        identification = in.readLine();
        controller.logEmployee(name, identification);
    }

    public static void listComputers(){
        String[] computersList = controller.listComputer();
        for(int index = 0; index < computersList.length; index++){
            out.println(computersList[index]);
        }
    }

    public static void listEmployees(){
        String[] employeesList = controller.listEmployees();
        for(int index = 0; index < employeesList.length; index++){
            out.println(employeesList[index]);
        }
    }

    public static void prompt(){
        out.print(">>> ");
    }
}
