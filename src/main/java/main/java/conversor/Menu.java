package main.java.conversor;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Conversor conversor = new Conversor();

    public void iniciar() {
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("\nBienvenido al Conversor de Monedas");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Dólar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Euro a Dólar");
            System.out.println("6. Dólar a Peso Colombiano");
            System.out.println("7. Peso Colombiano a Dólar");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("Ingresa el monto a convertir: ");
                double monto = scanner.nextDouble();
                conversor.convertir(opcion, monto);
            } else if (opcion == 8) {
                System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
            } else {
                System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }
}