package cr.ac.ucenfotec.BL.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IAdministrator {
    public boolean signUpAdministrator(
            String firstName, String password, String email
    ) throws SQLException, Exception;

    public boolean validateAdministratorExistence() throws SQLException, Exception;

    public boolean validateCredentials(String email, String password) throws SQLException, Exception;

    public TreeMap<String, Administrator> listUsers() throws SQLException, Exception;


}
