package cr.ac.ucenfotec;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//import cr.ac.ucenfotec.TL.Controller;
public class UI {

    /**
     * @author Pablo Fonseca.
     * @version 1.0
     */

    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static Controller controller = new Controller();

    /**
     * Program Main Stage
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
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
        final int MENU = 4;
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
        menu_formatter += "# [1] Agregar Factura                        #" + "\n";
        menu_formatter += "# [2] Agregar Línea                          #" + "\n";
        menu_formatter += "# [3] Listar  Facturas                       #" + "\n";
        menu_formatter += "# [4] Imprimir Menu                          #" + "\n";
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
                //Option 1
                logBill();
                break;
            case 2:
                //Option 2
                logLine();
                break;
            case 3:
                //Option 3
                outputBills();
                break;
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }

    public static void logBill() throws IOException {

        String number, client;
        double tax;


        int day, month, year;

        bracketPrint("Ingrese los datos de la factura");
        out.println("Número");
        out.print(">>> ");
        number = in.readLine();
        out.println("Nombre del Cliente");
        out.print(">>> ");
        client = in.readLine();
        out.println("Impuesto");
        out.print(">>> ");
        tax = Integer.parseInt(in.readLine());

        bracketPrint("Ahora ingrese una fecha");
        out.println("Día");
        out.print(">>> ");
        day = Integer.parseInt(in.readLine());

        out.println("Mes");
        out.print(">>> ");
        month = Integer.parseInt(in.readLine());

        out.println("Año");
        out.print(">>> ");
        year = Integer.parseInt(in.readLine());
        controller.addBill(number, client, tax);
        controller.addBillDate(day, month, year);

        bracketPrint("Factura Agregada");

    }

    public static void logLine() throws IOException{
        int quantity;
        String code;
        int price;
        String description;

        bracketPrint("Ingrese los datos de la línea");

        out.println("Descripción del Producto");
        out.print(">>> ");
        description = in.readLine();

        out.println("Cantidad Comprada");
        out.print(">>> ");
        quantity = Integer.parseInt(in.readLine());

        out.println("Precio del Producto");
        out.print(">>> ");
        price = Integer.parseInt(in.readLine());

        out.println("Código del Producto");
        out.print(">>> ");
        code = in.readLine();

        controller.addLine(quantity, code, price, description);

        bracketPrint("Linea Agregada");
    }

    public static void outputBills(){
        String[] billsQueue = controller.outputBills();

        for(int index = 0; index < billsQueue.length; index++){
            out.println(billsQueue[index]);
        }

    }
    public static void bracketPrint(String string){
        out.println("[ " + string + " ]");
    }

    public static boolean validateNotEmptyField(String field){
        if(field.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean validateCharQuantity(int charsAmount, String text){
        if(text.length() < charsAmount){
            return false;
        }
        return true;
    }

    public static boolean validateNumberQuantity(int requiredAmount, int providedQuantity){
        if(providedQuantity < requiredAmount){
            return false;
        }else{
            return true;
        }
    }

    public static boolean validateNumberField(String textField){
        try{
            Integer.parseInt(textField);
            return true;
        }catch(NumberFormatException formatException){
            return false;
        }
    }

    public static boolean makeQuestion(String questionContent) throws IOException {
        String answer;
        boolean error = false;
        boolean answerResult = false;
        do {
            out.println("¿ " + questionContent + " ?");
            bracketPrint("Opciones Disponibles: S/N");
            answer = in.readLine();
            if (answer.equalsIgnoreCase("S")) {
                answerResult = true;
                error = false;
            } else if (answer.equalsIgnoreCase("N")) {
                answerResult = false;
                error = false;
            } else {
                printErrorNotification("La respuesta brindada no es válida");
                error = true;
            }
        }while(error);
        return answerResult;
    }

    public static void prompt(){
        out.print(">>> ");
    }

    public static void printErrorNotification(String errorMessage){
        out.println("<! ERROR: " + errorMessage + " ?>");
    }

    public static void tryAgainNotification(){
        out.println("Inténtelo Nuevamente");
    }
}