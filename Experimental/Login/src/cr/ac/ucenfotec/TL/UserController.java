package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.DAO.DAOFactory;
import cr.ac.ucenfotec.BL.User.IWorker;
import cr.ac.ucenfotec.BL.User.Worker;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController extends Controller{
    /**
     * Este método va a obtener los datos del trabajador que está deseando iniciar sesión.
     * @author Pablo Fonseca Moncada
     */
    public void printWorkers(){
        try{
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQLServer);
            IWorker workerInterface = factory.getWorkerDao();
            ArrayList<Worker> workerArrayList = workerInterface.printAllWorkers();
            for(Worker e: workerArrayList){
                System.out.println(e.toString());
            }
        }catch(NullPointerException nullPointerException){
            nullPointerException.getMessage();
        }catch(Exception other){
            other.printStackTrace();
        }
    }
}
