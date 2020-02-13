public class Controller {
    public LogicLayer logicLayer = new LogicLayer();
    public double calculateAddition(double[] numbers){
        return logicLayer.add(numbers[0], numbers[1]);
    }
    public double calculateSubtraction(double[] numbers){
        return logicLayer.subtraction(numbers[0], numbers[1]);
    }
    public double calculateProduct(double[] numbers){
        return logicLayer.multiplication(numbers[0], numbers[1]);
    }
    public double calculateDivision(double[] numbers){
        return logicLayer.division(numbers[0], numbers[1]);
    }
    public double calculateSquareRoot(double number){
        return logicLayer.squareRoot(number);
    }
}
