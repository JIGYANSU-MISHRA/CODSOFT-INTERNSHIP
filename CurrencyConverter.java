import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("You want to change currency From: ");
        String convertFrom = scanner.nextLine().toUpperCase();
        System.out.print("You want to change currency To: ");
        String convertTo = scanner.nextLine().toUpperCase();
        System.out.print("Type Amount: ");
        double quantity = scanner.nextDouble();

        String urlString = "https://api.exchangerate-api.com/v4/latest/" + convertFrom;

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Extracting exchange rate
        double rate = extractRate(response.toString(), convertTo);

        double result = rate * quantity;
        System.out.println("The conversion amount is: "+result);
    }

    public static double extractRate(String response, String targetCurrency) {
        int idx = response.indexOf(targetCurrency);
        if (idx == -1) {
            return -1; // Target currency not found in the response
        }
        int rateIdx = response.indexOf(":", idx);
        int endIdx = response.indexOf(",", rateIdx);
        String rateStr = response.substring(rateIdx + 1, endIdx).trim();
        return Double.parseDouble(rateStr);
    }
}
