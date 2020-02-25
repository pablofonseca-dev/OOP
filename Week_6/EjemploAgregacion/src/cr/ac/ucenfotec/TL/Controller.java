package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.Car;
import cr.ac.ucenfotec.BL.Engine;
import cr.ac.ucenfotec.DL.LogicLayer;

public class Controller {
    private LogicLayer logicLayer;

    public Controller(){
        this.logicLayer = new LogicLayer();
    }

    public void logEngine(String serialNumber, int cylindersAmount){
        Engine temporalEngine = new Engine(serialNumber, cylindersAmount);
        logicLayer.logEngine(temporalEngine);
    }

    public void logCar(String serialNumber, String brand){
        Car temporalCar = new Car(serialNumber, brand);
        logicLayer.logCar(temporalCar);
    }

    public void logCar(String serialNumber, String brand, String engineSerialNumber, int engineCylindersAmount){
        Car temporalCar = new Car(serialNumber, brand, new Engine(engineSerialNumber, engineCylindersAmount));
        logicLayer.logCar(temporalCar);
    }

    public boolean validateEngineExistence(String serialNumber, int cylindersAmount){
        return logicLayer.engineExistence(serialNumber, cylindersAmount);
    }

    public String[] getEngines(){
        return logicLayer.getEngines();
    }

    public String[] getCars(){
        return logicLayer.getCars();
    }


}
