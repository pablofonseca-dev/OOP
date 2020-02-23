package cr.ac.ucenfotec.DL;

import cr.ac.ucenfotec.BL.Computer;
import cr.ac.ucenfotec.BL.Employee;

import java.util.ArrayList;


public class LogicLayer {
    private ArrayList<Computer> computersArrayList;
    private ArrayList<Employee> employeesArrayList;
    public LogicLayer(){
        this.computersArrayList = new ArrayList<>();
        this.employeesArrayList = new ArrayList<>();
    }

    public void logEmployee(Employee employee){
        this.employeesArrayList.add(employee);
    }

    public void logComputer(Computer computer){
        this.computersArrayList.add(computer);
    }

    public String[] getComputers(){
        String[] computersQueueCopy = new String[computersArrayList.size()];
        int position = 0;
        for(Computer computer: computersArrayList){
            computersQueueCopy[position] = computer.toString();
            position++;
        }
        return computersQueueCopy;
    }

    public String[] getEmployees(){
        String[] employeesQueueCopy = new String[employeesArrayList.size()];
        int position = 0;
        for(Employee employee: employeesArrayList){
            employeesQueueCopy[position] = employee.toString();
            position++;
        }
        return employeesQueueCopy;
    }

}
