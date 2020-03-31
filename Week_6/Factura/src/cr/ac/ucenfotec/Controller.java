package cr.ac.ucenfotec;

public class Controller {

    LogicLayer logicLayer = new LogicLayer();

    public void addBill(String number, String client, double tax) {
        this.logicLayer.addBill(number, client, tax);
    }

    public void addBillDate(int day, int month, int year){
        this.logicLayer.addBillDate(day, month, year);
    }

    public void addLine(int quantity, String code, int price, String description){
        this.logicLayer.addLine(quantity, code, price, description);
    }

    public String[] outputBills(){
        return logicLayer.outputBills();
    }

}
