/**
 * This file save the laboratories data
 */

public class LogicLayer {
    static String[] laboratoriesQueue;
    static int counter = 0;
    static int globalQueueSize = 0;
    public static void initializeLaboratoriesQueue(int size){
        laboratoriesQueue = new String[size];
        globalQueueSize = size;
    }
    public static boolean logLaboratory(String concatenatedData){
        if(counter < laboratoriesQueue.length) {
            laboratoriesQueue[counter] = concatenatedData;
            counter++;
            return true;
        }else{
            return false;
        }
    }
    public static String[] getLaboratoriesQueue(){
        String[] laboratoriesQueueBackup = new String[globalQueueSize];
        for(int index = 0; index < laboratoriesQueueBackup.length; index++){
            laboratoriesQueueBackup[index] = laboratoriesQueue[index];
        }
        return laboratoriesQueue;
    }

    public static String getStringLab(){
        String data = "";
        for(int index = 0; index < laboratoriesQueue.length; index++){
            data += laboratoriesQueue[index];
        }
        return data;
    }
}
