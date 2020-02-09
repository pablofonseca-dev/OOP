public class LogicaCurso {

    static String[] coursesQueue = null;
    static int queueIndexCounter = 0;
    static int queueSize =  0;
    static void initializeCoursesQueue(int courseQueueSize){
        coursesQueue = new String[courseQueueSize];
        queueSize = courseQueueSize;
    }

    static boolean logCourse(String concatenatedData){
        if(queueIndexCounter < queueSize){
            coursesQueue[queueIndexCounter] = concatenatedData;
            queueIndexCounter++;
            return true;
        }else{
            return false;
        }
    }

    static String[] getCourseQueueCopy(){
        String[] backup = new String[queueSize];
        for(int index = 0; index < queueSize; index++){
            backup[index] = coursesQueue[index];
        }
        return backup;
    }
}
