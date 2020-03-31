package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.DAO.DAOFactory;
import cr.ac.ucenfotec.BL.User.IAdministrator;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController extends Controller{
    public UserController(){

    }

    public boolean logAdministrator(String firstName, String password, String email){
        boolean procedureCorrect = false;
        try{
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQLServer);
            assert factory != null;
            IAdministrator administrator = factory.getAdministratorDao();
            procedureCorrect = administrator.signUpAdministrator(firstName, password, email);
        }catch(Exception exception){
            exception.printStackTrace();
            procedureCorrect = false;
        }
        return procedureCorrect;
    }

    public boolean validateAdministratorExistence(){
        boolean procedureCorrect = false;
        try{
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQLServer);
            assert factory != null;
            IAdministrator administrator = factory.getAdministratorDao();
            procedureCorrect = administrator.validateAdministratorExistence();
        }catch(Exception exception){
            exception.printStackTrace();
            procedureCorrect = false;
        }
        return procedureCorrect;
    }

    public boolean validateAdministratorCredentials(String email, String password){
        boolean procedureCorrect = false;
        try{
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQLServer);
            assert factory != null;
            IAdministrator administrator = factory.getAdministratorDao();
            procedureCorrect = administrator.validateCredentials(email, password);
        }catch(Exception exception){
            exception.printStackTrace();
            procedureCorrect = false;
        }
        return procedureCorrect;
    }
}
