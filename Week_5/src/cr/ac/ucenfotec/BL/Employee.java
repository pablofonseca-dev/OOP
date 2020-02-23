package cr.ac.ucenfotec.BL;

public class Employee {
    private String name;
    private String identification;

    public Employee(String name, String identification){
        this.name = name;
        this.identification = identification;
    }
    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                '}' ;
    }
}
