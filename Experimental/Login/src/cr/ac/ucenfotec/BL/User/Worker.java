package cr.ac.ucenfotec.BL.User;

public class Worker extends User{

    private String email;
    private String job;

    //Default Constructor
    public Worker(){
        super();
        this.email = "";
        this.job = "";
    }

    //Basic Constructor
    public Worker(String firstName, String surName, String lastName, String email, String job) {
        super(firstName, surName, lastName);
        this.email = email;
        this.job = job;
    }

    //Getters
    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    //Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        String formatter = "";
        formatter = "Nombre: " + this.getFirstName() + "\n";
        formatter += "Primer Apellido: " + this.getSurName() + "\n";
        formatter += "Segundo Apellido: " + this.getLastName() + "\n";
        formatter += "Correo Electrónico: " + this.email + "\n";
        formatter += "Puesto: " + this.job + "\n";
        return formatter;

    }
}
