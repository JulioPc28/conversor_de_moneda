package main.java.conversor;

public class RespuestaConversion {
    private String moneda_origen;
    private String moneda_destino;
    private double monto_original;
    private double tasa_conversion;
    private double monto_convertido;

    public RespuestaConversion(String moneda_origen, String moneda_destino, double monto_original, double tasa_conversion, double monto_convertido) {
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.monto_original = monto_original;
        this.tasa_conversion = tasa_conversion;
        this.monto_convertido = monto_convertido;
    }
}