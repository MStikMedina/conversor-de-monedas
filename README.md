# 💱 Conversor de Divisas

Este proyecto es una aplicación de consola en Java que permite la conversión de diversas monedas utilizando la **ExchangeRate-API**. La interfaz gráfica está basada en **JOptionPane** para capturar la entrada del usuario y mostrar los resultados.

## 🚀 Características

- 🌍 Conversión entre Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).
- 🎨 Interfaz gráfica basada en **JOptionPane** para una experiencia interactiva.
- 🔗 Comunicación con una API externa para obtener tasas de conversión en tiempo real.

## ⚙️ Funcionalidades

- 🔄 Convertir entre USD y ARS, BRL, COP y viceversa.
- ⚠️ Manejo de errores al ingresar opciones inválidas o valores no numéricos.
- 💬 Mensajes de finalización amigables y claros cuando el usuario decide cerrar la aplicación.

## 📁 Archivos principales

- `Logica.java`: Gestiona la lógica principal de la aplicación y presenta el menú de opciones.
- `Api.java`: Realiza la solicitud HTTP a la API de ExchangeRate y maneja la conversión de monedas.
- `Api.java`: Esta clase también muestra al usuario el valor convertido después de ingresar la cantidad.
- `DatosJson.java`: Representa el formato JSON que devuelve la API para la conversión.
- `FinishProgram.java`: Muestra mensajes cuando el programa finaliza o cuando se ingresa una opción inválida.

## 🛠️ Requisitos

- **Java 8 o superior**.
- Dependencia de **Gson** para deserializar la respuesta JSON de la API.
- 🌐 Conexión a Internet para acceder a la API de conversión.

## 📖 Uso

1. Al iniciar la aplicación, se mostrará un menú con las opciones de conversión disponibles.
2. Selecciona la conversión que deseas realizar ingresando el número correspondiente.
3. Ingresa la cantidad de dinero a convertir.
4. El resultado de la conversión se mostrará en un cuadro de diálogo.
5. Elige "Cancel" o dale a la "X" en el menú para finalizar la aplicación.

## 📦 Instalación

1. Clona el repositorio.
2. Asegúrate de tener **Java** instalado en tu sistema.
3. Importa el proyecto en tu IDE preferido.
4. Añade la biblioteca **Gson** a tu proyecto (puedes descargarla desde [aquí](https://github.com/google/gson)).
5. Ejecuta la clase `Logica.java` para iniciar la aplicación.

## 🌐 API Utilizada

- [ExchangeRate-API](https://www.exchangerate-api.com/)
    - Clave de API usada: `52e5bd122c36c590a0c97783`
    - Esta API es de uso personal y solamente para pruebas.

## 👤 Autor

Proyecto desarrollado por Marlon Medina.
