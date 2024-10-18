import static javax.swing.JOptionPane.*;

// Clase para gestionar los mensajes de finalización y opciones inválidas
public class FinishProgram {
    // Muestra un mensaje de despedida al usuario
    public void FinalizarPrograma(){
        showMessageDialog(null, "Muchas gracias por usar nuestros servicios.", "Finalizando el " +
                "programa", ERROR_MESSAGE);
    }

    // Muestra un mensaje de error cuando el usuario ingresa una opción no válida
    public void OpcionInvalida(){
        showMessageDialog(null, "Intente con otra opción", "Opción no válida", ERROR_MESSAGE);
    }
}
