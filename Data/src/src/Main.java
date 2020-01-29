import java.io.*;
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static int[] notas;
    static String[] estudiantes;
    static int indice = 0;
    /*
    Punto de entrada de la aplicaci�n.
    llama a la rutina que imprime el men�
     */
    public static void main(String args[]) throws IOException{
        mostrarMenu();
    }

    /*
    Nombre de la rutina : mostrarMenu
    Descripci�n: Muestra las opciones del men� al usuario y permite que seleccione una de ellas.
     */
    public static void mostrarMenu() throws IOException{
        int opcion = -1;
        do{
            out.println("1.Inicializar programa");
            out.println("2.Registrar estudiante");
            out.println("3.Registrar nota");
            out.println("4.Listar notas");
            out.println("5.Listar estudiantes");
            out.println("0.Salir");
            opcion = seleccionarOpcion();
            procesarOpcion(opcion);
        }while(opcion !=0);
    }

    /*
    Rutina que solicita la opci�n del men� seleccionada por el usuario.
    Retorna: un entero con la opci�n ingresada.
     */
    public static int seleccionarOpcion() throws IOException{
        out.println("Digite a opci�n que desea ejecutar");
        return Integer.parseInt(in.readLine());
    }
    /*
    Nombre de la rutina : procesarOpcion
    Descipci�n: Rutina que se encarga, seg�n la opci�n seleccionada, iniciar la acci�n relacionada
    a dicha opci�n.
    par�metro: pOpcion, de tipo entero.  Opci�n del men� seleccionada por el usuario.
     */
    public static void procesarOpcion(int pOpcion) throws IOException{
        switch(pOpcion){
            case 0:
                out.println("Gracias por usar el programa");
                break;
            case 1:
                inicializarPrograma();
                break;
            case 2:
                registrarEstudiante();
                break;
            case 3:
                registrarNotas();
                break;
            case 4:
                listarNotas();
                break;
            case 5:
                listarEstudiantes();
                break;
            default:
                out.println("Digit� una opci�n no v�lida");
                break;
        }
    }
    /*
    Nombre de la rutina : inicializarPrograma
    Descripci�n: se encarga de solicitar la cantidad de estudiantes y asignar dicho tama�o a los
                arrglos de notas y de estudiantes.
     */
    public static void inicializarPrograma() throws IOException{
        int size;
        out.println("Digite la cantidad de estudiantes");
        size = Integer.parseInt(in.readLine());
        notas = new int[size];
        estudiantes = new String[size];
    }
    /*
    Nombre de la rutina : registrarEstudiantes
    Descripci�n : Solicita el nombre del estudiante y lo registra en el arreglo.4
                  Antes de ingresarlo, verifica si el nombre exite, siempre que no sea
                  el primero que se ingresa.

     */
    public static void registrarEstudiante() throws IOException {
        String nombre;
        boolean existe = false;
        //TODO : AGREGAR VALIDACI�N PARA VERIFICAR QUE EL ARREGLO EST� INICIALIZADO.
        out.println("Digite el nombre del estudiante");
        nombre = in.readLine();

        if ((indice == 0)) { // es el primero
            agregarEstudianteArreglo(nombre);
        } else {
            existe = buscarEstudiante(nombre);
            if (existe == true) {
                out.println("El estudiante ya existe");
            } else if (existe == false) {
                agregarEstudianteArreglo(nombre);
            } else if (indice == estudiantes.length) {
                out.println("No se pueden registrar m�s estudidantes");
            }
        }
    }

    /*
    Nombre de la rutina : AgregarEstudianteArreglo
    Descripci�n: agrega el estudiante que recibe como par�metro, directamente al arreglo.
    Par�metros: nombre, de tipo String. Nombre del estudiante.
     */
    public static void agregarEstudianteArreglo(String nombre){
        estudiantes[indice]= nombre;
        indice++;
    }
    /*
    Nombre de la rutina: registrarNotas
    Descripci�n : registra la nota al estudiante cuyo nombre lo ingresa el usuario.
                  Para saber si la posici�n en la que est� almacenado el estudiante en el
                  arreglo, usa la variable indiceEstudiante. Si esta variable es igual a
                  menos uno, el nombre no est� en el arreglo. Si es diferente, entonces
                  se hace el c�lculo de la nota y se almacena la misma en el arreglo de
                  notas.
     */
    public static void registrarNotas() throws java.io.IOException{
        out.println("Digite el nombre del estudiante");
        String nombre = in.readLine();
        int indiceEstudiante = buscarIndiceEstudiante(nombre);
        if(indiceEstudiante > -1){
            notas[indiceEstudiante] = calcularNota(indiceEstudiante);
        }
        else{
            out.println("El estudiante no existe");

        }
    }
    /*
    Nombre de la rutina: calcularNota
    Descripci�n : Rutina que procesa, seg�n el �ndice del estudiante, la informaci�n y retorna
    la nota calculada.
    Par�metros: idEstudiante, de tipo entero.  �ndice que contiene la posici�n del nombre del
    estudiante.

     */
    public static int calcularNota(int idEstudiante) throws  IOException{
        int[][] preguntas = new int [5][3];
        ingresarId(preguntas,idEstudiante);
        ingresarValorPregunta(preguntas);
        ingresarCalificacion(preguntas);
        return calcularNotaFinal(preguntas);
    }

    /*
    Nombre de la rutina: ingresarID.
    Descripci�n: ingresa el id del estudiante en la matriz.
     */
    public static void ingresarId(int[][] preguntas,int id){
        for(int i=0;i<4;i++){
            preguntas[i][0] = id;
        }
    }

    /*
    Nombre de la rutina: calcularNotaFinal
    Descipci�n: calcula la nota del estudiante, recorriendo la informaci�n que est� en la
    tercera columna de la matriz.
    Retorno: nota, entero. Nota obtenida por el estudiante.
     */
    public static int calcularNotaFinal(int[][]preguntas){
        int nota = 0;
        for(int i=0;i<4;i++){
            nota = nota + preguntas[i][2];
        }
        return nota;
    }
    /*
    Rutina que registra el valor de la pregunta en la matriz.
     */
    public static void ingresarValorPregunta(int[][] preguntas) throws IOException{
        for(int i=0;i<4;i++){
            out.println("Digite el valor de la pregunta n�mero " + (i +1));
            preguntas[i][1] = Integer.parseInt(in.readLine());
        }
    }

    /*
    Nombre de la rutina: ingresarCalificacion.
    Rutina que registra la calificaci�n obtenida por el estudiante.
     */
    public static void ingresarCalificacion(int [][] preguntas) throws IOException{
        for(int i=0;i<4;i++){
            out.println("Digite la nota obtenida en la pregunta n�mero " + (i +1));
            preguntas[i][2]= Integer.parseInt(in.readLine());
        }

    }

    /*
    Nombre de la rutina: buscarIndiceEstudiante.
    Descripci�n: busca el �ndice del nombre en el arreglo de estudiantes.
    Retorno: indice, entero. Posici�n en el arreglo del nombre recibido como par�metro.
     */
    public static int buscarIndiceEstudiante(String nombre){
        int indice = -1;
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i].equals(nombre)){
                return i;
            }
        }
        return indice;
    }

    /*
    Nombre de la rutina: buscarIndiceEstudiante.
    Descripci�n: busca si el nombre  del estudiante est� en el arreglo.
    Retorno: estaRepetido, booleano.
     */
    public static boolean buscarEstudiante(String nombre){
        boolean estaRepetido = false;
        for(int i=0;i<indice;i++){
            if(estudiantes[i].equals(nombre)){
                return true;
            }
        }
        return estaRepetido;
    }

    /*
    Nombre de la rutina: listarEstudiantes
    Descripci�n: recorre el arreglo de estudiantes e imprime el nombre
     */

    public static void listarEstudiantes(){
        for(int i = 0;i<indice;i++){
            out.println("La informaci�n del estudiante es :" + estudiantes[i]);
        }
    }

    /*
    Nombre de la rutina: listarEstudiantes
    Descripci�n: recorre el arreglo de estudiantes y notas e imprime el nombre y la nota.
     */
    public static void listarNotas(){
        for(int i =0;i<indice;i++){
            out.println("La nota del estudiantes " + estudiantes[i] +
                        " fue de un " + notas[i]);
        }
    }
}
