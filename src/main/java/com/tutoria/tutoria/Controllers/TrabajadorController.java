package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Trabajador;
import com.tutoria.tutoria.interfaces.TrabajadorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrabajadorController {
    @Autowired
    private TrabajadorInterface trabajadorInterface;

    @RequestMapping(value = "api/trabajador")
    public List<Trabajador> getList(){
        return trabajadorInterface.getList();
    }
}
