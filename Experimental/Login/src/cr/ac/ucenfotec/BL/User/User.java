package cr.ac.ucenfotec.BL.User;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String surName;
    private String lastName;
    private String identification;
    private int databaseID;
    private String country;
    private LocalDate birthday;
    private int age;
    private String motherLanguage;

    //Default Constructor
    public User() {
        this.firstName = "";
        this.surName = "";
        this.lastName = "";
        this.identification = "";
        this.databaseID = 0;
        this.country = "";
        this.birthday = LocalDate.now();
        this.age = 0;
        this.motherLanguage = "";
    }

    //Basic Constructor
    public User(String firstName, String surName, String lastName) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
    }

    //Getters

    public String getFirstName() {
        return firstName;
    }

    public String getSurName(){
        return surName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    //Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName){
        this.surName = surName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    //To String
    @Override
    public String toString(){
        String formatter = "";
        formatter = "Nombre: " + firstName + "\n";
        formatter += "Primer Apellido: " + surName + "\n";
        formatter += "Segundo Apellido: " + lastName + "\n";
        return formatter;
    }
}
