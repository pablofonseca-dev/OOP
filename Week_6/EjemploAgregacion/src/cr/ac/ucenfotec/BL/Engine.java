package cr.ac.ucenfotec.BL;

public class Engine {

    private String serialNumber;
    private int cylindersAmount;

    //Initialize the attributes

    //Default Constructor
    public Engine(){
        serialNumber = "";
        cylindersAmount =  0;
    }

    public Engine(String serialNumber, int cylindersAmount){
        this.serialNumber = serialNumber;
        this.cylindersAmount = cylindersAmount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getCylindersAmount() {
        return cylindersAmount;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCylindersAmount(int cylindersAmount) {
        this.cylindersAmount = cylindersAmount;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "serialNumber='" + serialNumber + '\'' +
                ", cylindersAmount=" + cylindersAmount +
                '}';
    }
}
