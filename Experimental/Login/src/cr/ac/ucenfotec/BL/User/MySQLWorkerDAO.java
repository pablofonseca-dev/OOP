package cr.ac.ucenfotec.BL.User;

import cr.ac.ucenfotec.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLWorkerDAO implements IWorker{

    @Override
    public String printWorker(String firstName, String lastName){
        //Selection query
        String query =
                "SELECT * FROM workers WHERE First_Name='" + firstName + "'" + " AND " + " Last_Name='" + lastName +
                        "';";
        try {
            ResultSet resultSet = Connector.getConnector().ejecutarSQL(query, true);
            //If there is data.
            if(resultSet.next()){
                System.out.println("ID: " + resultSet.getString(1));
                System.out.println("First Name: " + resultSet.getString(2));
                System.out.println("Last Name: " + resultSet.getString(3));
                System.out.println("Job Title: " + resultSet.getString(4));
            }else{
                //If user not found
                System.out.println("User Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public ArrayList<Worker> printAllWorkers(){
        String query = "SELECT * FROM workers";
        try {
            ResultSet resultSet = Connector.getConnector().ejecutarSQL(query, true);
            //If there is data.
            ArrayList<Worker> workerArrayList = new ArrayList<>();
            while(resultSet.next()){
                Worker temporalWorker = new Worker();
                temporalWorker.setFirstName(resultSet.getString(2));
                temporalWorker.setLastName(resultSet.getString(3));
                temporalWorker.setJob(resultSet.getString(4));
                workerArrayList.add(temporalWorker);
            }
            return workerArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


