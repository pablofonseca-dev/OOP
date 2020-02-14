import java.time.LocalDate;
import java.time.Period;

public class Student {
    //Object Attributes
    private String name;
    private String lastName;
    private String identification;
    private LocalDate birthday;
    private Boolean isScholarship;
    private int age; // calculated value
    private String code; //dinamic value

    //Object Default Constructor
    public Student(){
        this.name = "";
        this.lastName = "";
        this.identification = "";
        this.birthday = LocalDate.now();
        this.isScholarship = false;
    }

    //Object Complete Constructor
    public Student(String name, String lastName, String identification, Boolean isScholarship){
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.isScholarship = isScholarship;
        this.code = generateCode();
    }

    //Object Setter Access Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        this.age = calculateStudentAge(birthday);
    }

    public void setScholarship(Boolean scholarship) {
        isScholarship = scholarship;
    }

    private String generateCode(){
        CodeGen codeGenerator = new CodeGen();
        String code = String.valueOf(codeGenerator.generateAlphaCode(15));
        return code;
    }

    //Object Getter Access Methods
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Boolean getScholarship() {
        return isScholarship;
    }

    public int getAge(){
        return age;
    }

    //Object To String Overridden Method
    public String toString(){
        String format;
        if(this.birthday != null){
            format = "Nombre: " + name + "\n" +
                    "Apellido: " + lastName + "\n" +
                    "Identificación: " + identification + "\n" +
                    "¿Becado o No Becado?: " + isScholarship + "\n" +
                    "Fecha de Nacimiento: " + birthday + "\n" +
                    "Edad: " + age + " años \n" +
                    "Código Generado: " + code + "\n";
        }else{
            format = "Nombre: " + name + "\n" +
                    "Apellido: " + lastName + "\n" +
                    "Identificación: " + identification + "\n" +
                    "¿Becado o No Becado?: " + isScholarship + "\n" +
                    "Código Generado: " + code + "\n";
        }
        return format;
    }

    private int calculateStudentAge(LocalDate birthday){
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthday, now);
        int age = diff.getYears();
        return age;
    }
}
