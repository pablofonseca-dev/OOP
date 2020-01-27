//Import modules
import java.io.*;

/**
 * Program Functionality, Objectives
 * 1. Log students with a specific amount.
 * 2. Check if the student exist in the student queue.
 * 3. If the student doesn't exist the program add it to the queue.
 * 4. Request a student name to enter its score.
 * 5. Prints all data: The student name and the score.
 * @author Pablo Fonseca Moncada.
 */
public class Main {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static String[] student_names;
    public static double[] student_scores;

    public static int queues_size = 0;
    public static void main(String[] args) throws IOException{
        program_start();
    }

    /**
     * Starts the program.
     */
    public static void program_start() throws IOException{
        int user_selection;
        boolean program_flow;
        program_flow = true;
        final int EXIT = 6;
        final int MENU = 5;
        String main_menu = get_main_menu();
        out.println(main_menu);
        do{
            out.print(">>> ");
            user_selection = Integer.parseInt(in.readLine());
            if(user_selection == EXIT){
                program_flow = false;
            }else if(user_selection == MENU){
                out.println(main_menu);
            }else{
                function_caller(user_selection);
            }
        }while(program_flow);

    }

    /**
     * Prints the command line main menu.
     * @return a string which contains the menu.
     */
    public static String get_main_menu(){
        String menu_formatter = "";
        menu_formatter += "######################################" + "\n";
        menu_formatter += "# [1] Inicializar el programa        #" + "\n";
        menu_formatter += "# [2] Registrar estudiante           #" + "\n";
        menu_formatter += "# [3] Registrar Nota del Estudiante  #" + "\n";
        menu_formatter += "# [4] Listar Notas                   #" + "\n";
        menu_formatter += "# [5] Imprimir Menu                  #" + "\n";
        menu_formatter += "# [6] Salir                          #" + "\n";
        menu_formatter += "######################################" + "\n";
        return menu_formatter;
    }

    /**
     * Call different routines and specific processes depending
     * on the value sent by the user
     * @param user_selection: Gets the user selection depending of the main method number.
     */
    public static void function_caller(int user_selection) throws IOException{
        switch(user_selection) {
            case 1:
                initialize_program();
                break;
            case 2:
                log_students();
                break;
            case 3:
                calc_student_score();
                break;
            case 4:
                list_all_data();
                break;
            default:
                out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Initialize the queue structures with the same size.
     */

    public static void initialize_program() throws IOException{

        boolean validation_flow = true;
        do{
            out.println("Cantidad de estudiantes a registrar: ");
            queues_size = Integer.parseInt(in.readLine());
            if(queues_size > 0){
                student_names = new String[queues_size];
                student_scores = new double[queues_size];
                validation_flow = false; //Exit the loop
            }
        }while(validation_flow);
    }

    /**
     * Register a student in the student queue.
     *
     */
    public static void log_students() throws IOException{
        //This do-while loop has the functionality to check if the user already exist.
        boolean user_existence_validation;
        user_existence_validation = true;
        for(int index = 0; index < queues_size; index++) {
            do {
                String user_name = "";
                out.println("Escriba el nombre del estudiante");
                out.print(">>> ");
                user_name = in.readLine();
                user_existence_validation = student_existence(user_name); //This function validates if the student exist.
                if (!user_existence_validation) { //If the user exist...
                    out.println("El estudiante " + user_name + " ya se encuentra en la cola.");
                    out.println("Vuelva a escribir la informacion.");
                    user_existence_validation = true;
                } else {
                    //If it is true, it passed the validation test
                    user_existence_validation = false; //Breaks the loop.
                    //So, if it is true, assign the value to queue.
                    student_names[index] = user_name;
                    out.println("Estudiante agregado");
                }
            } while (user_existence_validation);
        }
    }

    /**
     * If the student doesn't exist the function returns true.
     * Else, the function returns false.
     * @return student_existence: Validates if a student exist in the queue.
     * @param student_name: Gets the user name to validate its existence in the queue.
     */
    public static boolean student_existence(String student_name){
        boolean existence_verification = true;
        for(int index = 0; index < queues_size; index++){
            if(student_name.equals(student_names[index])){
                existence_verification = false;
                break; //Exit to return false.
            }
        }
        return existence_verification;
    }

    /**
     * Log a score per a student name.
     */
    public static void calc_student_score() throws IOException{
        int matrix[][] = new int[5][3];
        String student_name;
        int student_index = 0;
        out.println("Ingrese el nombre del estudiante");
        out.print(">>> ");
        student_name = in.readLine();

        //Recorre el arreglo de estudiantes hasta que el nombre sea equivalente a una posicion
        for(int index = 0; index < queues_size; index++){
            if(student_names[index].equals(student_name)){
                //Fila v
                out.println("Ingrese la informacion del estudiante " + student_names[index]);
                student_index = index;
                for(int x = 0; x < matrix.length; x++){
                    //[0][0]
                    for(int y = 0; y < matrix[x].length; y++){
                        //0,0; 1,0; 2,0
                        if(y == 0){
                            matrix[x][y] = y; //0 index
                        }else{
                            if(y == 1){
                                int total_score;
                                out.println("Ingrese los puntos totales de la pregunta " + (x + 1));
                                total_score = Integer.parseInt(in.readLine());
                                matrix[x][y]= total_score;
                            }else{
                                if(y == 2){
                                    int gained_score;
                                    out.println("Ingrese el puntaje obtenido de " + student_names[index]);
                                    gained_score = Integer.parseInt(in.readLine());
                                    matrix[x][y] = gained_score;
                                }
                            }
                        }
                    }
                }
                break; //Exit to break
            }
        }
        log_student_scores(matrix, student_index);

    }

    public static void log_student_scores(int[][] matrix, int student_index){
        //Now just let follow the third column
        int addition = 0;
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                if(y == 2){
                    addition = addition + matrix[x][y];
                }
            }
        }
        student_scores[student_index] = addition;
        out.println("Nota agregada y calculada de " + student_names[student_index]);
    }

    /**
     * List the student name and the score.
     */
    public static void list_all_data(){
        for(int index = 0; index < queues_size; index++){
            out.println("El estudiante " + student_names[index] + " obtuvo un " + student_scores[index] + " en su " +
                    "nota.");
        }
    }
}