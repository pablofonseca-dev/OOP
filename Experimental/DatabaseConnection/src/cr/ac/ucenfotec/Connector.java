package cr.ac.ucenfotec;

import javax.swing.*;
public class Connector{

    private static DBAccess connectorBD = null;

    public static DBAccess getConnector(){

        if(connectorBD==null){
            try {
                String[] propertiesReader;
                PropertyValuesListener propertiesInstance = new PropertyValuesListener();
                propertiesReader = propertiesInstance.getPropValues();
                connectorBD = new DBAccess(
                        propertiesReader[0],
                        propertiesReader[1]
                );
                JOptionPane.showMessageDialog(null, "Connected to DB");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return connectorBD;
    }

}