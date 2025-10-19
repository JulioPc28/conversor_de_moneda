package main.java.conversor;

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
    }
}