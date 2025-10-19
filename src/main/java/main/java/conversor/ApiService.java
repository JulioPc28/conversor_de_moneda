package main.java.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    private final String API_KEY = "2105a5f44d9b07731a2840de";

    public double obtenerConversion(String base, String destino, double monto) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            double rate = json.get("conversion_rate").getAsDouble();
            return monto * rate;

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return 0;
        }
    }



    public RespuestaConversion obtenerConversionJson(String base, String destino, double monto) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            double rate = json.get("conversion_rate").getAsDouble();
            double resultado = monto * rate;

            return new RespuestaConversion(base, destino, monto, rate, resultado);

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}