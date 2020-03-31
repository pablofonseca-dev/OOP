package cr.ac.ucenfotec.UI;

import cr.ac.ucenfotec.TL.Controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

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
        final int MENU = 6;
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
        menu_formatter += "# [1] Crear un vehículo                      #" + "\n";
        menu_formatter += "# [2] Crear un motor                         #" + "\n";
        menu_formatter += "# [3] Asociar un motor a un vehículo         #" + "\n";
        menu_formatter += "# [4] Listar todos los vehículos registrados #" + "\n";
        menu_formatter += "# [5] Listar todos los motores registrados   #" + "\n";
        menu_formatter += "# [6] Imprimir Menu                          #" + "\n";
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
                logCar();
                break;
            case 2:
                //Option 2
                logEngine();
                break;
            case 3:
                //Option 3
                break;
            case 4:
                //Option 4
                outputCars();
                break;
            case 5:
                //Option 5
                outputEngines();
                break;
            default:
                out.println("[Opción Inválida]");
                break;
        }
    }

    public static void logCar() throws IOException {
        boolean errorExpected = true;
        do{
            ArrayList<String> carData = new ArrayList<>(2);
            carData = getCarData();
            if(carData != null){
                bracketPrint("Datos generales obtenidos satisfactoriamente");
                if(makeQuestion("Desea asociar este vehículo a un motor")){
                    outputEngines();
                    ArrayList<String> engineData = new ArrayList<String>(2);
                    engineData = getEngineData();
                    if(engineData != null){
                        //Validate if the engine exist.
                        if(validateEngineExistence(engineData.get(0))){
                            controller.logCar(carData.get(0), carData.get(1), engineData.get(0), Integer.parseInt(engineData.get(1)));
                            bracketPrint("El motor se asoció exitosamente");
                            errorExpected = false;
                        }else{
                            printErrorNotification("El motor asignado al vehículo no existe, por ende no se puede " +
                                    "relacionar");
                            controller.logCar(carData.get(0), carData.get(1));
                            errorExpected = false;
                        }
                    }else{
                        printErrorNotification("No se pudo hacer la relación");
                        tryAgainNotification();
                    }
                }else{
                    controller.logCar(carData.get(0), carData.get(1));
                    bracketPrint("Vehículo independiente registrado");
                    errorExpected = false;
                }
            }else{
                printErrorNotification("El vehículo no se pudo registrar");
                tryAgainNotification();
            }
        }while(errorExpected);
    }

    public static void logEngine() throws IOException{
        boolean errorExpected = true;
        do{
            ArrayList<String> engineData = new ArrayList<>(2);
            engineData = getEngineData();
            if(engineData != null){
                controller.logEngine(engineData.get(0), Integer.parseInt(engineData.get(1)));
                bracketPrint("Motor independiente registrado");
                errorExpected = false;
            }else{
                printErrorNotification("El motor no pudo ser registrado");
                tryAgainNotification();
            }
        }while(errorExpected);
    }

    public static ArrayList<String> getCarData() throws IOException {
        String serialNumber;
        String brand;

        out.println("Ingrese los siguientes datos del vehículo");

        bracketPrint("Número de serie");
        prompt();
        serialNumber = in.readLine();

        //Validate if the serial number is not empty
        if(!validateNotEmptyField(serialNumber)){
            printErrorNotification("Este campo no puede estar vacío");
            return null;
        }

        //Validate if the serial number have at least 6 characters.
        if(!validateCharQuantity(6, serialNumber)){
            printErrorNotification("El valor debe contener al menor 6 caracteres");
            return null;
        }

        //Get the car brand
        bracketPrint("Marca");
        prompt();
        brand = in.readLine();

        //Validate if the brand is not empty
        if(!validateNotEmptyField(brand)){
            printErrorNotification("Este campo no puede estar vacío");
            return null;
        }

        //Validate if the brand has at least 3 characters.
        if(!validateCharQuantity(3, brand)){
            printErrorNotification("El valor debe contener al menos 3 caracteres");
            return null;
        }

        ArrayList<String> carData = new ArrayList<String>(2);
        carData.add(serialNumber);
        carData.add(brand);
        return carData;
    }

    public static ArrayList<String> getEngineData() throws IOException{
        String serialNumber;
        String cylindersAmount;

        bracketPrint("Número de serie");
        prompt();
        serialNumber = in.readLine();

        //Validate if the serial number is not empty
        if(!validateNotEmptyField(serialNumber)){
            printErrorNotification("Este campo no puede estar vacío");
            return null;
        }

        //Validate if the serial number have at least 6 characters.
        if(!validateCharQuantity(6, serialNumber)){
            printErrorNotification("El valor debe contener al menor 6 caracteres");
            return null;
        }

        bracketPrint("Número de cilindros");
        prompt();
        cylindersAmount = in.readLine();

        //Validate if the cylinders amount is not empty
        if(!validateNotEmptyField(cylindersAmount)){
            printErrorNotification("Este campo no puede estar vacío");
            return null;
        }

        //Validate if the provided cylinders amount is a number.
        if(!validateNumberField(cylindersAmount)){
            printErrorNotification("El valor debe ser un número");
            return null;
        }

        //Validate if the engine have at least 4 cylinders.
        if(!validateNumberQuantity(4, Integer.parseInt(cylindersAmount))){
            printErrorNotification("El motor debe tener al menos 4 cilindros");
            return null;
        }

        ArrayList<String> engineData = new ArrayList<>(2);
        engineData.add(serialNumber);
        engineData.add(cylindersAmount);
        return engineData;
    }

    public static void outputEngines(){
        String engines[] = controller.getEngines();
        for(String e: engines){
            out.println(e);
        }
    }

    public static void outputCars(){
        String cars[] = controller.getCars();
        for(String e: cars){
            out.println(e);
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

    public static boolean validateEngineExistence(String serialNumber){
        return controller.validateEngineExistence(serialNumber);
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
