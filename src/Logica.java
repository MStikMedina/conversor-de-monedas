import java.io.IOException;

import static javax.swing.JOptionPane.*;

// Clase principal para gestionar la lógica de la aplicación de conversión de divisas.
// Permite al usuario seleccionar entre diferentes tipos de conversiones de moneda y muestra los resultados.
public class Logica {
    // Metodo principal que inicia la aplicación y llama al metodo para capturar la opción del usuario.
    public static void main(String[] args) throws IOException, InterruptedException {
        Logica logica = new Logica();
        logica.opcionUsuario();
    }

    // Variables de configuración para el menú, los tipos de moneda y la entrada del usuario.
    String menu, dolar = "USD", pesoArgentino = "ARS", realBrasil = "BRL", pesoColombiano = "COP", input;
    int teclado;

    // Muestra un menú para que el usuario elija la conversión de moneda deseada.
    // Realiza la conversión de acuerdo a la opción seleccionada.
    public void opcionUsuario() throws IOException, InterruptedException {
        // Crear instancias de las clases necesarias para realizar la conversión y manejar los mensajes.
        Api api = new Api();
        MostrarResultado mostrarResultado = new MostrarResultado();
        FinishProgram finishProgram = new FinishProgram();

        // Configurar el menú de opciones de conversión de moneda.
        menu = """
                Seleccione la conversión que desea hacer:
                
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                """;

        // Bucle para capturar y procesar la selección del usuario hasta que decida salir.
        do {
            try {
                // Mostrar el diálogo de entrada para que el usuario elija una opción del menú.
                input = showInputDialog(null, menu, "Conversor de divisa", INFORMATION_MESSAGE);
                if (input == null) {
                    finishProgram.FinalizarPrograma();
                    break;
                } else {
                    teclado = Integer.parseInt(input);
                }
                switch (teclado) {
                    // Configurar las monedas para la conversión seleccionada por el usuario.
                    case 1: {
                        api.par1 = dolar;
                        api.par2 = pesoArgentino;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 2: {
                        api.par1 = pesoArgentino;
                        api.par2 = dolar;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 3: {
                        api.par1 = dolar;
                        api.par2 = realBrasil;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 4: {
                        api.par1 = realBrasil;
                        api.par2 = dolar;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 5: {
                        api.par1 = dolar;
                        api.par2 = pesoColombiano;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 6: {
                        api.par1 = pesoColombiano;
                        api.par2 = dolar;
                        mostrarResultado.mostrarResultado();
                        break;
                    }
                    case 7: {
                        finishProgram.FinalizarPrograma();
                        break;
                    }
                    default: {
                        // Mostrar mensaje de error si el usuario selecciona una opción inválida.
                        finishProgram.OpcionInvalida();
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // Manejar el caso donde el usuario ingresa un valor no numérico y mostrar mensaje de error.
                if (input == null) {
                    finishProgram.FinalizarPrograma();
                    break;
                } else {
                    finishProgram.OpcionInvalida();
                }
            } catch (NullPointerException e) {
                finishProgram.FinalizarPrograma();
                break;
            }
        } while (teclado != 7);
    }
}