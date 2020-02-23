package cr.ac.ucenfotec;

import java.sql.*;
public class DBAccess{

    private Connection conn= null;
    private Statement st;
    private CallableStatement proc;

    public DBAccess(String driver,
                    String connection) throws Exception{
        Class.forName(driver);
        conn = DriverManager.getConnection(connection);
        st = conn.createStatement();
    }

    public void executeSQL(String sentence)
            throws SQLException,Exception{
        st.execute(sentence);
    }

    public ResultSet ejecutarSQL(String sentence, boolean argReturn)
            throws SQLException,Exception{
        ResultSet rs;
        rs = st.executeQuery(sentence);
        return rs;
    }

    public void startTransaction()
            throws java.sql.SQLException{
        conn.setAutoCommit(false);
    }


    public void finishTransaction()
            throws java.sql.SQLException{
        conn.setAutoCommit(true);
    }


    public void aceptTransaction ()
            throws java.sql.SQLException{
        conn.commit();
    }

    public void removeTransaction()
            throws java.sql.SQLException{
        conn.rollback();
    }

    protected void finalize(){
        try {
            conn.close();
        }
        catch(Exception e){
        }
    }
}