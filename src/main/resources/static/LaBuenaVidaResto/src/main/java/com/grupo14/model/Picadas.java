package com.grupo14.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Picadas {

    public static void main(String[] args) {

        // Conexión a la base de datos
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/labuenavidaresto", "root", "");

            // Creación de un statement para ejecutar consultas
            Statement statement = connection.createStatement();

            // Ejecución de la consulta
            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, precio, imagen FROM picadas");

            // Procesamiento de los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                // El campo 'imagen' puede ser manejado según cómo quieras mostrarlo o utilizarlo

                // Mostrar información en consola
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: $" + String.format("%.2f", precio)); // Formato de precio decimal
                System.out.println("Imagen: [No mostrada en consola]"); // La imagen puede ser manejada de forma diferente

                System.out.println("--------------------------------------");
            }

            // Cerrar conexiones
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
