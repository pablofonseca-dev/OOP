//Import modules
import org.jetbrains.annotations.NotNull;

import java.io.*;

/**
 * Program Functionality, Objectives
 * 1. Log students with a specific amount.
 * 2. Check if the student exist in the student queue.
 * 3. If the student doesn't exist the program add it to the queue.
 * 4. Request a student name to enter its score.
 * 5. Prints all data: The students name and their score.
 * @author Pablo Fonseca.
 * @version 1.0
 */
public class Main {

    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static String[] student_names;
    public static double[] student_scores;

    public static int queues_size = 0;

    /**
     * Program Main Stage
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        program_start();
    }

    /**
     * Starts the program.
     * @throws IOException
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
     * @throws IOException
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
     * @throws IOException
     */

    public static void initialize_program() throws IOException{

        boolean validation_flow = true;
        do{
            out.println("Cantidad de estudiantes a registrar");
            out.print(">>> ");
            queues_size = Integer.parseInt(in.readLine());
            if(queues_size > 0){
                student_names = new String[queues_size];
                student_scores = new double[queues_size];
                validation_flow = false; //Exit the loop
            }else{
                out.println("La cantidad de estudiantes debe ser mayor a cero.");
            }
        }while(validation_flow);
    }

    /**
     * Register a student in the student queue.
     * @throws IOException
     *
     */
    public static void log_students() throws IOException{
        /*
        This for loop is necessary to add the specific amount of the students indicated. So, it runs
        x times related with the students quantity.
        Eg:
        1. John
        2. Steve
         */
        boolean user_existence_validation;
        for(int index = 0; index < queues_size; index++) {
            //This do-while loop has the functionality to check if the user already exist.
            do {
                String user_name = "";
                out.println("Escriba el nombre del estudiante");
                out.print(">>> ");
                user_name = in.readLine();
                //This function validates if the student exist.
                user_existence_validation = student_existence(user_name);
                if (!user_existence_validation) {
                    out.println("El nombre " + user_name + " ya se encuentra en la cola.");
                    out.println("Vuelva a escribir la información.");
                    user_existence_validation = true;
                } else {
                    user_existence_validation = false;
                    //So, if it is true, assign the value to queue.
                    student_names[index] = user_name;
                    out.println("[Estudiante agregado]");
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
     * Search the student index
     * @param student_name
     */
    public static int search_student_index(String student_name){
        int student_index;
        for(int index = 0; index < queues_size; index++){
            if(student_name.equals(student_names[index])){
                student_index = index;
                return student_index;
            }
        }
        return -1;
    }

    /**
     * Log a score per student name.
     * @throws IOException
     */
    public static void calc_student_score() throws IOException{
        int matrix[][] = new int[5][3];
        String student_name;
        int student_index;

        boolean validation_flow = true;

        do{
            out.println("Ingrese el nombre del estudiante");
            out.print(">>> ");
            student_name = in.readLine();
            student_index = search_student_index(student_name);
            if(student_index != -1){
                validation_flow = false;
                //Inject student index in matrix.
                inject_student_index(matrix, student_index);
                //Inject question points in matrix.
                int total_points = inject_question_points(matrix);
                if(total_points != -1){
                    //Inject student points in matrix
                    int student_points = calc_student_points(total_points, matrix);
                    if(student_points != -1){
                        inject_student_points(student_points, student_index);
                    }else{
                        out.println("Los puntos del estudiante no son válidos.");
                    }
                }else{
                    out.println("Los puntos del examen no son válidos.");
                }
            }else{
                out.println("Estudiante no encontrado, inténtelo nuevamente.");
            }
        }while(validation_flow);
    }

    public static void inject_student_index(int[][] matrix, int student_index){
        for(int index = 0; index < matrix.length;  index++){
            matrix[index][0] = student_index;
        }
    }

    /**
     * Ask for the amount of points per question and then makes an addition.
     * @param matrix
     * @return Integer
     * @throws IOException
     */
    public static int inject_question_points(int[][] matrix) throws IOException{
        boolean validation_break = true;
        int question_points;
        do {
            int validation = 0;
            out.println("Ingrese los puntos de las 5 preguntas.");
            for (int index = 0; index < matrix.length; index++) {
                out.println("Pregunta " + (index + 1));
                out.print("[" + (index + 1) + "]>>>");
                question_points = Integer.parseInt(in.readLine());
                validation = validation + question_points;
            }
            if(validation <= 100){
                out.println("Se ha registrado una totalidad de " + validation + " puntos.");
                validation_break = false;
                return validation;
            }else{
                out.println("Los puntos deben sumar una cantidad menor o igual a 100.");
            }
        }while(validation_break);
        return -1;
    }

    /**
     * Calculates the obtained points per student and checks if the amount is valid.
     * @param total_points
     * @param matrix
     * @return Integer
     * @throws IOException
     */
    public static int calc_student_points(int total_points, int[][] matrix) throws IOException{
        boolean validation_break = true;
        do {
            int question_points = 0;
            int student_points = 0;
            int subtraction_points = total_points;
            out.println("Ingrese los puntos ganados en las 5 preguntas");
            for (int index = 0; index < matrix.length; index++) {
                out.println("Puntos disponibles: " + subtraction_points + "p.");
                out.println("Pregunta " + (index + 1));
                out.print("[" + (index + 1) + "]>>>");
                question_points = Integer.parseInt(in.readLine());
                subtraction_points = subtraction_points - question_points;
                student_points = student_points + question_points;
                validation_break = false;
            }
            if (subtraction_points < 0 || subtraction_points > question_points) {
                out.println("Los puntos aplicados no son válidos");
                out.println("Puntos disponibles a aplicar: " + total_points);
                out.println("Inténtelo nuevamente");
            }else{
                return student_points;
            }
        }while(validation_break);
        return -1;
    }

    /**
     * Inject the total student points to the student scores queue.
     * @param student_points
     * @param student_index
     */
    public static void inject_student_points(int student_points, int student_index){
        student_scores[student_index] = student_points;
    }


    /**
     * List the student name and the score.
     */
    public static void list_all_data(){
        for(int index = 0; index < queues_size; index++){
            out.println("El estudiante " + student_names[index] + " obtuvo " + student_scores[index] + " en su " +
                    "nota.");
        }
    }
}