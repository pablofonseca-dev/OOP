package cr.ac.ucenfotec.UI;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import cr.ac.ucenfotec.TL.Controller;

/**
 * @author Pablo Fonseca.
 * @version 1.0
 *
 */
public class UI {


    /*
     * I.O
     */
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static Controller controller = new Controller();

    /**
     * Program Main.
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
        final int MENU = 8;
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
        menu_formatter += "# [1] Registrar Cliente.                     #" + "\n";
        menu_formatter += "# [2] Registrar Cuenta Bancaria.             #" + "\n";
        menu_formatter += "# [3] Ver Clientes Registrados.              #" + "\n";
        menu_formatter += "# [4] Buscar Datos de un Cliente.            #" + "\n";
        menu_formatter += "# [5] Ver Cuentas Registradas.               #" + "\n";
        menu_formatter += "# [6] Realizar Deposito Bancario.            #" + "\n";
        menu_formatter += "# [7] Realizar Retiro Bancario.              #" + "\n";
        menu_formatter += "# [8] Imprimir Menu                          #" + "\n";
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
                registrarCliente();
                break;
            case 2:
                registrarCuentaBancaria();
                break;
            case 3:
                mostrarClientesRegistrados();
                break;
            case 4:
                buscarCliente();
                break;
            case 5:
                mostrarCuentasRegistradas();
                break;
            case 6:
                realizarDeposito();
                break;
            case 7:
                realizarRetiro();
                break;
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }

    public static void registrarCliente() throws IOException{
        String nombre, primerApellido, segundoApellido, identificacion, detalleDireccion;

        out.println("NOMBRE");
        nombre = in.readLine();

        out.println("PRIMER APELLIDO");
        primerApellido = in.readLine();

        out.println("SEGUNDO APELLIDO");
        segundoApellido = in.readLine();

        out.println("IDENTIFICACION");
        identificacion = in.readLine();

        out.println("DIRECCIÓN");
        detalleDireccion =  in.readLine();

        boolean clienteExiste = controller.validarExistenciaCliente(identificacion);
        if(clienteExiste){
            out.println("Ya existe un cliente con la identificación " + identificacion);
            out.println("Inténtelo más tarde...");
        }else{
            controller.registrarCliente(nombre, primerApellido, segundoApellido, identificacion, detalleDireccion);
            out.println("Cliente Registrado...");
        }

    }

    public static void registrarCuentaBancaria() throws IOException{

        String identificacion;
        String tipoCuenta;

        out.println("IDENTIFICACIÓN DEL CLIENTE");
        identificacion = in.readLine();

        out.println("TIPO DE CUENTA BANCARIA A REGISTRAR");

        out.println("1. CUENTA CORRIENTE");
        out.println("2. CUENTA DE AHORRO");
        out.println("3. CUENTA DE AHORRO PROGRAMADO");
        tipoCuenta = in.readLine();

        switch(tipoCuenta){
            case "1":
                registrarCuentaCorriente(identificacion);
                break;
            case "2":
                registrarCuentaAhorro(identificacion);
                break;
            case "3":
                registrarCuentaAhorroProgramado(identificacion);
                break;
            default:
                out.println("DATO INCORRECTO");
                break;
        }

    }

    public static void registrarCuentaCorriente(String identificacion){
        boolean cuentaRegistrada = controller.registrarCuentaCorriente(identificacion);
        if(cuentaRegistrada){
            out.println("Cuenta Registrada...");
        }else{
            out.println("No se pudo registrar la cuenta... Inténtelo más tarde.");
            System.err.println("NO EXISTE UN CLIENTE CON LA IDENTIFICACIÓN " + identificacion);
        }
    }

    public static void registrarCuentaAhorro(String identificacion){
        boolean cuentaRegistrada = controller.registrarCuentaAhorro(identificacion);
        if(cuentaRegistrada){
            out.println("Cuenta Registrada...");
        }else{
            out.println("No se pudo registrar la cuenta... Inténtelo más tarde.");
            System.err.println("NO EXISTE UN CLIENTE CON LA IDENTIFICACIÓN " + identificacion);
        }
    }

    public static void registrarCuentaAhorroProgramado(String identificacion){
        boolean cuentaRegistrada = controller.registrarCuentaAhorroProgramado(identificacion);
        if(cuentaRegistrada){
            out.println("Cuenta Registrada...");
        }else{
            out.println("No se pudo registrar la cuenta... Inténtelo más tarde.");
            System.err.println("NO EXISTE UN CLIENTE CON LA IDENTIFICACIÓN " + identificacion);
        }
    }

    public static void realizarDeposito() throws IOException{

        mostrarCuentasRegistradas();

        int numeroCuenta; String descripcion; double monto;

        out.println("NÚMERO DE LA CUENTA");
        numeroCuenta = Integer.parseInt(in.readLine());

        out.println("DESCRIPCIÓN DEL DEPOSITO");
        descripcion = in.readLine();

        out.println("MONTO A DEPOSITAR");
        monto = Double.parseDouble(in.readLine());

        if(controller.realizarDepositoBancario(numeroCuenta, descripcion, monto)){
            out.println("Deposito Realizado...");
        }else{
            out.println("No se pudo realizar el depósito. Inténtelo más tarde...");
        }

    }

    public static void realizarRetiro() throws IOException{
        mostrarCuentasRegistradas();

        int numeroCuenta; String descripcion; double monto;

        out.println("NÚMERO DE LA CUENTA");
        numeroCuenta = Integer.parseInt(in.readLine());

        out.println("DESCRIPCIÓN DEL DEPOSITO");
        descripcion = in.readLine();

        out.println("MONTO A RETIRAR");
        monto = Double.parseDouble(in.readLine());

        if(controller.realizarRetiroBancario(numeroCuenta, descripcion, monto)){
            out.println("Retiro Realizado...");
        }else{
            out.println("No se pudo realizar el retiro. Inténtelo más tarde...");
        }

    }

    public static void mostrarClientesRegistrados(){
        ArrayList<String> clientes = controller.obtenerClientesRegistrados();
        for(String cliente : clientes){
            out.println(cliente);
        }
    }

    public static void mostrarCuentasRegistradas(){
        ArrayList<String> cuentas = controller.obtenerCuentasRegistradas();
        for(String cuenta: cuentas){
            out.println(cuenta);
        }
    }

    public static void buscarCliente() throws IOException {
        String identificacion;

        out.println("IDENTIFICACIÓN DEL CLIENTE");
        identificacion = in.readLine();

        if(controller.validarExistenciaCliente(identificacion)){
            String datosCliente = controller.obtenerDatosCliente(identificacion);
            if(datosCliente != null){
                out.println(datosCliente);
            }else{
                out.println("NO SE PUDIERON CARGAR LOS DATOS");
            }
        }else{
            out.println("NO EXISTE UN CLIENTE CON LA IDENTIFICACIÓN " + identificacion);
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