package cr.ac.ucenfotec.BL.DAO;

import cr.ac.ucenfotec.BL.User.IAdministrator;
import cr.ac.ucenfotec.BL.User.MySQLAdministratorDAO;

public class MySQLServerDAOFactory extends DAOFactory {

    @Override
    public IAdministrator getAdministratorDao() {
        return new MySQLAdministratorDAO();
    }
}
