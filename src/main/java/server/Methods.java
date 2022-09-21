package server;

public class Methods {
    public double suma (double num1, double num2) {
    double result=num1+num2;
    return result;
    }
    public double resta (double num1, double num2) {
        double result = num1-num2;
        return result;
    }
    public double mul (double num1, double num2) {
        double result = num1*num2;
        return result;
    }
    public double div (double num1, double num2) {
        double result = num1 / num2;
        return result;
    }
    public double exp (double num1, double num2) {
        double result = Math.pow(num1,num2);
        return result;
    }
    public double raiz (double num1){
        if (num1<0) {
            System.out.println("No se puede con numeros negativos");
            return 0;
        }
        double result = Math.sqrt(num1);
        return result;
    }
}
