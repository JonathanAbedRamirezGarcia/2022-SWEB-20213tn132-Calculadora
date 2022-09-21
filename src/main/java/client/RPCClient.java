package client;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.getNumber;

public class RPCClient {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException {
        String opcion = "", num1 = "", num2 = "";
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        double response;

        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raíz");
            System.out.println("7. Salir");
            opcion= sc.next();

            if (isNumber(opcion)) {
                switch (Integer.parseInt(opcion)) {
                    case 1:

                    num1 = getNumber("Ingrese el primer valor");
                    num2 = getNumber("Ingrese el segundo valor");

                    //Llamada al servicio
                    response = callService(num1, num2, "Methods.suma", client);
                    System.out.println("El resultado es: " + response);

                    break;
                    case 2:

                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");


                        response = callService(num1, num2, "Methods.resta", client);
                        System.out.println("El resultado es: " + response);

                        break;
                    case 3:
                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");


                        response = callService(num1, num2, "Methods.mul", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 4:

                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");


                        response = callService(num1, num2, "Methods.div", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 5:
                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");


                        response = callService(num1, num2, "Methods.exp", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 6:
                        num1 = getNumber("Ingrese el primer valor");


                        response = callService(num1, "Methods.raiz", client);
                        System.out.println("El resultado es: " + response);
                        break;
                        }while (isNumber(num2));

                        break;
                    default:
                        System.out.println("Ingresa un valor valido");
                }
            }else {
                System.out.println("Ingresa un valor valido");
            }
        }

    private static double callService(double num1,double num2, String method, XmlRpcClient client) throws XmlRpcException {
        Object[] numbers = {num1, num2};
        return (Double) client.execute(method, numbers);
    }
    public static double callService(double num1, String method, XmlRpcClient client) throws XmlRpcException, XmlRpcException {
        Object[] numbers = {num1};
        return (Double) client.execute(method, numbers);
    }
}
