package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.*;
import cr.ac.ucenfotec.DL.DataAccess;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    DataAccess dataAccess;

    public Controller(){
     dataAccess = new DataAccess();
    }

    public void registrarEstudiante(String nombre, String primerApellido, String segundoApellido, String carne, String carrera,
                                    int creditos){
        Estudiante estudiante = new Estudiante(nombre, primerApellido, segundoApellido, carne, carrera, creditos);
        dataAccess.registrarEstudiante(estudiante);
    }

    public void registrarProfesor(String nombre, String primerApellido, String segundoApellido, String cedula,
                                  String tipoContrato, LocalDate fechaContratacion){
        Profesor profesor = new Profesor(nombre, primerApellido, segundoApellido, cedula, tipoContrato,
                fechaContratacion);
        dataAccess.registrarProfesor(profesor);
    }

    public void registrarAdministrativo(String nombre, String primerApellido, String segundoApellido, String cedula,
                                        char tipoNombramiento, int horasSemanales){
        Administrativo administrativo = new Administrativo(nombre, primerApellido, segundoApellido, cedula,
                tipoNombramiento, horasSemanales);
        dataAccess.registrarAdministrativo(administrativo);
    }

    public void registrarMaterialVideo(String signatura, boolean restringido, String tema, String formato,
                                       double duracionSegundos, String idioma, String director){
        MaterialVideo video = new MaterialVideo(signatura, restringido, tema, formato, duracionSegundos, idioma,
                director);
        dataAccess.registrarMaterialVideo(video);
    }

    public boolean validarExistenciaMaterial(String signatura){
        return dataAccess.validarSignaturaMaterial(signatura);
    }

    public void realizarPrestamo(String identificacion, String signatura){
        dataAccess.agregarPrestamoMaterial(identificacion, signatura);
    }


    public void registrarMaterialAudio(String signatura, boolean restringido, String tema, String formato,
                                       double duracionSegundos){
        MaterialAudio materialAudio = new MaterialAudio(signatura, restringido, tema, formato, duracionSegundos);
        dataAccess.registrarMaterialAudio(materialAudio);
    }

    public void registrarMaterialAudio(String signatura, boolean restringido, String tema, String formato,
                                       double duracionSegundos, String idioma){
        MaterialAudio materialAudio = new MaterialAudio(signatura, restringido, tema, formato, duracionSegundos,
                idioma);
        dataAccess.registrarMaterialAudio(materialAudio);
    }

    public void registrarMaterialTexto(String signatura, boolean restringido, String tema, String titulo,
                                       String nombreAutor,
                                       LocalDate fechaPublicacion, int cantidadPaginas, String idioma){
        MaterialTexto materialTexto = new MaterialTexto(signatura, restringido, tema, titulo, nombreAutor,
                fechaPublicacion, cantidadPaginas, idioma);
        dataAccess.registrarMaterialTexto(materialTexto);
    }

    public void registrarMaterialIndefinido(String signatura, String descripcion){
        MaterialOtro materialOtro = new MaterialOtro(signatura, descripcion);
        dataAccess.registrarMaterialIndefinido(materialOtro);
    }

    public ArrayList<String> obtenerEstudiantes(){
        ArrayList<Usuario> estudiantes = dataAccess.obtenerUsuarios(DataAccess.ESTUDIANTE);
        ArrayList<String> copia =  new ArrayList<>();
        for(Usuario e: estudiantes){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerProfesores(){
        ArrayList<Usuario> profesores = dataAccess.obtenerUsuarios(DataAccess.PROFESOR);
        ArrayList<String> copia =  new ArrayList<>();
        for(Usuario e: profesores){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerAdministrativos(){
        ArrayList<Usuario> administrativo = dataAccess.obtenerUsuarios(DataAccess.ADMINISTRATIVO);
        ArrayList<String> copia =  new ArrayList<>();
        for(Usuario e: administrativo){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerMaterialVideo(){
        ArrayList<Material> materialVideos = dataAccess.obtenerMateriales(DataAccess.VIDEO);
        ArrayList<String> copia =  new ArrayList<>();
        for(Material e: materialVideos){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerMaterialTexto(){
        ArrayList<Material> materialTexto = dataAccess.obtenerMateriales(DataAccess.TEXTO);
        ArrayList<String> copia =  new ArrayList<>();
        for(Material e: materialTexto){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerMaterialAudio(){
        ArrayList<Material> materialAudio = dataAccess.obtenerMateriales(DataAccess.AUDIO);
        ArrayList<String> copia =  new ArrayList<>();
        for(Material e: materialAudio){
            copia.add(e.toString());
        }
        return copia;
    }

    public ArrayList<String> obtenerMaterialIndefinido(){
        ArrayList<Material> materialOtro = dataAccess.obtenerMateriales(DataAccess.OTRO);
        ArrayList<String> copia =  new ArrayList<>();
        for(Material e: materialOtro){
            copia.add(e.toString());
        }
        return copia;
    }

    public boolean validarExistenciaIdentificacion(String identificacion){
        if(dataAccess.validarIdentificacionUsuario(identificacion)){
            return true;
        }else{
            return false;
        }
    }



}
