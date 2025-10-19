# Conversor de Monedas en Java

Aplicación de consola que permite convertir entre distintas monedas usando la API de ExchangeRate.

## Funcionalidades
- Conversión entre USD, ARS, BRL, EUR y COP
- Consumo de API externa con ExchangeRate
- Manejo y análisis de respuestas JSON con Gson
- Menú interactivo en consola
- Visualización de resultados en formato JSON estructurado
- Generación automática de archivos `.json` con cada conversión
- Almacenamiento de resultados en la carpeta `conversiones`

## Cómo ejecutar
- Clona el repositorio:
   ```bash
   git clone https://github.com/JulioPc28/conversor_de_moneda.git
- Agrega tu API Key en ApiService.java reemplazando el valor de API_KEY.
- Ejecuta Main.java desde tu entorno de desarrollo (por ejemplo, IntelliJ IDEA).
- Selecciona una opción del menú y proporciona el monto a convertir.

## Salida de datos
- La conversión se muestra en consola con formato tradicional y también como JSON organizado.
- Se genera un archivo .json por conversión, guardado automáticamente en la carpeta conversiones con nombre dinámico basado en fecha y monedas.


## Ejemplo de salida en consola
El valor de 750.00 USD corresponde a 2935221.53 COP
Respuesta en formato JSON:
{
  "moneda_origen": "USD",
  "moneda_destino": "COP",
  "monto_original": 750.0,
  "tasa_conversion": 3913.6287,
  "monto_convertido": 2935221.525
}
✅ Resultado guardado en: conversiones/conversion_USD_a_COP_2025-10-19T10-52-49.718.json

## Estructura del proyecto

**src/**  
  **main/java/conversor/** 
      Modelos de datos (`RespuestaConversion.java`)  
      Consumo de API externa (`ApiService.java`) 
      Pantalla principal y menú interactivo (`Menu.java`)  
      Lógica de conversión (`Conversor.java`)  
    **Main.java**  Punto de entrada de la aplicación  

**conversiones/**  
    Archivos `.json` generados con cada conversión  

**pom.xml**  
    Configuración del proyecto Maven y dependencias  

**README.md**  
    Documentación del proyecto



## Créditos
Desarrollado por Julio Andrés Potes Cárdenas
