package cr.ac.ucenfotec.BL.DAO;

import cr.ac.ucenfotec.BL.User.IWorker;

/**
 * Clase DaoFactory que va a contener la opciones de motores de bases de datos va a permitir
 * que se conecte
 * @author Pablo Fonseca
 * @version 1.0
 */
public abstract class DAOFactory {
    public static final int MYSQLServer = 1;

    /**
     * @author Pablo Fonseca
     * @param  DAOFactoryType : recibe el número con el que se va a saber cuál base de datos se va a utilizar
     * @return Retorna un constructor que va permitir que se realicen las conexiones con
     * MySqlServer
     */
    public static DAOFactory getDAOFactory(int DAOFactoryType){
        switch(DAOFactoryType){
            case MYSQLServer:
                return new MySQLServerDAOFactory();
            default:
                return null;
        }
    }

    /**
     * Método abstracto que permite la conexión al DAO del Trabajador
     * @author Pablo Fonseca
     * @version 1.0
     */
    public abstract IWorker getWorkerDao();
}
