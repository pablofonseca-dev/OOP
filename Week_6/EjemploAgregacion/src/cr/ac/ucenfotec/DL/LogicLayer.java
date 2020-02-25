package cr.ac.ucenfotec.DL;

import cr.ac.ucenfotec.BL.Car;
import cr.ac.ucenfotec.BL.Engine;

import java.util.ArrayList;

public class LogicLayer {
    private ArrayList<Engine> engineArrayList;
    private ArrayList<Car> carArrayList;

    public LogicLayer(){
        this.engineArrayList = new ArrayList<Engine>();
        this.carArrayList = new ArrayList<Car>();
    }

    public void logEngine(Engine engine){
        this.engineArrayList.add(engine);
    }

    public void logCar(Car car){
        this.carArrayList.add(car);
    }

    public String[] getEngines(){
        String[] enginesQueue = new String[this.engineArrayList.size()];
        int i = 0;
        for(Engine e: engineArrayList){
            enginesQueue[i] = e.toString();
            i++;
        }
        return enginesQueue;
    }

    public String[] getCars(){
        String[] carsQueue = new String[this.carArrayList.size()];
        int i = 0;
        for(Car e: carArrayList){
            carsQueue[i] = e.toString();
            i++;
        }
        return carsQueue;
    }

    public int getEngineIndex(String serialNumber){
        int index = 0;
        for(Engine e: engineArrayList){
            if(e.getSerialNumber().equalsIgnoreCase(serialNumber)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean engineExistence(String serialNumber, int cylindersAmount){
        for(Engine e: engineArrayList){
            if(e.getSerialNumber().equalsIgnoreCase(serialNumber) && e.getCylindersAmount() == cylindersAmount){
                return true;
            }
        }
        return false;
    }

}
