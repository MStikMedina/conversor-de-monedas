import com.google.gson.Gson;

import static javax.swing.JOptionPane.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    String par1, par2, valorConvertir, mensajeValor;

    public void convertidorMonedas() throws IOException, InterruptedException {
        String apiKey = "52e5bd122c36c590a0c97783";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + par1 + "/" + par2 + "/" + valorConvertir))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        DatosJson datosJson = new Gson().fromJson(response.body(),DatosJson.class);
        String mensajeResultado =
                valorConvertir + " " + par1 + " equivale a " + datosJson.conversion_result() + " " + par2;

        showMessageDialog(null, mensajeResultado, "Resultado", INFORMATION_MESSAGE);
    }

    public void mostrarResultado() throws IOException, InterruptedException {
        Logica logica = new Logica();
        mensajeValor = "Ingresa el valor que deseas convertir";

        logica.inputValor = showInputDialog(null, mensajeValor, par1 + " ==> " + par2,
                QUESTION_MESSAGE).replace(",",".");
        valorConvertir = logica.inputValor;
        convertidorMonedas();
    }
}
