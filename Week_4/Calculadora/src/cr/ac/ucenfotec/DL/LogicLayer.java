package cr.ac.ucenfotec.DL;

public class LogicLayer {
    public double add(double numberOne, double numberTwo){
        double addition;
        addition = numberOne + numberTwo;
        return addition;
    }
    public double subtraction(double numberOne, double numberTwo){
        double subtraction;
        subtraction = numberOne - numberTwo;
        return subtraction;
    }
    public double multiplication(double numberOne, double numberTwo){
        double multiplication;
        multiplication = numberOne * numberTwo;
        return multiplication;
    }
    public double division(double numberOne, double numberTwo){
        double division;
        division = numberOne / numberTwo;
        return division;
    }
    public double squareRoot(double number){
        double squareRoot = Math.sqrt(number);
        return squareRoot;
    }
}
