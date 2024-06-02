
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        GetExchange getExchange = new GetExchange();
        Exchange convertMoney;

        Locale ptBr = new Locale("pt", "BR");
        Locale enUs = new Locale("en", "US");
        Locale euro = new Locale("de", "DE");

        NumberFormat brlFormat = NumberFormat.getCurrencyInstance(ptBr);
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(enUs);
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(euro);

        String lastDate = "";
        String nextDate = "";
        DateTimeFormatter rfcFormattter = DateTimeFormatter.RFC_1123_DATE_TIME;
        LocalDateTime lastDateTime;
        LocalDateTime nextDateTime;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy HH:mm:ss", ptBr);
        String lastUpdate;
        String nextUpdate;



        boolean state = false;

        while (!state) {

            System.out.println("Menu da conversão");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. Converter de USD - Dólar -> BRL - Real Brasileiro");
            System.out.println("2. Converter de BRL - Real Brasileiro -> USD - Dólar");
            System.out.println("3. Converter de EUR - Euro -> BRL - Real Brasileiro");
            System.out.println("4. Converter de BRL - Real Brasileiro -> EUR - Euro");
            System.out.println("5. Sair");
            System.out.println("-----------------------------------------------------------");

            System.out.println("");
            System.out.println("Escolha uma opção: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o valor para conversão: ");
                    float dolarBrl = scanner.nextFloat();
                    System.out.println("");
                    System.out.println("Dados da conversão");
                    System.out.println("--------------------------");
                    convertMoney = getExchange.getConversion("USD", "BRL", dolarBrl);
                    System.out.println("Valor base: " + usFormat.format(dolarBrl));
                    System.out.println("Resultado da conversão:" + brlFormat.format(convertMoney.conversion_result()));

                    lastDate = convertMoney.time_last_update_utc();
                    nextDate = convertMoney.time_next_update_utc();

                    lastDateTime = LocalDateTime.parse(lastDate, rfcFormattter);
                    lastUpdate = lastDateTime.format(outputFormatter);

                    nextDateTime = LocalDateTime.parse(nextDate, rfcFormattter);
                    nextUpdate = nextDateTime.format(outputFormatter);


                    System.out.println("Última atualização: " + lastUpdate);
                    System.out.println("Próxima atualização: " + nextUpdate);
                    System.out.println("");
                    System.out.println("");

                    break;
                case 2:
                    System.out.println("Digite o valor para conversão: ");
                    float brlDolar = scanner.nextFloat();
                    convertMoney = getExchange.getConversion("BRL", "USD", brlDolar);
                    System.out.println("Valor base: " + brlFormat.format(brlDolar));
                    System.out.println("Resultado da conversão:" + usFormat.format(convertMoney.conversion_result()));

                    lastDate = convertMoney.time_last_update_utc();
                    nextDate = convertMoney.time_next_update_utc();

                    lastDateTime = LocalDateTime.parse(lastDate, rfcFormattter);
                    lastUpdate = lastDateTime.format(outputFormatter);

                    nextDateTime = LocalDateTime.parse(nextDate, rfcFormattter);
                    nextUpdate = nextDateTime.format(outputFormatter);


                    System.out.println("Última atualização: " + lastUpdate);
                    System.out.println("Próxima atualização: " + nextUpdate);
                    System.out.println("");
                    System.out.println("");

                    break;
                case 3:
                    System.out.println("Digite o valor para conversão: ");
                    float euroBrl = scanner.nextFloat();
                    convertMoney = getExchange.getConversion("EUR", "BRL", euroBrl);
                    System.out.println("Valor base: " + euroFormat.format(euroBrl));
                    System.out.println("Resultado da conversão:" + brlFormat.format(convertMoney.conversion_result()));

                    lastDate = convertMoney.time_last_update_utc();
                    nextDate = convertMoney.time_next_update_utc();

                    lastDateTime = LocalDateTime.parse(lastDate, rfcFormattter);
                    lastUpdate = lastDateTime.format(outputFormatter);

                    nextDateTime = LocalDateTime.parse(nextDate, rfcFormattter);
                    nextUpdate = nextDateTime.format(outputFormatter);


                    System.out.println("Última atualização: " + lastUpdate);
                    System.out.println("Próxima atualização: " + nextUpdate);
                    System.out.println("");
                    System.out.println("");

                    break;
                case 4:
                    System.out.println("Digite o valor para conversão: ");
                    float brlEuro = scanner.nextFloat();
                    convertMoney = getExchange.getConversion("BRL", "EUR", brlEuro);
                    System.out.println("Valor base: " + brlFormat.format(brlEuro));
                    System.out.println("Resultado da conversão:" + euroFormat.format(convertMoney.conversion_result()));

                    lastDate = convertMoney.time_last_update_utc();
                    nextDate = convertMoney.time_next_update_utc();

                    lastDateTime = LocalDateTime.parse(lastDate, rfcFormattter);
                    lastUpdate = lastDateTime.format(outputFormatter);

                    nextDateTime = LocalDateTime.parse(nextDate, rfcFormattter);
                    nextUpdate = nextDateTime.format(outputFormatter);


                    System.out.println("Última atualização: " + lastUpdate);
                    System.out.println("Próxima atualização: " + nextUpdate);
                    System.out.println("");
                    System.out.println("");

                    break;
                case 5:
                    System.out.println("Saindo...");
                    state = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }
}