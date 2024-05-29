
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor: ");
        float value = scanner.nextFloat();
        GetExchange getExchange = new GetExchange();

        try {
            Exchange newExchange = getExchange.getConversion(value);
            System.out.println(newExchange);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("finalizando aplicação");
        }
    }
}