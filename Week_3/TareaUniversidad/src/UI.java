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
        final int MENU = 6;
        final int EXIT = 7;
        int counter = 0;
        String main_menu = get_main_menu();
        out.println(main_menu);

        do {
            if (counter == 1) {
                out.println(main_menu);
                counter = 0;
            }
            out.print("[Acción]>>>");
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
        menu_formatter += "# [2] Registrar Cursos                       #" + "\n";
        menu_formatter += "# [3] Listar Cursos                          #" + "\n";
        menu_formatter += "# [4] Registrar Carreras                     #" + "\n";
        menu_formatter += "# [5] Listar Carreras                        #" + "\n";
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
                uiInitializeQueues();
                break;
            case 2:
                uiAddCourse();
                break;
            case 3:
                uiPrintCourseQueue();
                break;
            case 4:
                uiAddCareer();
                break;
            case 5:
                uiPrintCareerQueue();
                break;
            default:
                out.println("Opción Inválida");
                break;
        }
    }

    public static void uiInitializeQueues() throws IOException {
        boolean validation_flow = true;
        do {
            out.println("Ingrese la cantidad de cursos que quiere registrar");
            out.print(">>> ");
            int courseQueueSize = Integer.parseInt(in.readLine());
            out.println("Ingrese la cantidad de carreras que quiere registrar");
            out.print(">>> ");
            int careerQueueSize = Integer.parseInt(in.readLine());
            if (courseQueueSize < 0 || careerQueueSize < 0) {
                out.println("Los valores deben ser mayores a 0.");
                out.println("Vuelva a intentarlo.");
            } else {
                //Call queues initialization methods
                LogicaCurso.initializeCoursesQueue(courseQueueSize);
                LogicaCarrera.initializeCareersQueue(careerQueueSize);
                out.println("[Espacios Agregados en Memoria]");
                validation_flow = false;
            }
        } while (validation_flow);
    }

    public static void uiAddCourse() throws IOException {
    /*
    Notes:
        1. Código Alfanumérico
        2. Cantidad de Créditos.
        3. Nombre del Curso.
    */
        String code;
        int credits;
        String name;


        out.println("[Escriba los siguientes datos del curso]\n");

        out.println("Código Alfanumérico | Mínimo 6 caracteres.");
        out.print(">>> ");
        code = in.readLine();
        if (code.equalsIgnoreCase("") || code.length() < 6) {
            out.println("El código del curso debe tener al menos 6 caracteres.");
            out.println("[Acción Denegada]");
            return;
        }
        out.println("Cantidad de Créditos | Rango entre 1 y 15");
        out.print(">>> ");
        credits = Integer.parseInt(in.readLine());
        if (credits < 1 || credits > 15) {
            out.println("El valor de los créditos deben tener un rango entre 0 y 15.");
            out.println("[Acción Denegada]");
            return;
        }
        out.println("Nombre del Curso | Mínimo 5 caracteres.");
        out.print(">>> ");
        name = in.readLine();
        if (name.equalsIgnoreCase("") || name.length() < 5) {
            out.println("El nombre del curso debe tener al menos 5 caracteres");
            out.println("[Acción Denegada]");
            return;
        }
        String concatenatedData = concat(code, credits, name);
        try {
            boolean tryToLog = LogicaCurso.logCourse(concatenatedData);
            if (tryToLog) {
                out.println("[Petición Procesada]");
            } else {
                out.println("Los espacios de los cursos están llenos");
                out.println("[Petición Denegada]");
            }
        } catch (ExceptionInInitializerError e) {
            out.println("No se pudo completar la acción, inicialice el programa primero.");
        }
    }

    public static void uiAddCareer() throws IOException {
        /*
            Notes:
            1. Código Alfanumérico.
            2. Acreditada o No?
            3. Nombre de la Carrera.
            4. Activa o No?
        */
        String code;
        boolean accredited;
        String name;
        boolean status;

        out.println("[Escriba los siguientes datos de la carrera]\n");

        out.println("Código Alfanumérico | Mínimo 6 caracteres.");
        out.print(">>> ");
        code = in.readLine();
        if (code.equalsIgnoreCase("") || code.length() < 6) {
            out.println("El código de la carrera debe tener al menos 6 caracteres.");
            out.println("[Acción Denegada]");
            return;
        }

        out.println("¿La carrera está acreditada? (S/N)");
        out.print(">>> ");
        String accreditedBoolean = in.readLine();
        if (accreditedBoolean.equalsIgnoreCase("S")) {
            accredited = true;
        } else if (accreditedBoolean.equalsIgnoreCase("N")) {
            accredited = false;
        } else {
            out.println("El valor debe ser S o N");
            out.println("[Acción Denegada]");
            return;
        }

        out.println("Nombre de la Carrera | Mínimo 5 caracteres.");
        out.print(">>> ");
        name = in.readLine();
        if (name.equalsIgnoreCase("") || name.length() < 5) {
            out.println("El nombre de la carrera debe tener al menos 5 caracteres");
            out.println("[Acción Denegada]");
            return;
        }

        out.println("¿La carrera está activa? (S/N)");
        out.print(">>> ");
        String statusBoolean = in.readLine();
        if (statusBoolean.equalsIgnoreCase("S")) {
            status = true;
        } else if (statusBoolean.equalsIgnoreCase("N")) {
            status = false;
        } else {
            out.println("El valor debe ser S o N");
            out.println("[Acción Denegada]");
            return;
        }

        String concatenatedData = concat(code, accredited, name, status);
        try {
            boolean tryToLog = LogicaCarrera.logCareer(concatenatedData);
            if (tryToLog) {
                out.println("[Petición Procesada]");
            } else {
                out.println("Los espacios de las carreras están llenos");
                out.println("[Petición Denegada]");
            }
        } catch (ExceptionInInitializerError e) {
            out.println("No se pudo completar la acción, inicialice el programa primero.");
        }
    }

    //Backup Print Methods

    public static void uiPrintCourseQueue(){
        String[] coursesQueue = LogicaCurso.getCourseQueueCopy();
        int coursesLogged = LogicaCurso.queueIndexCounter;
        for(int index = 0; index < coursesLogged; index++){out.println(coursesQueue[index]);}
    }

    public static void uiPrintCareerQueue(){
        String[] careersQueue = LogicaCarrera.getCareerQueueCopy();
        int careersLogged = LogicaCarrera.queueIndexCounter;
        for(int index = 0; index < careersLogged; index++){out.println(careersQueue[index]);}
    }

    //Concatenate Information Method
    public static String concat(Object... args) {
        String concatenatedData = "";
        for (int index = 0; index < args.length; index++) {
            concatenatedData += args[index];
            if (index < args.length - 1) {
                concatenatedData += ",";
            }
        }
        return concatenatedData;
    }
}
