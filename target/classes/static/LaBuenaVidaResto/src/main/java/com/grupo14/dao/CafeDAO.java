package com.grupo14.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.grupo14.model.Cafe;

/**
 * Esta clase agrupa todas la consultas a la tabla Cafe.
 * Consultas, insert, upd, y del
 * 
 */
public class CafeDAO {
 
    public void listar() {

        try {
            Statement st=Cafe.getSt();
            ResultSet rs=st.executeQuery("Select * from cafe");
            while (rs.next()) {
                System.out.println(rs.getString("titulo"));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
