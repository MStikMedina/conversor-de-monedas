// Registro para almacenar la respuesta de la API, incluyendo el código de la moneda base, el código de la moneda
// objetivo y el resultado de la conversión
public record DatosJson(String base_code,
                        String target_code,
                        double conversion_result) {
}