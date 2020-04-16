package cr.ac.ucenfotec.UI;


import cr.ac.ucenfotec.TL.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
        final int MENU = 15;
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
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [0] REALIZAR UN PRÉSTAMO DE MATERIALES                 #" + "\n";
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [1] REGISTRAR ESTUDIANTE.                              #" + "\n";
        menu_formatter += "# [2] REGISTRAR PROFESOR.                                #" + "\n";
        menu_formatter += "# [3] REGISTRAR ADMINISTRATIVO.                          #" + "\n";
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [4] REGISTRAR MATERIAL DE VIDEO.                       #" + "\n";
        menu_formatter += "# [5] REGISTRAR MATERIAL DE AUDIO.                       #" + "\n";
        menu_formatter += "# [6] REGISTRAR MATERIAL DE TEXTO.                       #" + "\n";
        menu_formatter += "# [7] REGISTRAR UN MATERIAL INDEFINIDO (OTRO).           #" + "\n";
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [8] VISUALIZAR ESTUDIANTES Y PRESTAMOS.                #" + "\n";
        menu_formatter += "# [9] VISUALIZAR PROFESORES Y PRESTAMOS.                 #" + "\n";
        menu_formatter += "# [10] VISUALIZAR ADMINSITRATIVOS Y PRESTAMOS.           #" + "\n";
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [11] VISUALIZAR MATERIALES DE VIDEO.                   #" + "\n";
        menu_formatter += "# [12] VISUALIZAR MATERIALES DE AUDIO.                   #" + "\n";
        menu_formatter += "# [13] VISUALIZAR MATERIALES DE TEXTO.                   #" + "\n";
        menu_formatter += "# [14] VISUALIZAR MATERIALES INDEFINIDOS (OTROS).        #" + "\n";
        menu_formatter += "##########################################################" + "\n";
        menu_formatter += "# [15] IMPRIMIR ESTE MENÚ                                #" + "\n";
        menu_formatter += "# [-1] SALIR DEL SISTEMA                                 #" + "\n";
        menu_formatter += "##########################################################" + "\n";
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
            case 0:
                realizarPrestamoUsuario();
                break;
            case 1:
                registrarEstudiante();
                break;
            case 2:
                registrarProfesor();
                break;
            case 3:
                registrarAdministrativo();
                break;
            case 4:
                registrarMaterialVideo();
                break;
            case 5:
                registrarMaterialAudio();
                break;
            case 6:
                registrarMaterialTexto();
                break;
            case 7:
                registrarMaterialIndefinido();
                break;
            case 8:
                imprimirEstudiantes();
                break;
            case 9:
                imprimirProfesores();
                break;
            case 10:
                imprimirAdministrativos();;
                break;
            case 11:
                imprimirMaterialVideo();
                break;
            case 12:
                imprimirMaterialAudio();
                break;
            case 13:
                imprimirMaterialTexto();
                break;
            case 14:
                imprimirMaterialIndefinido();
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }


    public static void registrarEstudiante() throws IOException{
        String nombre, primerApellido, segundoApellido, carne, carrera;
        int creditos;

        bracketPrint("NOMBRE");
        nombre = in.readLine();

        bracketPrint("PRIMER APELLIDO");
        primerApellido = in.readLine();

        bracketPrint("SEGUNDO APELLIDO");
        segundoApellido = in.readLine();

        bracketPrint("CARNE");
        carne = in.readLine();

        bracketPrint("CARRERA");
        carrera = in.readLine();

        bracketPrint("CREDITOS");
        creditos = Integer.parseInt(in.readLine());

        if(!(controller.validarExistenciaIdentificacion(carne))) {
            controller.registrarEstudiante(nombre, primerApellido, segundoApellido, carne, carrera, creditos);
            System.out.println("ESTUDIANTE REGISTRADO");
        }else{
            out.println("YA EXISTE UN USUARIO CON LA IDENTIFICACIÓN " + carne);
            out.println("INTÉNTELO MÁS TARDE...");
        }
    }

    public static void registrarProfesor() throws IOException{
        String nombre, primerApellido, segundoApellido, cedula;
        String tipoContrato;
        LocalDate fechaContratacion;

        bracketPrint("NOMBRE");
        nombre = in.readLine();

        bracketPrint("PRIMER APELLIDO");
        primerApellido = in.readLine();

        bracketPrint("SEGUNDO APELLIDO");
        segundoApellido = in.readLine();

        bracketPrint("CEDULA");
        cedula = in.readLine();

        bracketPrint("TIPO DE CONTRATO");
        while(true){
            int seleccion;
            out.println("1. TIEMPO COMPLETO");
            out.println("2. MEDIO TIEMPO");
            seleccion = Integer.parseInt(in.readLine());
            if(seleccion == 1){
                tipoContrato = "TIEMPO COMPLETO";
                break;
            }else if(seleccion == 2){
                tipoContrato = "MEDIO TIEMPO";
                break;
            }else{
                out.println("DATO INVALIDO");
            }
        }

        int dia, mes, anno;
        bracketPrint("INGRESE LOS DATOS DE LA FECHA DE CONTRATACIÓN");
        bracketPrint("DIA");
        dia = Integer.parseInt(in.readLine());
        bracketPrint("MES");
        mes = Integer.parseInt(in.readLine());
        bracketPrint("AÑO");
        anno = Integer.parseInt(in.readLine());

        //Se convierte a una fecha
        fechaContratacion = convertToLocalDate(anno, mes, dia);

        if(!(controller.validarExistenciaIdentificacion(cedula))) {
            controller.registrarProfesor(nombre, primerApellido, segundoApellido, cedula, tipoContrato, fechaContratacion);
            System.out.println("PROFESOR REGISTRADO");
        }else{
            out.println("YA EXISTE UN USUARIO CON LA IDENTIFICACIÓN " + cedula);
            out.println("INTÉNTELO MÁS TARDE...");
        }
    }

    public static void registrarAdministrativo() throws IOException{
        String nombre, primerApellido, segundoApellido,  cedula;
        char tipoNombramiento = ' '; int horasSemanales;

        bracketPrint("NOMBRE");
        nombre = in.readLine();

        bracketPrint("PRIMER APELLIDO");
        primerApellido = in.readLine();

        bracketPrint("SEGUNDO APELLIDO");
        segundoApellido = in.readLine();

        bracketPrint("CEDULA");
        cedula = in.readLine();

        bracketPrint("TIPO DE NOMBRAMIENTO");

        while(true){
            int seleccion;
            out.println("1. NOMBRAMIENTO A");
            out.println("2. NOMBRAMIENTO B");
            out.println("3. NOMBRAMIENTO C");
            seleccion = Integer.parseInt(in.readLine());
            if(seleccion == 1){
                tipoNombramiento = 'A';
                break;
            }else if(seleccion == 2){
                tipoNombramiento = 'B';
                break;
            }else if(seleccion == 3){
                tipoNombramiento = 'C';
                break;
            }else{
                out.println("DATO INVALIDO");
                break;
            }
        }

        bracketPrint("HORAS SEMANALES ASIGNADAS");
        horasSemanales = Integer.parseInt(in.readLine());

        if(!(controller.validarExistenciaIdentificacion(cedula))) {
            controller.registrarAdministrativo(nombre, primerApellido, segundoApellido, cedula, tipoNombramiento, horasSemanales);
            System.out.println("ADMINISTRATIVO REGISTRADO");
        }else{
            out.println("YA EXISTE UN USUARIO CON LA IDENTIFICACIÓN " + cedula);
            out.println("INTÉNTELO MÁS TARDE...");
        }
    }

    public static void registrarMaterialVideo() throws IOException{
        String signatura;
        boolean restringido;
        String tema;
        String formato;
        double duracionSegundos;
        String idioma = "";
        String director;

        bracketPrint("SIGNATURA");
        signatura = in.readLine();

        restringido = makeQuestion("EL MATERIAL ESTÁ RESTRINGIDO");

        bracketPrint("TEMA");
        tema = in.readLine();

        bracketPrint("FORMATO");
        formato = in.readLine();

        int max = 10;
        int min = 1;
        int range = max - min + 1;
        duracionSegundos = (int)(Math.random() * range) + min;

        bracketPrint("IDIOMA");
        idioma = in.readLine();

        bracketPrint("DIRECTOR");
        director = in.readLine();

        if(!(controller.validarExistenciaMaterial(signatura))) {
            controller.registrarMaterialVideo(signatura, restringido, tema, formato, duracionSegundos, idioma, director);
            out.println("VIDEO REGISTRADO");
        }else{
            out.println("YA EXISTE UN MATERIAL CON LA SIGNATURA " + signatura);
            out.println("INTÉNTELO MÁS TARDE...");
        }

    }

    public static void registrarMaterialAudio() throws IOException{
        String signatura;
        boolean restringido;
        String tema;
        String formato;
        double duracionSegundos;
        String idioma;

        bracketPrint("SIGNATURA");
        signatura = in.readLine();

        restringido = makeQuestion("EL MATERIAL ESTÁ RESTRINGIDO");

        bracketPrint("TEMA");
        tema = in.readLine();

        bracketPrint("FORMATO");
        formato = in.readLine();

        int max = 10;
        int min = 1;
        int range = max - min + 1;
        duracionSegundos = (int)(Math.random() * range) + min;

        if(!(controller.validarExistenciaMaterial(signatura))) {
            if (makeQuestion("DESEA AGREGAR UN IDIOMA")) {
                bracketPrint("DESRIPCIÓN DEL IDIOMA");
                idioma = in.readLine();
                controller.registrarMaterialAudio(signatura, restringido, tema, formato, duracionSegundos, idioma);
            } else {
                controller.registrarMaterialAudio(signatura, restringido, tema, formato, duracionSegundos);
            }
            out.println("AUDIO REGISTRADO");
        }else{
            out.println("YA EXISTE UN MATERIAL CON LA SIGNATURA " + signatura);
            out.println("INTÉNTELO MÁS TARDE...");
        }
    }

    public static void registrarMaterialTexto() throws IOException{
        String signatura;
        boolean restringido;
        String tema;
        String titulo;
        LocalDate fechaPublicacion;
        String nombreAutor;
        int cantidadPaginas;
        String idioma;

        bracketPrint("SIGNATURA");
        signatura = in.readLine();

        restringido = makeQuestion("EL MATERIAL ESTÁ RESTRINGIDO");

        bracketPrint("TEMA");
        tema = in.readLine();

        bracketPrint("TITULO");
        titulo = in.readLine();

        int dia, mes, anno;
        bracketPrint("INGRESE LOS DATOS DE LA FECHA DE PUBLICACIÓN");
        bracketPrint("DIA");
        dia = Integer.parseInt(in.readLine());
        bracketPrint("MES");
        mes = Integer.parseInt(in.readLine());
        bracketPrint("AÑO");
        anno = Integer.parseInt(in.readLine());

        fechaPublicacion = convertToLocalDate(anno, mes, dia);

        bracketPrint("NOMBRE DEL AUTOR");
        nombreAutor = in.readLine();

        bracketPrint("CANTIDAD DE PÁGINAS");
        cantidadPaginas = Integer.parseInt(in.readLine());

        bracketPrint("IDIOMA");
        idioma = in.readLine();

        if(!(controller.validarExistenciaMaterial(signatura))) {
            controller.registrarMaterialTexto(signatura, restringido, tema, titulo, nombreAutor, fechaPublicacion,
                    cantidadPaginas, idioma);

            out.println("TEXTO REGISTRADO");
        }else{
            out.println("YA EXISTE UN MATERIAL CON LA SIGNATURA " + signatura);
            out.println("INTÉNTELO MÁS TARDE...");
        }
    }

    public static void registrarMaterialIndefinido() throws IOException{
        String signatura;
        String descripcion;

        bracketPrint("SIGNATURA");
        signatura = in.readLine();

        bracketPrint("DESCRIPCION");
        descripcion = in.readLine();

        if(!(controller.validarExistenciaMaterial(signatura))) {
            controller.registrarMaterialIndefinido(signatura, descripcion);
            out.println("MATERIAL INDEFINIDO REGISTRADO");
        }else{
            out.println("YA EXISTE UN MATERIAL CON LA SIGNATURA " + signatura);
            out.println("INTÉNTELO MÁS TARDE...");
        }

    }

    public static void imprimirEstudiantes(){
        ArrayList<String> estudiantes = controller.obtenerEstudiantes();
        for(String e: estudiantes){
            System.out.println(e);
        }
    }

    public static void imprimirProfesores(){
        ArrayList<String> profesores = controller.obtenerProfesores();
        for(String e: profesores){
            System.out.println(e);
        }
    }

    public static void imprimirAdministrativos(){
        ArrayList<String> administrativos = controller.obtenerAdministrativos();
        for(String e: administrativos){
            System.out.println(e);
        }
    }

    public static void imprimirMaterialVideo(){
        ArrayList<String> videos = controller.obtenerMaterialVideo();
        for(String e: videos){
            System.out.println(e);
        }
    }

    public static void imprimirMaterialAudio(){
        ArrayList<String> audio = controller.obtenerMaterialAudio();
        for(String e: audio){
            System.out.println(e);
        }
    }

    public static void imprimirMaterialTexto(){
        ArrayList<String> textos = controller.obtenerMaterialTexto();
        for(String e: textos){
            System.out.println(e);
        }
    }

    public static void imprimirMaterialIndefinido(){
        ArrayList<String> otros = controller.obtenerMaterialIndefinido();
        for(String e: otros){
            System.out.println(e);
        }
    }

    public static void realizarPrestamoUsuario() throws IOException{
        String identificacion;
        String signaturaMaterial;

        bracketPrint("IDENTIFICACIÓN DEL USUARIO");
        identificacion = in.readLine();

        if(!(controller.validarExistenciaIdentificacion(identificacion))){
            out.println("NO EXISTE UN USUARIO CON ESA LA IDENTIFICACIÓN " + identificacion);
            out.println("INTENTELO MÁS TARDE...");
        }else{
            bracketPrint("-MATERIALES DISPONIBLES-");
            imprimirMaterialTexto();
            imprimirMaterialVideo();
            imprimirMaterialAudio();
            imprimirMaterialIndefinido();
            bracketPrint("ESCRIBA LA IDENTIFICACIÓN DEL MATERIAL");
            signaturaMaterial = in.readLine();

            if(controller.validarExistenciaMaterial(signaturaMaterial)){
                controller.realizarPrestamo(identificacion, signaturaMaterial);
                out.println("PRESTAMO REALIZADO");
            }else{
                out.println("NO EXISTE UN MATERIAL CON LA SIGNATURA " + signaturaMaterial);
                out.println("INTENTELO MÁS TARDE...");
            }
        }


    }


    public static void bracketPrint(String string){
        out.println("[ " + string + " ]");
    }

    /**
     * Valida si el campo textual no está vacío.
     * @param field campo textual que se va a validar.
     * @return true si el campo validado sí está vacío.
     */
    public static boolean validateEmptyField(String field){
        if(field.isEmpty() || field.isBlank())
            return true;
        else
            return false;
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

    /**
     * Valida que el campo sea un número, si el campo no puede ser transformado en un número retorna false.
     * @param textField campo a validar.
     * @return true si el campo puede ser convertido en un número.
     */
    public static boolean validateNumberField(String textField){
        try{
            Double.parseDouble(textField);
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

    public static void printImportantNote(){

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
}