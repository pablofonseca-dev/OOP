/**
 * This file save the laboratories data
 */

public class LogicLayer {
    static String[] laboratoriesQueue;
    static String[] studentsQueue;
    static String[] coursesQueue;

    static int laboratories_counter = 0;
    static int students_counter = 0;
    static int courses_counter = 0;


    public static void initializeLaboratoriesQueue(int size){
        laboratoriesQueue = new String[size];
    }

    public static void initializeStudentsQueue(int size){
        studentsQueue  = new String[size];
    }

    public static void initializeCoursesQueue(int size) {coursesQueue = new String[size]; }

    public static boolean logLaboratory(String concatenatedData){
        if(laboratories_counter < laboratoriesQueue.length) {
            laboratoriesQueue[laboratories_counter] = concatenatedData;
            laboratories_counter++;
            return true;
        }else{
            return false;
        }
    }

    public static boolean logStudent(String concatenatedData){
        if(students_counter < studentsQueue.length){
            studentsQueue[students_counter] = concatenatedData;
            students_counter++;
            return true;
        }else{
            return false;
        }
    }

    public static boolean logCourse(String concatenatedData){
        if(courses_counter < coursesQueue.length){
            coursesQueue[courses_counter] = concatenatedData;
            courses_counter++;
            return true;
        }else{
            return false;
        }
    }

    public static String[] getLaboratoriesQueue(){
        String[] laboratoriesQueueBackup = new String[laboratoriesQueue.length];
        for(int index = 0; index < laboratoriesQueueBackup.length; index++){
            laboratoriesQueueBackup[index] = laboratoriesQueue[index];
        }
        return laboratoriesQueue;
    }

    public static String[] getStudentsQueue(){
        String[] studentsQueueBackup = new String[studentsQueue.length];
        for(int index = 0; index < studentsQueue.length; index++){
            studentsQueueBackup[index] = studentsQueue[index];
        }
        return studentsQueueBackup;
    }

    public static String[] getCoursesQueue(){
        String[] coursesQueueBackup = new String[coursesQueue.length];
        for(int index = 0; index < coursesQueue.length; index++){
            coursesQueueBackup[index] = coursesQueue[index];
        }
        return coursesQueueBackup;
    }

    public static String getStringLab(){
        String data = "";
        for(int index = 0; index < laboratoriesQueue.length; index++){
            data += laboratoriesQueue[index] + "\n";
        }
        return data;
    }
}
