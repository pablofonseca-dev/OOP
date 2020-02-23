package cr.ac.ucenfotec;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyValuesListener {

    //Attributes
    String result = "";
    private InputStream inputStream;
    private String fullStringConnection = "";
    private String setDriver = "";
    private String[] resultArray = null;

    public String[] getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "./cr/ac/ucenfotec/connection.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            //get the property value and print it out
            String driver = prop.getProperty("driver");
            String host = prop.getProperty("host");
            String database = prop.getProperty("database");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            String instance = prop.getProperty("instance");
//                fullStringConnection += host + database + ";" + "instance=" + instance + ";" + "DatabaseName=" + database +
//                        ";" + "user=" + user + ";" + "password=" + password;
            fullStringConnection += host + database + "?" + "user=" + user + "&" + "password=" + password;
            setDriver += driver;

            //Initializing the array
            resultArray = new String[2];
            //Add elements to array
            resultArray[0] = setDriver;
            resultArray[1] = fullStringConnection;
        } catch (Exception ExceptionData) {
            System.out.println(ExceptionData.getMessage());
        }finally {
            if(inputStream != null) {
                inputStream.close();
            }
        }
        return resultArray;
    }
}

