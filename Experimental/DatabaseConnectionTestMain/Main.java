package cr.ac.ucenfotec;

import java.sql.ResultSet;

public class Main {

    private static java.sql.ResultSet ResultSet;

    public static void main(String[] args) throws Exception {
	// write your code here
        printWorkers("Tommy", "Lee");
    }

    public static String printWorkers(String firstName, String lastName){
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
}
