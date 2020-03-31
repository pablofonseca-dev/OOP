package cr.ac.ucenfotec;

import java.util.ArrayList;

public class LogicLayer {

    public static Factura temporalObject = null;



    private ArrayList<Factura> billArrayList;

    public LogicLayer(){
        this.billArrayList = new ArrayList<>();
    }

    public void addBill(String number, String client, double tax){
        temporalObject = new Factura(number, client, tax);
        this.billArrayList.add(temporalObject);
    }

    public boolean addLine(int quantity, String code, int price, String description){
        if(temporalObject != null){
            Linea temporalLine = new Linea(quantity, code, price, description);
            temporalObject.addLine(temporalLine);
            return true;
        }else{
            return false;
        }
    }

    public void addBillDate(int day, int month, int year){
        Fecha temporalDate = new Fecha(day, month, year);
        temporalObject.setDate(temporalDate);
        temporalDate.calculateCompleteDate(year, month, day);
    }

    public String[] outputBills(){
        String[] billsQueue = new String[this.billArrayList.size()];
        int index = 0;
        for(Factura e: billArrayList){
            billsQueue[index] = e.toString();
            index++;
        }
        return billsQueue;
    }

}
