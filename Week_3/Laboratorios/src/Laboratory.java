public class Laboratory {
    //Object Attributes
    private String code; //generated attribute
    private int capacity;
    private String course;
    private String name;

    //Object Default Constructor
    public Laboratory(){
        this.code = "";
        this.capacity = 0;
        this.course = "";
        this.name = "";
    }

    //Object Complete Constructor
    public Laboratory(int capacity, String course, String name){
        this.capacity = capacity;
        this.course = course;
        this.name = name;
        this.code = generateLaboratoryCode();
    }

    //Object Setter Access Methods
    private String generateLaboratoryCode(){
        CodeGen codeGenerator = new CodeGen();
        String code = String.valueOf(codeGenerator.generateAlphaCode(7));
        return code;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public void setName(String name){
        this.name = name;
    }

    //Object Getter Access Methods
    public String getCode(){
        return this.code;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getCourse(){
        return this.course;
    }

    public String getName(){
        return this.name;
    }

    //Object To String Overridden Method
    public String toString(){
        return  "Nombre: " + this.name + "\n" +
                "Código: " + this.code + "\n" +
                "Curso: " + this.course + "\n" +
                "Capacidad: " + this.capacity + "\n";
    }
}
