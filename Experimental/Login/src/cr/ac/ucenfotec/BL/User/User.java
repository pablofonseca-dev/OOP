package cr.ac.ucenfotec.BL.User;

import java.time.LocalDate;

public class User {
    protected String firstName;
    protected String password;
    protected String email;
    protected int databaseID;


    //Default Constructor
    public User() {
        this.firstName = "";
        this.password = "";
        this.email = "";
    }

    //Complete Constructor

    public User(String firstName, String password, String email) {
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }


    //Basic Constructor

    //Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre").append(" ").append(firstName).append("\n");
        builder.append("Correo Eletrónico").append(" ").append(email).append("\n");
        builder.append("Clave de Seguridad").append(" ").append(password).append("\n");
        if(databaseID != 0) {
            builder.append("ID en la Base de Datos").append(" ").append(databaseID).append("\n");
        }
        return builder.toString();
    }
}
