package cr.ac.ucenfotec.BL.DAO;

import cr.ac.ucenfotec.BL.User.IWorker;
import cr.ac.ucenfotec.BL.User.MySQLWorkerDAO;

public class MySQLServerDAOFactory extends DAOFactory {

    @Override
    public IWorker getWorkerDao() {
        return new MySQLWorkerDAO();
    }
}
