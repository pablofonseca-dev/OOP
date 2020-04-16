package cr.ac.ucenfotec.DL;

import cr.ac.ucenfotec.BL.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se va a encargar de realizar todas las operaciones necesarias relacionadas con la persistencia de la
 * información, en memoria y también en archivos locales.
 */
public class DataAccess {

    //Buffer que escribe los datos en un archivo específico.
    private BufferedWriter bufferedWriter;

    //File Writer que se le implementará al BufferedWriter
    private FileWriter  writer;

    //Buffer que lee los datos de un archivo específico.
    private BufferedReader bufferedReader;

    //Buffer que se le implementará al BufferedReader
    private FileReader reader;

    //ArrayList temporal que almacenará los datos de los usuarios en memoria.
    private ArrayList<Usuario> usuarios;

    //ArrayList temporal que almacenará los datos de los materiales en memoria.
    private ArrayList<Material> materiales;

    //URL de los ficheros que se van a utilizar en el programa.
    private static final String URL_USUARIOS_CSV = "src/cr/ac/ucenfotec/CSV/USUARIOS.csv";
    private static final String URL_MATERIALES_CSV = "src/cr/ac/ucenfotec/CSV/MATERIALES.csv";
    private static final String URL_PRESTAMOS_CSV = "src/cr/ac/ucenfotec/CSV/PRESTAMOS.csv";

    //Variables estáticas que almacenan un número entero, indica el tipo de usuario que se va a utilizar.
    public static final int ESTUDIANTE = 1;
    public static final int PROFESOR = 2;
    public static final int ADMINISTRATIVO = 3;

    //Variables estátitcas que almacenan un número entero, indica el tipo de material que se va a utilizar.
    public static final int VIDEO = 1;
    public static final int AUDIO = 2;
    public static final int TEXTO = 3;
    public static final int OTRO = 4;

    //CONSTRUCTOR COMPLETO
    public DataAccess() {
        //Se inicializan los objetos necesarios.
        this.bufferedWriter = null;
        this.writer = null;

        this.bufferedReader = null;
        this.reader = null;

        this.usuarios = new ArrayList<>();
        this.materiales = new ArrayList<>();

    }

    /**
     * Se encarga de guardar un usuario de tipo estudiante en el archivo de texto respectivo.
     * @param objEstudiante Objeto de tipo estudiante que se va a registrar.
     * @author Pablo Fonseca.
     */
    public void registrarEstudiante(Estudiante objEstudiante) {
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_USUARIOS_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);

