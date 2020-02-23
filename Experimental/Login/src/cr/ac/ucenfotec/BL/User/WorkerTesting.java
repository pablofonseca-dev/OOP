package cr.ac.ucenfotec.BL.User;

public class WorkerTesting {
    public static void main(String[] args) {
        MySQLWorkerDAO mySQLWorkerDAO = new MySQLWorkerDAO();
        mySQLWorkerDAO.printAllWorkers();
    }
}
