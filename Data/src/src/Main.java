import java.io.*;
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static int[] notas;
    static String[] estudiantes;
    static int indice = 0;
    /*
    Punto de entrada de la aplicación.
    llama a la rutina que imprime el menú
     */
    public static void main(String args[]) throws IOException{
        mostrarMenu();
    }

    /*
    Nombre de la rutina : mostrarMenu
    Descripción: Muestra las opciones del menú al usuario y permite que seleccione una de ellas.
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
    Rutina que solicita la opción del menú seleccionada por el usuario.
    Retorna: un entero con la opción ingresada.
     */
    public static int seleccionarOpcion() throws IOException{
        out.println("Digite a opción que desea ejecutar");
        return Integer.parseInt(in.readLine());
    }
    /*
    Nombre de la rutina : procesarOpcion
    Descipción: Rutina que se encarga, según la opción seleccionada, iniciar la acción relacionada
    a dicha opción.
    parámetro: pOpcion, de tipo entero.  Opción del menú seleccionada por el usuario.
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
                out.println("Digitó una opción no válida");
                break;
        }
    }
    /*
    Nombre de la rutina : inicializarPrograma
    Descripción: se encarga de solicitar la cantidad de estudiantes y asignar dicho tamaño a los
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
    Descripción : Solicita el nombre del estudiante y lo registra en el arreglo.4
                  Antes de ingresarlo, verifica si el nombre exite, siempre que no sea
                  el primero que se ingresa.

     */
    public static void registrarEstudiante() throws IOException {
        String nombre;
        boolean existe = false;
        //TODO : AGREGAR VALIDACIÓN PARA VERIFICAR QUE EL ARREGLO ESTÉ INICIALIZADO.
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
                out.println("No se pueden registrar más estudidantes");
            }
        }
    }

    /*
    Nombre de la rutina : AgregarEstudianteArreglo
    Descripción: agrega el estudiante que recibe como parámetro, directamente al arreglo.
    Parámetros: nombre, de tipo String. Nombre del estudiante.
     */
    public static void agregarEstudianteArreglo(String nombre){
        estudiantes[indice]= nombre;
        indice++;
    }
    /*
    Nombre de la rutina: registrarNotas
    Descripción : registra la nota al estudiante cuyo nombre lo ingresa el usuario.
                  Para saber si la posición en la que está almacenado el estudiante en el
                  arreglo, usa la variable indiceEstudiante. Si esta variable es igual a
                  menos uno, el nombre no está en el arreglo. Si es diferente, entonces
                  se hace el cálculo de la nota y se almacena la misma en el arreglo de
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
    Descripción : Rutina que procesa, según el índice del estudiante, la información y retorna
    la nota calculada.
    Parámetros: idEstudiante, de tipo entero.  Índice que contiene la posición del nombre del
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
    Descripción: ingresa el id del estudiante en la matriz.
     */
    public static void ingresarId(int[][] preguntas,int id){
        for(int i=0;i<4;i++){
            preguntas[i][0] = id;
        }
    }

    /*
    Nombre de la rutina: calcularNotaFinal
    Descipción: calcula la nota del estudiante, recorriendo la información que está en la
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
            out.println("Digite el valor de la pregunta número " + (i +1));
            preguntas[i][1] = Integer.parseInt(in.readLine());
        }
    }

    /*
    Nombre de la rutina: ingresarCalificacion.
    Rutina que registra la calificación obtenida por el estudiante.
     */
    public static void ingresarCalificacion(int [][] preguntas) throws IOException{
        for(int i=0;i<4;i++){
            out.println("Digite la nota obtenida en la pregunta número " + (i +1));
            preguntas[i][2]= Integer.parseInt(in.readLine());
        }

    }

    /*
    Nombre de la rutina: buscarIndiceEstudiante.
    Descripción: busca el índice del nombre en el arreglo de estudiantes.
    Retorno: indice, entero. Posición en el arreglo del nombre recibido como parámetro.
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
    Descripción: busca si el nombre  del estudiante está en el arreglo.
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
    Descripción: recorre el arreglo de estudiantes e imprime el nombre
     */

    public static void listarEstudiantes(){
        for(int i = 0;i<indice;i++){
            out.println("La información del estudiante es :" + estudiantes[i]);
        }
    }

    /*
    Nombre de la rutina: listarEstudiantes
    Descripción: recorre el arreglo de estudiantes y notas e imprime el nombre y la nota.
     */
    public static void listarNotas(){
        for(int i =0;i<indice;i++){
            out.println("La nota del estudiantes " + estudiantes[i] +
                        " fue de un " + notas[i]);
        }
    }
}
