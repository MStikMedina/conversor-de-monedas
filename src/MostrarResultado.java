import java.io.IOException;
import java.math.BigDecimal;

import static javax.swing.JOptionPane.*;

public class MostrarResultado {
    String mensajeValor;

    public void mostrarResultado() throws IOException, InterruptedException {
        Api api = new Api();

        // Solicita al usuario el valor a convertir y llama al metodo de la conversión
        mensajeValor = """
                Instrucciones:
                
                - Las comas (,) y los puntos (.) representan decimal
                
                Ingresa el valor que deseas convertir:
                
                """;

        api.inputValor =
                BigDecimal.valueOf(Long.parseLong(showInputDialog(null, mensajeValor, api.par1 + " ==> " + api.par2,
                        QUESTION_MESSAGE).replace(",", ".")));
        api.convertidorMonedas();
    }
}
