package com.grupo14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grupo14.dao.CafeDAO;
import com.grupo14.model.Cafe;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(CafeDAO cafeDAO) {
        return (args) -> {
            List<Cafe> listaCafes = cafeDAO.listar();

            if (listaCafes != null) {
                for (Cafe cafe : listaCafes) {
                    System.out.println(cafe.getNombre() + " - $" + cafe.getPrecio());
                }
            } else {
                System.out.println("No se encontraron cafés.");
            }
        };
    }
}
