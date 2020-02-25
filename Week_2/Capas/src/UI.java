import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class UI {

    /**
     * Program Functionality, Objectives
     * 1. Log students with a specific amount.
     * 2. Check if the student exist in the student queue.
     * 3. If the student doesn't exist the program add it to the queue.
     * 4. Request a student name to enter its score.
     * 5. Prints all data: The students name and their score.
     *
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
        final int EXIT = 6;
        final int MENU = 5;
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
        menu_formatter += "# [2] Registrar estudiante                   #" + "\n";
        menu_formatter += "# [3] Registrar Nota del Estudiante          #" + "\n";
        menu_formatter += "# [4] Listar Notas                           #" + "\n";
        menu_formatter += "# [5] Imprimir Menu                          #" + "\n";
        menu_formatter += "# [6] Salir                                  #" + "\n";
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
                ui_initialize_program();
                break;
            case 2:
                ui_log_students();
                break;
            case 3:
                ui_calc_student_score();
                break;
            case 4:
                ui_list_all_data();
                break;
            default:
                out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Initialize the queue structures with the same size.
     *
     * @throws IOException
     */

    public static void ui_initialize_program() throws IOException {
        int queues_size = 0;
        boolean validation_flow = true;
        do {
            out.println("Cantidad de estudiantes a registrar");
            out.print(">>> ");
            queues_size = Integer.parseInt(in.readLine());
            if (queues_size > 0) {
                //Logic Layer request
                LogicLayer.initialize_program(queues_size);
                validation_flow = false; //Exit the loop
            } else {
                out.println("La cantidad de estudiantes debe ser mayor a cero.");
            }
        } while (validation_flow);
    }

    /**
     * Register a student in the student queue.
     *
     * @throws IOException
     */
    public static void ui_log_students() throws IOException {
        /*
        This for loop is necessary to add the specific amount of the students indicated. So, it runs
        x times related with the students quantity.
        Eg:
        1. John
        2. Steve
         */
        boolean student_existence_validation;
        for (int index = 0; index < LogicLayer.global_queues_size; index++) {
            //This do-while loop has the functionality to check if the user already exist.
            do {
                String student_name = "";
                out.println("Escriba el nombre del estudiante");
                out.print(">>> ");
                student_name = in.readLine();
                //This function validates if the student exist.
                student_existence_validation = LogicLayer.student_existence(student_name);
                if (!student_existence_validation) {
                    out.println("El nombre " + student_name + " ya se encuentra en la cola.");
                    out.println("Vuelva a escribir la información.");
                    student_existence_validation = true;
                } else {
                    student_existence_validation = false;
                    //So, if it is true, assign the value to queue in the logic layer.
                    LogicLayer.log_students(student_name);
                    out.println("[Estudiante agregado]");
                }
            } while (student_existence_validation);
        }
    }

    /**
     * Log a score per student name.
     *
     * @throws IOException
     */
    public static void ui_calc_student_score() throws IOException {
        // 5 rows and 3 columns
        int[][] matrix = new int[5][3];
        String student_name;
        int student_index;

        boolean validation_flow = true;
        do {
            out.println("Ingrese el nombre del estudiante");
            out.print(">>> ");
            student_name = in.readLine();
            student_index = LogicLayer.search_student_index(student_name);
            if (student_index != -1) {
                validation_flow = false;
                //Injects the student index in the first column of matrix.
                matrix = LogicLayer.inject_student_index(matrix, student_index);
                int total_points = ui_inject_question_points(matrix);
                if (total_points != -1) {
                    //Inject student points in matrix
                    int student_points = ui_calc_student_points(total_points, matrix);
                    if (student_points != -1) {
                        LogicLayer.log_points(student_points, student_index);
                    } else {
                        out.println("Los puntos del estudiante no son válidos.");
                    }
                } else {
                    out.println("Los puntos del examen no son válidos.");
                }
            }
        } while (validation_flow);
    }

    /**
     * Ask for the amount of points per question and then makes an addition.
     *
     * @param matrix
     * @return Integer
     * @throws IOException
     */
    public static int ui_inject_question_points(int[][] matrix) throws IOException {
        boolean validation_break = true;
        int question_points;
        do {
            int validation = 0;
            out.println("Ingrese los puntos de las 5 preguntas.");
            for (int index = 0; index < matrix.length; index++) {
                out.println("Pregunta " + (index + 1));
                out.print("[" + (index + 1) + "]>>>");
                question_points = Integer.parseInt(in.readLine());
                matrix = LogicLayer.inject_question_points(matrix, question_points);
                validation = validation + question_points;
            }
            if (validation <= 100) {
                out.println("Se ha registrado una totalidad de " + validation + " puntos.");
                validation_break = false;
                return validation;
            } else {
                out.println("Los puntos deben sumar una cantidad menor o igual a 100.");
            }
        } while (validation_break);
        return -1;
    }

    /**
     * Calculates the obtained points per student and checks if the amount is valid.
     *
     * @param total_points
     * @param matrix
     * @return Integer
     * @throws IOException
     */
    public static int ui_calc_student_points(int total_points, int[][] matrix) throws IOException {
        boolean validation_break = true;
        int student_points = 0;
        do {
            int question_points = 0;
            int subtraction_points = total_points;
            out.println("Ingrese los puntos ganados en las 5 preguntas");
            for (int index = 0; index < matrix.length; index++) {
                out.println("Puntos disponibles: " + subtraction_points + "p.");
                out.println("Pregunta " + (index + 1));
                out.print("[" + (index + 1) + "]>>>");
                question_points = Integer.parseInt(in.readLine());
                matrix = LogicLayer.inject_student_points(matrix, question_points);
                subtraction_points = subtraction_points - question_points;
                student_points = student_points + question_points;
            }
            if (subtraction_points < 0) {
                validation_break = true;
                out.println("Los puntos aplicados no son válidos");
                out.println("Puntos disponibles a aplicar: " + total_points);
                out.println("Inténtelo nuevamente");
            } else {
                validation_break = false;
            }
        } while (validation_break);

        out.println("El registro del estudiante quedó en la siguiente estructura");
        print_matrix(matrix);

        return student_points;
    }


    /**
     * Prints a bi-dimensional array
     */
    public static void print_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                out.print("[" + matrix[i][j] + "]");
            }
            out.println();
        }
    }


    /**
     * List the student name and the score.
     */
    public static void ui_list_all_data() {
        int[] student_scores = LogicLayer.get_scores_queue();
        String[] student_names = LogicLayer.get_student_queue();
        for (int index = 0; index < LogicLayer.global_queues_size; index++) {
            out.println("El estudiante " + student_names[index] + " obtuvo " + student_scores[index] + " en su " +
                    "nota.");
        }
    }

}
