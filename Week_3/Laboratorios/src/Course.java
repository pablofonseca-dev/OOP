public class Course {
    //Object Attributes
    private String code;
    private String name;
    private int credits;

    //Object Default Constructor
    public Course(){
        this.code = "";
        this.name = "";
        this.credits = 0;
    }

    //Object Complete Constructor
    public Course(String name, int credits){
        this.code = generateCourseCode();
        this.name = name;
        this.credits = credits;
    }

    //Object Setter Access Methods
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    //Object Getter Access Methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    private String generateCourseCode(){
        CodeGen codeGenerator = new CodeGen();
        String code = String.valueOf(codeGenerator.generateAlphaCode(7));
        return code;
    }
    //Object To String Overridden Method
    public String toString(){
        return  "Nombre: " + this.name + "\n" +
                "Código: " + this.code + "\n" +
                "Cantidad de Créditos: " + this.credits + "\n";
    }
}
