import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
public class LogicLayer {

    private  ArrayList<Laboratory> laboratoriesList;
    private  ArrayList<Student> studentsList;
    private  ArrayList<Course> coursesList;

    private int studentsCounter;
    private int coursesCounter;
    private int laboratoriesCounter;

    //Default Constructor
    public LogicLayer(){
        laboratoriesList = new ArrayList<>();
        studentsList = new ArrayList<>();
        coursesList = new ArrayList<>();
    }
    /*
    * Creates an instance of the Laboratory class.
    * */
    public void logLaboratory(String name, int capacity, String course){
        Laboratory temporalLaboratory = new Laboratory(capacity, course, name);
        laboratoriesList.add(temporalLaboratory);
    }

    public void logStudent(String name, String lastName, String identification, Boolean isScholarship){
        Student temporalStudent = new Student(name, lastName, identification, isScholarship);
        studentsList.add(temporalStudent);
    }

    public void logStudentComplete(String name, String lastName, String identification,
                                             Boolean isScholarship, LocalDate birthday){
            Student temporalStudent = new Student(name, lastName, identification, isScholarship);
            temporalStudent.setBirthday(birthday);
            studentsList.add(temporalStudent);
    }

    public void logCourse(String name, int credits){
        Course temporalCourse = new Course(name, credits);
        coursesList.add(temporalCourse);
    }


    public String[] getLaboratoriesListBackup(){
        String[] laboratoriesStringBackup = new String[laboratoriesList.size()];
        for(int index = 0; index < laboratoriesStringBackup.length; index++){
            laboratoriesStringBackup[index] = laboratoriesList.get(index).toString();
        }
        return laboratoriesStringBackup;
    }

    public String[] getStudentsListBackup(){
        String[] studentsStringBackup = new String[studentsList.size()];
        for(int index = 0; index < studentsStringBackup.length; index++){
            studentsStringBackup[index] = studentsList.get(index).toString();
        }
        return studentsStringBackup;
    }

    public String[] getCoursesListBackup() {
        String[] coursesStringBackup = new String[coursesList.size()];
        for(int index = 0; index < coursesStringBackup.length; index++){
            coursesStringBackup[index] = coursesList.get(index).toString();
        }
        return coursesStringBackup;
    }
}
