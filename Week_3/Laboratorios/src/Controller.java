import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    LogicLayer logicLayer;
    //Default Constructor
    public Controller(){
        logicLayer = new LogicLayer();
    }

    public void requestLogLaboratory(String name, int capacity, String course){
        logicLayer.logLaboratory(name, capacity, course);
    }

    public void requestLogStudent(String name, String lastName, String identification, Boolean isScholarship){
        logicLayer.logStudent(name, lastName, identification, isScholarship);
    }

    public void requestLogStudentComplete(String name, String lastName, String identification,
                                          Boolean isScholarship, LocalDate birthday){
        logicLayer.logStudentComplete(name, lastName, identification, isScholarship, birthday);
    }

    public void requestLogCourse(String name, int credits){
        logicLayer.logCourse(name, credits);
    }

    public String[] requestStudents(){
        return logicLayer.getStudentsListBackup();
    }

    public String[] requestLaboratories(){
        return logicLayer.getLaboratoriesListBackup();
    }

    public String[] requestCourses(){
        return logicLayer.getCoursesListBackup();
    }
}
