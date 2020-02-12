import java.time.LocalDate;

public class LogicLayer {

    private static Student[] studentsQueue;
    private static Course[] coursesQueue;
    private static Laboratory[] laboratoriesQueue;

    private static int studentsCounter = 0;
    private static int coursesCounter = 0;
    private static int laboratoriesCounter = 0;

    public static int getCoursesCounter() {
        return coursesCounter;
    }

    public static int getStudentsCounter(){
        return studentsCounter;
    }

    public static int getLaboratoriesCounter(){
        return laboratoriesCounter;
    }

    public static void initializeLaboratoriesQueue(int size){
        laboratoriesQueue = new Laboratory[size];
    }

    public static void initializeStudentsQueue(int size){
        studentsQueue  = new Student[size];
    }

    public static void initializeCoursesQueue(int size) {
        coursesQueue = new Course[size];
    }

    /*
    * Creates an instance of the Laboratory class.
    * */
    public static boolean logLaboratory(String name, int capacity, String course){
        if(laboratoriesCounter < laboratoriesQueue.length){
            Laboratory temporalLaboratory = new Laboratory(capacity, course, name);
            laboratoriesQueue[laboratoriesCounter] = temporalLaboratory;
            laboratoriesCounter++;
            return true;
        }else{
            return false;
        }
    }

    public static boolean logStudent(String name, String lastName, String identification, Boolean isScholarship){
        if(studentsCounter < studentsQueue.length){
            Student temporalStudent = new Student(name, lastName, identification, isScholarship);
            studentsQueue[studentsCounter] = temporalStudent;
            studentsCounter++;
            return true;
        }else{
            return false;
        }
    }

    public static boolean logStudentComplete(String name, String lastName, String identification,
                                             Boolean isScholarship, LocalDate birthday){
        if(studentsCounter < studentsQueue.length){
            Student temporalStudent = new Student(name, lastName, identification, isScholarship);
            temporalStudent.setBirthday(birthday);
            studentsQueue[studentsCounter] = temporalStudent;
            studentsCounter++;
            return true;
        }else{
            return false;
        }
    }

    public static boolean logCourse(String code, String name, int credits){
        if(coursesCounter < coursesQueue.length){
            Course temporalCourse = new Course(code, name, credits);
            coursesQueue[coursesCounter] = temporalCourse;
            coursesCounter++;
            return true;
        }else{
            return false;
        }
    }


    public static String[] getLaboratoriesQueueBackup(){
        String[] laboratoriesQueueBackup = new String[laboratoriesQueue.length];
        for(int index = 0; index < laboratoriesCounter; index++){
            laboratoriesQueueBackup[index] = laboratoriesQueue[index].toString();
        }
        return laboratoriesQueueBackup;
    }

    public static String[] getStudentsQueueBackup(){
        String[] studentsQueueBackup = new String[studentsQueue.length];
        for(int index = 0; index < studentsCounter; index++){
            studentsQueueBackup[index] = studentsQueue[index].toString();
        }
        return studentsQueueBackup;
    }

    public static String[] getCoursesQueueBackup() {
        String[] coursesQueueBackup = new String[coursesQueue.length];
        for (int index = 0; index < coursesCounter; index++) {
            coursesQueueBackup[index] = coursesQueue[index].toString();
        }
        return coursesQueueBackup;
    }
}
