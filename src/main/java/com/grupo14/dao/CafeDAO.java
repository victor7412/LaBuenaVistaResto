package com.grupo14.dao;

import com.grupo14.model.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CafeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cafe> listar() {
        String sql = "SELECT * FROM cafe";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cafe.class));
    }

    public Boolean add(Cafe cafe) {
        String sql = "INSERT INTO cafe (nombre, precio, imagen) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, cafe.getNombre(), cafe.getPrecio(), cafe.getImagen());
        return result == 1;
    }

    public Boolean del(Cafe cafe) {
        String sql = "DELETE FROM cafe WHERE id = ?";
        int result = jdbcTemplate.update(sql, cafe.getId());
        return result == 1;
    }
}
