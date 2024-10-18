import static javax.swing.JOptionPane.*;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Clase para gestionar la conversión de monedas utilizando la API de ExchangeRate-API
public class Api {
    // Parámetros de la conversión y mensajes para mostrar en el JOptionPane
    String par1, par2, mensajeResultado, mensajeValor;
    BigDecimal inputValor;

    // Realiza la solicitud HTTP a la API y convierte la cantidad de una moneda a otra
    public void convertidorMonedas() throws IOException, InterruptedException {
        String apiKey = "52e5bd122c36c590a0c97783";

        // Crear un cliente HTTP para realizar la solicitud
        HttpClient client = HttpClient.newHttpClient();
        // Construir la solicitud HTTP a la API con los parámetros definidos
        HttpRequest request =
                HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + par1 + "/" + par2 + "/" + inputValor)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir la respuesta JSON de la API en un objeto DatosJson
        DatosJson datosJson = new Gson().fromJson(response.body(), DatosJson.class);
        mensajeResultado = inputValor + " " + par1 + " equivale a " + datosJson.conversion_result() + " " + par2;
        showMessageDialog(null, mensajeResultado, "Resultado", INFORMATION_MESSAGE);
    }

    public void mostrarResultado() throws IOException, InterruptedException {
        // Solicita al usuario el valor a convertir y llama al metodo de la conversión
        mensajeValor = """
                Instrucciones:
                
                - Las comas (,) y los puntos (.) representan decimal
                
                Ingresa el valor que deseas convertir:
                
                """;

        inputValor =
                BigDecimal.valueOf(Long.parseLong(showInputDialog(null, mensajeValor, par1 + " ==> " + par2,
                        QUESTION_MESSAGE).replace(",", ".")));
        convertidorMonedas();
    }
}
