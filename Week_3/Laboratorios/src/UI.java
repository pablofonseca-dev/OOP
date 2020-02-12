import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UI {

    /**
     * @author Pablo Fonseca.
     * @version 3.0
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
        int userSelection;
        boolean programFlow;
        programFlow = true;
        final int EXIT = -1;
        final int MENU = 7;
        final int START = 1;
        boolean queuesInitialized = false;
        String startMenu = getStartMenu();
        out.println(startMenu);
        do {
            if (!queuesInitialized) {
                out.print("[A]>>>");
                try {
                    userSelection = Integer.parseInt(in.readLine());
                    if (userSelection == EXIT) {
                        programFlow = false;
                    } else if (userSelection == START) {
                        uiInitializeQueues();
                        queuesInitialized = true;
                    }
                } catch (NumberFormatException exception) {
                    out.println("[La acción debe ser un número]");
                }
            } else {
                out.println(getMainMenu());
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
            }

        } while (programFlow);

    }

    public static String getStartMenu() {
        String menu_formatter = "";
        menu_formatter += "##############################################" + "\n";
        menu_formatter += "# [1] Inicializar el programa                #" + "\n";
        menu_formatter += "# [-1] Salir                                 #" + "\n";
        menu_formatter += "##############################################" + "\n";
        return menu_formatter;
    }

    /**
     * Prints the command line main menu.
     *
     * @return a string which contains the menu.
     */
    public static String getMainMenu() {
        String menu_formatter = "";
        menu_formatter += "##############################################" + "\n";
        menu_formatter += "# [1] Registrar Laboratorio                  #" + "\n";
        menu_formatter += "# [2] Listar Laboratorios Registrados        #" + "\n";
        menu_formatter += "# [3] Registrar Estudiante                   #" + "\n";
        menu_formatter += "# [4] Listar Estudiantes Registrados         #" + "\n";
        menu_formatter += "# [5] Registrar Curso                        #" + "\n";
        menu_formatter += "# [6] Listar Cursos Registrados              #" + "\n";
        menu_formatter += "# [7] Imprimir Menu                          #" + "\n";
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
                uiAddLaboratory();
                break;
            case 2:
                uiPrintLaboratoriesQueue();
                break;
            case 3:
                uiAddStudent();
                break;
            case 4:
                uiPrintStudentsQueue();
                break;
            case 5:
                uiAddCourse();
                break;
            case 6:
                uiPrintCourseQueue();
                break;
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }

    public static void uiInitializeQueues() throws IOException {
        boolean flow_validation = true;
        do {
            out.println("Ingrese la cantidad de laboratorios a registrar");
            out.print(">>> ");
            int labsSize = Integer.parseInt(in.readLine());
            out.println("Ingrese la cantidad de estudiantes a registrar");
            out.print(">>> ");
            int studentsSize = Integer.parseInt(in.readLine());
            out.println("Ingrese la cantidad de cursos a registrar");
            out.print(">>> ");
            int coursesSize = Integer.parseInt(in.readLine());
            if (labsSize < 0 || studentsSize < 0 || coursesSize < 0) {
                out.println("[El valor no puede ser negativo]");
                out.println("[Vuelva a Ingresar las Cantidades]");
                flow_validation = true;
            } else {
                LogicLayer.initializeLaboratoriesQueue(labsSize);
                LogicLayer.initializeStudentsQueue(studentsSize);
                LogicLayer.initializeCoursesQueue(coursesSize);
                out.println("[Petición Aceptada]");
                out.println("[Espacios Agregados en Memoria]");
                flow_validation = false;
            }
        } while (flow_validation);
    }

    public static void uiAddLaboratory() throws IOException {
        String code;
        String name;
        int capacity;
        String course;

        out.println("Ingrese los datos del laboratorio");

        out.println("Nombre");
        out.print(">>> ");
        name = in.readLine();
        if (!(isNotAnEmptyString(name))) {
            out.println("[Petición Denegada]");
            out.println("[El nombre no puede estar vacío]");
            return;
        }
        if (!(moreThanThreeChars(name))) {
            out.println("[Petición Denegada]");
            out.println("[El nombre debe tener al menos tres dígitos]");
            return;
        }

        out.println("Capacidad");
        out.println("Min: " + 10 + " " + "Max: " + 90);
        out.print(">>> ");
        capacity = Integer.parseInt(in.readLine());
        if (!(validateCapacity(capacity))) {
            out.println("[Petición Denegada]");
            out.println("[La capacidad del laboratorio no cumple con su rango de capacidad]");
        }

        out.println("Curso o Materia");
        out.print(">>> ");
        course = in.readLine();
        if (!(isNotAnEmptyString(course))) {
            out.println("[Petición Denegada]");
            out.println("[El curso no puede estar vacío]");
            return;
        }
        if (!(moreThanThreeChars(course))) {
            out.println("[Petición Denegada]");
            out.println("[El curso debe tener al menos tres dígitos]");
        }
        if (!(isAlpha(course))) {
            out.println("[Petición Denegada]");
            out.println("[El curso no puede contener dígitos numéricos]");
        }
        boolean result = LogicLayer.logLaboratory(name, capacity, course);
        if (result) {
            out.println("[Petición Aceptada]");
            out.println("[Laboratorio Agregado en Memoria]");
        } else {
            out.println("[Petición Denegada]");
            out.println("[El espacio en memoria de los laboratorios está lleno]");
        }
    }

    public static void uiAddStudent() throws IOException {
        String name, lastName, code;
        boolean result, isScholarship, isACompleteLog;
        result = false;
        out.println("Ingrese los datos del estudiante");

        out.println("Identificación Numérica");
        out.print(">>> ");
        code = in.readLine();
        if(!isNotAnEmptyString(code)){
            out.println("[La identificación no puede estar vacía]");
        }
        if(!moreThanThreeChars(code)){
            out.println("[La identificación debe contener al menos tres dígitos");
        }
        if(!isDigit(code)){
            out.println("[La identificación no puede contener letras]");
            return;
        }
        out.println("Nombre");
        out.print(">>> ");
        name = in.readLine();
        if(!isNotAnEmptyString(name)){
            print("El nombre no puede estar vacío");
            return;
        }
        if(!isAlpha(name)){
            print("El nombre no puede contener valores numéricos");
            return;
        }
        if(!moreThanThreeChars(name)){
            print("El nombre debe contener al menos tres caracteres");
            return;
        }
        out.println("Apellido");
        out.print(">>> ");
        lastName = in.readLine();
        if(!isNotAnEmptyString(lastName)){
            print("El apellido no puede estar vacío");
            return;
        }
        if(!isAlpha(lastName)){
            print("El apellido no puede contener valores numéricos");
            return;
        }
        if(!moreThanThreeChars(lastName)){
            print("El apellido debe contener al menos tres caracteres");
            return;
        }

        out.println("¿El estudiante es becado? (S/N)");
        out.print(">>> ");
        isScholarship = convertToBooleanExpression(in.readLine());

        out.println("¿Desea Agregar la Fecha de Nacimiento? (S/N)");
        out.print(">>> ");
        isACompleteLog = convertToBooleanExpression(in.readLine());

        if (isACompleteLog) {
            boolean validationFlow = true;
            do {
                int year, day, month;
                out.println("Año de Nacimiento");
                out.print(">>> ");
                year = Integer.parseInt(in.readLine());

                out.println("Mes de Nacimiento");
                out.print(">>> ");
                month = Integer.parseInt(in.readLine());

                out.println("Día de Nacimiento");
                out.print(">>> ");
                day = Integer.parseInt(in.readLine());

                LocalDate birthday = convertToLocalDate(year, month, day);

                if (birthday != null) {
                    out.println("[Fecha Convertida]");
                    result = LogicLayer.logStudentComplete(name, lastName, code, isScholarship, birthday);
                    validationFlow = false;
                } else {
                    out.println("[Formato Incorrecto]");
                    out.println("[Vuelva a ingresar la fecha]");
                }
            } while (validationFlow);
        } else {
            result = LogicLayer.logStudent(name, lastName, code, isScholarship);
            out.println("[Fecha Ignorada]");
        }
        if (result) {
            out.println("[Petición Aceptada]");
            out.println("[Estudiante Agregado en Memoria]");
        } else {
            out.println("[Petición Denegada]");
            out.println("[El espacio en memoria de los estudiantes está lleno]");
        }
    }

    public static void uiAddCourse() throws IOException {
        int credits;
        String name, code;
        boolean validationFlow = true;
        do {
            out.println("Ingrese los datos del curso");

            out.println("Código");
            out.print(">>> ");
            code = in.readLine();

            out.println("Nombre");
            out.print(">>> ");
            name = in.readLine();

            out.println("Créditos");
            out.print(">>> ");
            credits = Integer.parseInt(in.readLine());

            boolean result = LogicLayer.logCourse(code, name, credits);
            if (result) {
                out.println("Curso agregado");
                validationFlow = false;
            } else {
                out.println("No se pudo completar la acción");
                validationFlow = true;
            }
        } while (validationFlow);
    }

    //Validation Methods
    public static boolean isNotAnEmptyString(String stringInput) {
        return !stringInput.equalsIgnoreCase("");
    }

    public static boolean moreThanThreeChars(String stringInput) {
        return stringInput.length() >= 3;
    }

    public static boolean isDigit(String stringInput) {
        int strSize = stringInput.length();
        String[] strArray = new String[strSize];

        for (int index = 0; index < strSize; index++) {
            strArray[index] = String.valueOf(stringInput.charAt(index));
        }

        boolean validation = true;
        for (String e : strArray) {
            try {
                int number = Integer.parseInt(e);
            } catch (NumberFormatException exception) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(String stringInput) {
        int strSize = stringInput.length();
        String[] strArray = new String[strSize];

        for (int index = 0; index < strSize; index++) {
            strArray[index] = String.valueOf(stringInput.charAt(index));
        }

        boolean validation = true;

        for (String e : strArray) {
            try {
                int alpha = Integer.parseInt(e);
                return false;
            } catch (NumberFormatException ignored) {
            }
        }
        return true;
    }

    public static LocalDate convertToLocalDate(int year, int month, int day) {
        // format arguments
        String dateString = year + " " + month + " " + day;
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M d");
        // create a LocalDate object
        try {
            LocalDate localDate = LocalDate.parse(dateString, formatter);
            return localDate;
        } catch (DateTimeParseException exception) {
            return null;
        }

    }

    public static boolean convertToBooleanExpression(String stringInput) {
        if (stringInput.equalsIgnoreCase("S")) {
            return true;
        } else if (stringInput.equalsIgnoreCase("N")) {
            return false;
        }
        out.println("Valor inválido, se ha indicado N por defecto.");
        return false;
    }

    public static boolean validateCreditsAmount(int creditsInput) {
        return creditsInput >= 5 && creditsInput <= 15;
    }

    public static boolean validateCapacity(int capacity) {
        return capacity >= 10 && capacity <= 90;
    }

    //Backup Method
    public static void uiPrintLaboratoriesQueue() {
        String[] laboratoriesQueue = LogicLayer.getLaboratoriesQueueBackup();
        int laboratoriesLogged = LogicLayer.getLaboratoriesCounter();
        for (int index = 0; index < laboratoriesLogged; index++) {
            out.println(laboratoriesQueue[index]);
        }
    }

    public static void uiPrintStudentsQueue() {
        String[] studentsQueue = LogicLayer.getStudentsQueueBackup();
        int studentsLogged = LogicLayer.getStudentsCounter();
        for (int index = 0; index < studentsLogged; index++) {
            out.println(studentsQueue[index]);
        }
    }

    public static void uiPrintCourseQueue() {
        String[] coursesQueue = LogicLayer.getCoursesQueueBackup();
        int coursersLogged = LogicLayer.getCoursesCounter();
        for (int index = 0; index < coursersLogged; index++) {
            out.println(coursesQueue[index]);
        }
    }

    public static void print(String input){
        out.println("[" + input + "]");
    }

}