            bufferedWriter.write(objEstudiante.toCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Se encarga de guardar un usuario de tipo estudiante en el archivo de texto respectivo.
     * @param objProfesor Objeto de tipo profesor que se va a registrar.
     * @author Pablo Fonseca.
     */
    public void registrarProfesor(Profesor objProfesor){
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_USUARIOS_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);
            bufferedWriter.write(objProfesor.toCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrarAdministrativo(Administrativo objAdministrativo){
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_USUARIOS_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);
            bufferedWriter.write(objAdministrativo.toCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que devuelve la información de un conjunto de usuarios específicos,
     * @param tipoUsuario: Número entero que indica el tipo de usuario que se ha solicitado.
     * @return ArrayList Collection de Estudiantes
     */
    public ArrayList<Usuario> obtenerUsuarios(int tipoUsuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if(new File(DataAccess.URL_USUARIOS_CSV).exists()) {
            HashMap<String, String> temporalContainer = new HashMap<>();
            String[] line_data;
            String line;
            try {
                this.reader = new FileReader(new File(DataAccess.URL_USUARIOS_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                while ((line = bufferedReader.readLine()) != null) {
                    line_data = line.split(",");
                    if (tipoUsuario == ESTUDIANTE) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoUsuario:Estudiante")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            Estudiante tempEstudiante = new Estudiante(
                                    temporalContainer.get("Nombre"),
                                    temporalContainer.get("PrimerApellido"),
                                    temporalContainer.get("SegundoApellido"),
                                    temporalContainer.get("Identificacion"),
                                    temporalContainer.get("Carrera"),
                                    Integer.parseInt(temporalContainer.get("Creditos")));
                            //Se valida si el estudiante tiene un préstamo.
                            if (analizarPrestamoUsuario(tempEstudiante)) {
                                //Si el usuario tiene un prestamo, se le agrega
                                enlazarUsuarioPrestamo(tempEstudiante);
                            }
                            usuarios.add(tempEstudiante);
                        }
                    } else if (tipoUsuario == PROFESOR) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoUsuario:Profesor")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            //Se crea el objeto
                            Profesor tempProfesor = new Profesor(
                                    temporalContainer.get("Nombre"),
                                    temporalContainer.get("PrimerApellido"),
                                    temporalContainer.get("SegundoApellido"),
                                    temporalContainer.get("Identificacion"),
                                    temporalContainer.get("TipoContrato"),
                                    LocalDate.parse(temporalContainer.get("FechaContratacion"))
                            );
                            //Se valida si el profesor tiene un préstamo.
                            if (analizarPrestamoUsuario(tempProfesor)) {
                                //Si el profesor tiene un prestamo, se le agrega
                                enlazarUsuarioPrestamo(tempProfesor);
                            }
                            usuarios.add(tempProfesor);
                        }
                    } else if (tipoUsuario == ADMINISTRATIVO) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoUsuario:Administrativo")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            Administrativo tempAdministrativo = new Administrativo(
                                    temporalContainer.get("Nombre"),
                                    temporalContainer.get("PrimerApellido"),
                                    temporalContainer.get("SegundoApellido"),
                                    temporalContainer.get("Identificacion"),
                                    temporalContainer.get("TipoNombramiento").charAt(0),
                                    Integer.parseInt(temporalContainer.get("HorasSemanales"))
                            );
                            //Se valida si el administrativo tiene un préstamo.
                            if (analizarPrestamoUsuario(tempAdministrativo)) {
                                //Si el administrativo tiene un prestamo, se le agrega
                                enlazarUsuarioPrestamo(tempAdministrativo);
                            }
                            usuarios.add(tempAdministrativo);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
        /**
         * Método que registra un material de tipo Video.
         * @param objMaterialVideo: Objeto de tipo MaterialVideo.
         */
        public void registrarMaterialVideo(MaterialVideo objMaterialVideo){
            try{
                this.writer = new FileWriter(new File(DataAccess.URL_MATERIALES_CSV), true);
                this.bufferedWriter = new BufferedWriter(this.writer);
                bufferedWriter.write(objMaterialVideo.toCSV());
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    /**
     * Método que se encarga de registrar un material de tipo Audio.
     * @param objMaterialAudio: Objeto de tipo MaterialAudio.
     */
    public void registrarMaterialAudio(MaterialAudio objMaterialAudio){
            try{
                this.writer = new FileWriter(new File(DataAccess.URL_MATERIALES_CSV), true);
                this.bufferedWriter = new BufferedWriter(this.writer);
                bufferedWriter.write(objMaterialAudio.toCSV());
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    /**
     * Método que se encarga de registrar un material de tipo Texto
     */
    public void registrarMaterialTexto(MaterialTexto objMaterialTexto){
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_MATERIALES_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);
            bufferedWriter.write(objMaterialTexto.toCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de registrar un material de Otro tipo
     */
    public void registrarMaterialIndefinido(MaterialOtro objMaterialOtro){
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_MATERIALES_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);
            bufferedWriter.write(objMaterialOtro.toCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Método que se encarga de retornar un
     */
    public ArrayList<Material> obtenerMateriales(int tipoMaterial) {
        ArrayList<Material> materiales = new ArrayList<>();
        if(new File(DataAccess.URL_MATERIALES_CSV).exists()) {
            HashMap<String, String> temporalContainer = new HashMap<>();
            String[] line_data;
            String line;
            try {
                this.reader = new FileReader(new File(DataAccess.URL_MATERIALES_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                while ((line = bufferedReader.readLine()) != null) {
                    line_data = line.split(",");
                    if(tipoMaterial == DataAccess.VIDEO) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoMaterial:Video")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            MaterialVideo materialVideo = new MaterialVideo(
                                    temporalContainer.get("Signatura"),
                                    Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                    temporalContainer.get("Tema"),
                                    temporalContainer.get("Formato"),
                                    Double.parseDouble(temporalContainer.get("DuracionSegundos")),
                                    temporalContainer.get("Idioma"),
                                    temporalContainer.get("Director"));
                            materiales.add(materialVideo);
                        }
                    }
                    else if(tipoMaterial == DataAccess.AUDIO) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoMaterial:Audio")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            MaterialAudio materialAudio = new MaterialAudio(
                                    temporalContainer.get("Signatura"),
                                    Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                    temporalContainer.get("Tema"),
                                    temporalContainer.get("Formato"),
                                    Double.parseDouble(temporalContainer.get("DuracionSegundos")),
                                    temporalContainer.get("Idioma")
                            );
                            materiales.add(materialAudio);
                        }
                        break;
                    }
                    else if(tipoMaterial == DataAccess.TEXTO) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoMaterial:Texto")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            MaterialTexto materialTexto = new MaterialTexto(
                                    temporalContainer.get("Signatura"),
                                    Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                    temporalContainer.get("Tema"),
                                    temporalContainer.get("Titulo"),
                                    temporalContainer.get("NombreAutor"),
                                    LocalDate.parse(temporalContainer.get("FechaPublicacion")),
                                    Integer.parseInt(temporalContainer.get("CantidadPaginas")),
                                    temporalContainer.get("Idioma")
                            );
                            materiales.add(materialTexto);
                        }
                    }
                    else if(tipoMaterial == DataAccess.OTRO) {
                        if (line_data[line_data.length - 1].equalsIgnoreCase("TipoMaterial:Otro")) {
                            for (String e : line_data) {
                                String[] arr = e.split(":");
                                temporalContainer.put(arr[0], arr[1]);
                            }
                            MaterialOtro materialOtro = new MaterialOtro(
                                    temporalContainer.get("Signatura"),
                                    temporalContainer.get("Descripcion")
                            );
                            materiales.add(materialOtro);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return materiales;
    }

    /**
     * Método que se encarga de asociar un material con un usuario.
     */
    public void agregarPrestamoMaterial(String identificacion, String signatura){
        //1. Se valida que exista un usuario con la identificación proporcionada.
        //2. Se inserta el usuario y el material enviado por parámetros en el archivo respectivo.
        try{
            this.writer = new FileWriter(new File(DataAccess.URL_PRESTAMOS_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);
            bufferedWriter.write("Identificacion");
            bufferedWriter.write(":");
            bufferedWriter.write(identificacion);
            bufferedWriter.write(",");
            bufferedWriter.write("Signatura");
            bufferedWriter.write(":");
            bufferedWriter.write(signatura);
            bufferedWriter.write(",");
            bufferedWriter.write("FechaPrestamo");
            bufferedWriter.write(":");
            bufferedWriter.write(LocalDate.now().toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de analizar si existe un usuario con una identificación
     * ingresada en el sistema.
     * @return true si existe un usuario que tenga esa identificación.
     */
    public boolean validarIdentificacionUsuario(String identificacion){
        if(new File(DataAccess.URL_USUARIOS_CSV).exists()) {
            try {
                this.reader = new FileReader(new File(DataAccess.URL_USUARIOS_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                String[] array;
                String line_data;
                String[] arr;
                while ((line_data = bufferedReader.readLine()) != null) {
                    //Se separa en comas
                    array = line_data.split(",");
                    //Se agarra el indice 3 de la separación, es la identificación de todos lo usuarios
                    //Se separa en dos para obtener el valor de la identificacion.
                    arr = array[3].split(":");
                    //EL indice uno de arr es el valor de la identificación, se usará para validar si algún usuario
                    // coincide con la enviada por parámetros.
                    if (arr[1].equals(identificacion)) {
                        return true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean validarSignaturaMaterial(String signatura){
        if(new File(DataAccess.URL_MATERIALES_CSV).exists()) {
            try {
                this.reader = new FileReader(new File(DataAccess.URL_MATERIALES_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                String[] array;
                String line_data;
                String[] arr;
                while ((line_data = bufferedReader.readLine()) != null) {
                    //Se separa en comas
                    array = line_data.split(",");
                    arr = array[0].split(":");
                    if (arr[1].equals(signatura)) {
                        return true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Método que se encarga de validar si un usuario tiene un prestamo, en caso de que sea cierto retorna true.
     * @return true si el usuario tiene un préstamo.
     */
    public boolean analizarPrestamoUsuario(Usuario objUsuario){
        if(new File(DataAccess.URL_PRESTAMOS_CSV).exists()) {
            try {
                FileReader reader = new FileReader(new File(DataAccess.URL_PRESTAMOS_CSV));
                BufferedReader bufferedReader = new BufferedReader(reader);
                //1. Analiza si la identificación del usuario se encuentra en el fichero prestamo, esto solamente si existe
                //el fichero.
                if (new File(URL_PRESTAMOS_CSV).exists()) {
                    String[] array;
                    String line_data;
                    while ((line_data = bufferedReader.readLine()) != null) {
                        //Se separa en comas
                        array = line_data.split(",");
                        //Se agarra el indice 0 de la separación, es la identificación de todos lo usuarios
                        //Se separa en dos para obtener el valor de la identificacion.
                        String[] arr = array[0].split(":");
                        //EL indice 1 de arr es el valor de la identificación, se usará para validar si algún usuario
                        // coincide con la enviada por parámetros.
                        if (arr[1].equals(objUsuario.getIdentificacion())) {
                            //Si el usuario hizo match, entonces se agrega al objeto.
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Método que se encarga de enlazar un enlace entre un objeto Usuario y sus prestamos.
     */
    public void enlazarUsuarioPrestamo(Usuario objUsuario){
        ArrayList<Material> materiales = new ArrayList<>();
        HashMap<String, String> temporalContainer = new HashMap<>();
        String[] line_data;
        String line;
        try {
            FileReader fileReader =  new FileReader(new File(DataAccess.URL_PRESTAMOS_CSV));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] arr;
            String[] arr2;
            String[] arr3;
            while ((line = bufferedReader.readLine()) != null) {
                line_data = line.split(",");
                //Se obtiene la signatura del material.
                arr = line_data[1].split(":");
                arr2 = line_data[0].split(":");
                arr3 = line_data[2].split(":");
                String signaturaMaterial = arr[1];
                String identificacionUsuario = arr2[1];
                String fechaPrestamo = arr3[1];
                //Se tiene la signatura del material.
                //Se buscará el material en el fichero de materiales.
                String analysis_data;
                String analysis_line_data[];
                if(objUsuario.getIdentificacion().equalsIgnoreCase(identificacionUsuario)) {
                    FileReader analysis = new FileReader(new File(DataAccess.URL_MATERIALES_CSV));
                    BufferedReader analysisBuffered = new BufferedReader(analysis);
                    //Ahora se comparará el ID con el ID de materiales
                    while ((analysis_data = analysisBuffered.readLine()) != null) {
                        analysis_line_data = analysis_data.split(",");
                        //Se parte para saber el ID del material
                        String[] analysis_arr = analysis_line_data[0].split(":");
                        if (signaturaMaterial.equalsIgnoreCase(analysis_arr[1])) {
                            if (analysis_line_data[analysis_line_data.length - 1].equalsIgnoreCase("TipoMaterial:Video")) {
                                for (String e : analysis_line_data) {
                                    String[] material_arr = e.split(":");
                                    temporalContainer.put(material_arr[0], material_arr[1]);
                                }
                                MaterialVideo materialVideo = new MaterialVideo(
                                        temporalContainer.get("Signatura"),
                                        Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                        temporalContainer.get("Tema"),
                                        temporalContainer.get("Formato"),
                                        Double.parseDouble(temporalContainer.get("DuracionSegundos")),
                                        temporalContainer.get("Idioma"),
                                        temporalContainer.get("Director"));
                                materiales.add(materialVideo);
                                objUsuario.asignarFechaPrestamo(LocalDate.parse(fechaPrestamo));
                                objUsuario.agregarMaterial(materialVideo);
                            } else if (analysis_line_data[analysis_line_data.length - 1].equalsIgnoreCase("TipoMaterial:Audio")) {
                                for (String e : analysis_line_data) {
                                    String[] material_arr = e.split(":");
                                    temporalContainer.put(material_arr[0], material_arr[1]);
                                }
                                MaterialAudio materialAudio = new MaterialAudio(
                                        temporalContainer.get("Signatura"),
                                        Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                        temporalContainer.get("Tema"),
                                        temporalContainer.get("Formato"),
                                        Double.parseDouble(temporalContainer.get("DuracionSegundos")),
                                        temporalContainer.get("Idioma"));
                                materiales.add(materialAudio);
                                objUsuario.asignarFechaPrestamo(LocalDate.parse(fechaPrestamo));
                                objUsuario.agregarMaterial(materialAudio);
                            } else if (analysis_line_data[analysis_line_data.length - 1].equalsIgnoreCase("TipoMaterial:Texto")) {
                                for (String e : analysis_line_data) {
                                    String[] material_arr = e.split(":");
                                    temporalContainer.put(material_arr[0], material_arr[1]);
                                }
                                MaterialTexto materialTexto = new MaterialTexto(
                                        temporalContainer.get("Signatura"),
                                        Boolean.parseBoolean(temporalContainer.get("Restringido")),
                                        temporalContainer.get("Tema"),
                                        temporalContainer.get("Titulo"),
                                        temporalContainer.get("NombreAutor"),
                                        LocalDate.parse(temporalContainer.get("FechaPublicacion")),
                                        Integer.parseInt(temporalContainer.get("CantidadPaginas")),
                                        temporalContainer.get("Idioma"));
                                materiales.add(materialTexto);
                                objUsuario.asignarFechaPrestamo(LocalDate.parse(fechaPrestamo));
                                objUsuario.agregarMaterial(materialTexto);
                            } else if (analysis_line_data[analysis_line_data.length - 1].equalsIgnoreCase("TipoMaterial" +
                                    ":Otro")) {
                                for (String e : analysis_line_data) {
                                    String[] material_arr = e.split(":");
                                    temporalContainer.put(material_arr[0], material_arr[1]);
                                }
                                MaterialOtro materialOtro = new MaterialOtro(
                                        temporalContainer.get("Signatura"),
                                        temporalContainer.get("Descripcion"));
                                materiales.add(materialOtro);
                                objUsuario.asignarFechaPrestamo(LocalDate.parse(fechaPrestamo));
                                objUsuario.agregarMaterial(materialOtro);
                            }
                        }
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}