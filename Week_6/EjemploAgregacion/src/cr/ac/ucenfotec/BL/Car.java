package cr.ac.ucenfotec.BL;

import cr.ac.ucenfotec.BL.Engine;

public class Car {
    private String serialNumber;
    private String brand;
    private Engine temporalEngine;

    public Car(){
        this.serialNumber = "";
        this.brand = "";
        this.temporalEngine = null;
    }

    public Car(String serialNumber, String brand) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        //Business Rule
        //All cars need to implement a engine with the same serial Number.
        temporalEngine = new Engine(serialNumber, 4);
    }

    public Car(String serialNumber, String brand, Engine temporalEngine) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.temporalEngine = temporalEngine;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getTemporalEngine() {
        return temporalEngine;
    }

    public void setTemporalEngine(Engine temporalEngine) {
        this.temporalEngine = temporalEngine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", temporalEngine=" + temporalEngine.toString() +
                '}';
    }

}
