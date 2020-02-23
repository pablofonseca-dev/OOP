package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.Computer;
import cr.ac.ucenfotec.BL.Employee;
import cr.ac.ucenfotec.DL.LogicLayer;

public class Controller {

    private LogicLayer logicLayer;
    public Controller(){
        logicLayer = new LogicLayer();
    }

    public void logComputer(String brand, String serialCode){
        Computer temporalComputer = new Computer(brand, serialCode);
        logicLayer.logComputer(temporalComputer);
    }

    public void logComputer(String brand, String serialCode, String name, String identification){
        Employee temporalEmployee = new Employee(name, identification);
        Computer temporalComputer = new Computer(brand, temporalEmployee, serialCode);
        logicLayer.logComputer(temporalComputer);
    }
    public void logEmployee(String name, String identification){
        Employee temporalEmployee = new Employee(name, identification);
        logicLayer.logEmployee(temporalEmployee);
    }

    public String[] listComputer(){
        return logicLayer.getComputers();
    }

    public String[] listEmployees(){
        return logicLayer.getEmployees();
    }

    public Boolean validateResponsibleExistence(String name, String identification){
        return logicLayer.validateResponsibleExistenceLogic(name, identification);
    }
}
