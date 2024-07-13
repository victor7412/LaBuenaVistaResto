package com.grupo14;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo14.dao.CafeDAO;
import com.grupo14.model.Cafe;

@RestController
@RequestMapping("/api/cafes")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CafeController {

    @Autowired
    private CafeDAO cafeDAO;

    @GetMapping("/listarCafe")
    public List<Cafe> listarCafe() {
        return cafeDAO.listar();
    }

    @PostMapping("/addCafe")
    public void addCafe(@RequestBody Cafe cafe) {
        cafeDAO.add(cafe);
    }

    @DeleteMapping("/delCafe/{id}")
    public void delCafe(@PathVariable("id") Integer id) {
        Cafe cafe = new Cafe(id);
        cafeDAO.del(cafe);
    }
}
