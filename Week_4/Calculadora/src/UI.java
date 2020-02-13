import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
public class UI {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static Controller controller = new Controller();
    public static void main(String[] args) throws IOException{
        program_start();
    }
    public static void program_start() throws IOException {
        int user_selection;
        boolean program_flow;
        program_flow = true;
        final int MENU = 6;
        final int EXIT = 7;
        String main_menu = get_main_menu();
        out.println(main_menu);

        do {
            out.print("[Acción]>>>");
            try {
                user_selection = Integer.parseInt(in.readLine());
                if (user_selection == EXIT) {
                    program_flow = false;
                } else if (user_selection == MENU) {
                    out.println(main_menu);
                } else {
                    function_caller(user_selection);
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
        menu_formatter += "# [1] Sumar                                  #" + "\n";
        menu_formatter += "# [2] Restar                                 #" + "\n";
        menu_formatter += "# [3] Multiplicar                            #" + "\n";
        menu_formatter += "# [4] Dividir                                #" + "\n";
        menu_formatter += "# [5] Calcular Raíz Cuadrada                 #" + "\n";
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
                add();
                break;
            case 2:
                subtract();
                break;
            case 3:
                multiply();
                break;
            case 4:
                divide();
                break;
            case 5:
                squareRoot();
                break;
            default:
                out.println("Opción Inválida");
                break;
        }
    }

    public static void add() throws IOException{
        out.println(controller.calculateAddition(getTwoNumbers()));
    }

    public static void subtract() throws IOException{
        out.println(controller.calculateSubtraction(getTwoNumbers()));
    }

    public static void multiply() throws IOException{
        out.println(controller.calculateProduct(getTwoNumbers()));
    }

    public static void divide() throws IOException{
        try{
            out.println(controller.calculateDivision(getTwoNumbers()));
        }catch(ArithmeticException exception){
            out.println("Los valores no pueden ser divididos");
        }
    }

    public static void squareRoot() throws IOException{
        double number;
        out.println("Digite el número");

        try{
            number = Double.parseDouble(in.readLine());
            out.println(controller.calculateSquareRoot(number));
        }catch(ArithmeticException exception){
            out.println("El valor no puede ser operado");
        }
    }

    public static double[] getTwoNumbers() throws IOException{
        boolean validationFlow = true;
        do {
            try {
                out.println("Ingrese el número uno");
                out.print(">>> ");
                double numberOne = Double.parseDouble(in.readLine());

                out.println("Ingrese el número dos");
                out.print(">>> ");
                double numberTwo = Double.parseDouble(in.readLine());

                validationFlow = false;
                return new double[]{numberOne, numberTwo};
            } catch (NumberFormatException exception) {
                out.println("El valor debe ser un número real.");
            }
        }while(validationFlow);
        return null;
    }

}
