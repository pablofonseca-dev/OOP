package cr.ac.ucenfotec.BL;

public class Computer {
    private String brand;
    private Employee responsible;
    private String serialCode;

    public Computer(String brand, String serialCode) {
        this.brand = brand;
        this.serialCode = serialCode;
    }

    public Computer(String brand, Employee responsible, String serialCode) {
        this.brand = brand;
        this.responsible = responsible;
        this.serialCode = serialCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public String getResponsibleName(){
        return responsible.getName();
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    @Override
    public String toString() {
        String format;
        if(responsible == null) {
            format = "Computer{" +
                    "brand='" + brand + '\'' +
                    ", serialCode='" + serialCode + '\'' +
                    '}' ;
        }else{
            format = "Computer{" +
                    "brand='" + brand + '\'' +
                    ", serialCode='" + serialCode + '\'' +
                    ", responsible='" + responsible.toString() + '\'' +
                    '}' ;
        }
        return format;
    }
}
