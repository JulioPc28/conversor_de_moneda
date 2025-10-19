package main.java.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {
    private final ApiService apiService = new ApiService();

    public void convertir(int opcion, double monto) {
        String base = "", destino = "";

        switch (opcion) {
            case 1 -> { base = "USD"; destino = "ARS"; }
            case 2 -> { base = "ARS"; destino = "USD"; }
            case 3 -> { base = "USD"; destino = "BRL"; }
            case 4 -> { base = "BRL"; destino = "USD"; }
            case 5 -> { base = "EUR"; destino = "USD"; }
            case 6 -> { base = "USD"; destino = "COP"; }
            case 7 -> { base = "COP"; destino = "USD"; }
        }

        double resultado = apiService.obtenerConversion(base, destino, monto);
        System.out.printf("El valor de %.2f %s corresponde a %.2f %s%n", monto, base, resultado, destino);

        RespuestaConversion respuesta = apiService.obtenerConversionJson(base, destino, monto);
        if (respuesta != null) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(respuesta);
            System.out.println("Respuesta en formato JSON:");
            System.out.println(json);

            // Guardar en archivo
            File carpeta = new File("conversiones");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            String timestamp = java.time.LocalDateTime.now().toString().replace(":", "-");
            String nombreArchivo = "conversion_" + base + "_a_" + destino + "_" + timestamp + ".json";
            File archivo = new File(carpeta, nombreArchivo);

            try (FileWriter writer = new FileWriter(archivo)) {
                writer.write(json);
                System.out.println("✅ Resultado guardado en: " + archivo.getPath());
            } catch (IOException e) {
                System.out.println("❌ Error al guardar el archivo: " + e.getMessage());
            }
        }


    }
}