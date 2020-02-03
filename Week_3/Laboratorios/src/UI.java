import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class UI {

    /**
     * @author Pablo Fonseca.
     * @version 2.0
     */

    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

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
        int user_selection;
        boolean program_flow;
        program_flow = true;
        final int EXIT = 7;
        final int MENU = 6;
        int counter = 0;
        String main_menu = get_main_menu();
        out.println(main_menu);

        do {
            if (counter == 3) {
                out.println(main_menu);
                counter = 0;
            }
            out.print(">>> ");
            try {
                user_selection = Integer.parseInt(in.readLine());
                if (user_selection == EXIT) {
                    program_flow = false;
                } else if (user_selection == MENU) {
                    out.println(main_menu);
                } else {
                    function_caller(user_selection);
                    counter++;
                }
            } catch (NumberFormatException error) {
                out.println("El dato debe ser un número");
                out.println(main_menu);
            }
        } while (program_flow);

    }

    /**
     * Prints the command line main menu.
     *
     * @return a string which contains the menu.
     */
    public static String get_main_menu() {
        String menu_formatter = "";
        menu_formatter += "##############################################" + "\n";
        menu_formatter += "# [1] Inicializar el programa                #" + "\n";
        menu_formatter += "# [2] Registrar Laboratorio                  #" + "\n";
        menu_formatter += "# [3] Listar Laboratorios                    #" + "\n";
        menu_formatter += "# [4] Registrar Estudiante                   #" + "\n";
        menu_formatter += "# [5] Listar Estudiantes                     #" + "\n";
        menu_formatter += "# [6] Imprimir Menu                          #" + "\n";
        menu_formatter += "# [7] Salir                                  #" + "\n";
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
    public static void function_caller(int user_selection) throws IOException {
        switch (user_selection) {
            case 1:
                uiInitializeLaboratorieQueue();
                break;
            case 2:
                uiAddLaboratory();
                break;
            case 3:
                uiPrintLaboratoriesQueue();
                break;
            case 4:
                uiPrintLaboratoriesQueueF();
                break;
            default:
                out.println("Opción Inválida");
                break;
        }
    }
    public static void uiInitializeLaboratorieQueue() throws IOException{
        boolean flow_validation = true;
        do {
            out.println("Ingrese la cantidad de laboratorios a registrar");
            int size = Integer.parseInt(in.readLine());
            if (size < 0) {
                out.println("Valor inválido");
                out.println("Vuelva a ingresar la cantidad");
                flow_validation = true;
            } else {
                LogicLayer.initializeLaboratoriesQueue(size);
                out.println("Listo!");
                flow_validation = false;
            }
        }while(flow_validation);
    }

    public static void uiAddLaboratory() throws IOException{
        int code;
        String name;
        int capacity;
        String course;
        boolean validation_flow = true;
        do{
            out.println("Ingrese los datos del laboratorio");
            out.println("Código");
            out.print(">>>");
            code = Integer.parseInt(in.readLine());
            out.println("Nombre");
            out.print(">>>");
            name = in.readLine();
            out.println("Capacidad");
            out.print(">>>");
            capacity = Integer.parseInt(in.readLine());

            out.println("Curso o Materia");
            out.print(">>>");
            course = in.readLine();
            validation_flow = false;
            String concatenatedData = concat(code, name, capacity, course);
            boolean result = LogicLayer.logLaboratory(concatenatedData);
            if(result){
                out.println("Listo!");
            }else{
                out.println("No se pudo completar la acción, laboratorios llenos");
            }
        }while(validation_flow);
    }

    //Backup Method
    public static void uiPrintLaboratoriesQueue(){
        String[] laboratoriesQueue = LogicLayer.getLaboratoriesQueue();
        for(int index = 0; index < laboratoriesQueue.length; index++){out.println(laboratoriesQueue[index]);}
    }

    //String Formatter Method
    public static void uiPrintLaboratoriesQueueF(){
        out.println(LogicLayer.getStringLab());
    }

    //Concatenate information
    public static String concat(Object...args){
        String concatenatedData = "";
        for(int index = 0; index < args.length; index++)
        {
            concatenatedData += args[index];
            if(index == args.length - 1){
                concatenatedData += ",";
            }
        }
        return concatenatedData;
    }

    //Concatenates data

}
