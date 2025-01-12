import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetExchange {

    public Exchange getConversion(String convertIn, String convertOut, float value) {
        String apiKey = System.getenv("API_KEY");
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + convertIn + "/"+ convertOut +"/" + value);

        //HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("erro");
        }
    }
}
