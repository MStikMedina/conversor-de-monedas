import java.io.IOException;

import static javax.swing.JOptionPane.*;

public class Logica {
    String menu, inputValor, dolar = "USD", pesoArgentino = "ARS", realBrasil = "BRL", pesoColombiano = "COP";
    int teclado;

    public void opcionUsuario() throws IOException, InterruptedException {
        Api api = new Api();

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

        do {
            try{
                teclado = Integer.parseInt(showInputDialog(null, menu, "Conversor de divisa", INFORMATION_MESSAGE));
            }catch (NumberFormatException e){
                showMessageDialog(null, "Muchas gracias por usar nuestros " + "servicios.", "Finalizando el " +
                        "programa", ERROR_MESSAGE);
                break;
            }
            switch (teclado) {
                case 1: {
                    api.par1 = dolar;
                    api.par2 = pesoArgentino;
                    api.mostrarResultado();
                    break;
                }
                case 2: {
                    api.par1 = pesoArgentino;
                    api.par2 = dolar;
                    api.mostrarResultado();
                    break;
                }
                case 3: {
                    api.par1 = dolar;
                    api.par2 = realBrasil;
                    api.mostrarResultado();
                    break;
                }
                case 4: {
                    api.par1 = realBrasil;
                    api.par2 = dolar;
                    api.mostrarResultado();
                    break;
                }
                case 5: {
                    api.par1 = dolar;
                    api.par2 = pesoColombiano;
                    api.mostrarResultado();
                    break;
                }
                case 6: {
                    api.par1 = pesoColombiano;
                    api.par2 = dolar;
                    api.mostrarResultado();
                    break;
                }
                case 7: {
                    showMessageDialog(null, "Muchas gracias por usar nuestros " + "servicios.", "Finalizando el " +
                            "programa", ERROR_MESSAGE);
                    break;
                }
                default: {
                    showMessageDialog(null, "Intente con otra opción", "Opción no válida", ERROR_MESSAGE);
                    break;
                }
            }
        } while (teclado != 7);
    }
}
