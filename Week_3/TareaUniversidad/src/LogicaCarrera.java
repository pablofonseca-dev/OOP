public class LogicaCarrera {
    static String[] careersQueue = null;
    static int queueIndexCounter = 0;
    static int queueSize = 0;

    static void initializeCareersQueue(int careerQueueSize){
        careersQueue = new String[careerQueueSize];
        queueSize = careerQueueSize;
    }

    static boolean logCareer(String concatenatedData){
        if(queueIndexCounter < queueSize){
            careersQueue[queueIndexCounter] = concatenatedData;
            queueIndexCounter++;
            return true;
        }else{
            return false;
        }
    }

    static String[] getCareerQueueCopy(){
        String[] backup = new String[queueSize];
        for(int index = 0; index < queueSize; index++){
            backup[index] = careersQueue[index];
        }
        return backup;
    }
}
