
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //float value = scanner.nextFloat();
        GetExchange getExchange = new GetExchange();

        Locale ptBr = new Locale("pt", "BR");
        Locale enUs = new Locale("en", "US");
        Locale euro = new Locale("de", "DE");

        NumberFormat brlFormat = NumberFormat.getCurrencyInstance(ptBr);
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(enUs);
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(euro);

        boolean state = false;

        while (!state) {

            System.out.println("1. Converter de USD - Dólar -> BRL - Real Brasileiro");
            System.out.println("2. Converter de BRL - Real Brasileiro -> USD - Dólar");
            System.out.println("3. Converter de EUR - Euro -> BRL - Real Brasileiro");
            System.out.println("4. Converter de BRL - Real Brasileiro -> EUR - Euro");
            System.out.println("5. Sair");

            System.out.println("");
            System.out.println("Escolha uma opção: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o valor para conversão: ");
                    float dolarBrl = scanner.nextFloat();
                    Exchange usdBrl = getExchange.getConversion("USD", "BRL", dolarBrl);
                    System.out.println("Valor base: " + usFormat.format(dolarBrl));
                    System.out.println(brlFormat.format(usdBrl.conversion_result()));
                    break;
                case 2:
                    System.out.println("Digite o valor para conversão: ");
                    float brlDolar = scanner.nextFloat();
                    Exchange realDolar = getExchange.getConversion("BRL", "USD", brlDolar);
                    System.out.println("Valor base: " + brlFormat.format(brlDolar));
                    System.out.println(usFormat.format(realDolar.conversion_result()));
                    break;
                case 3:
                    System.out.println("Digite o valor para conversão: ");
                    break;
                case 4:
                    System.out.println("Digite o valor para conversão: ");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    state = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        /*
        try {
            Exchange newExchange = getExchange.getConversion(value);
            System.out.println("Valor base: " + usFormat.format(value));
            //System.out.println("Valor base: " + euroFormat.format(value));
            System.out.println(brlFormat.format(newExchange.conversion_result()));
            //System.out.println(newExchange);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("finalizando aplicação");
        }

         */
    }
}