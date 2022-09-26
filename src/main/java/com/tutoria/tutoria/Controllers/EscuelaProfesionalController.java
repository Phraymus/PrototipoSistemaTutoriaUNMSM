package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.EscuelaProfesional;
import com.tutoria.tutoria.interfaces.EscuelaProfesionalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EscuelaProfesionalController {

    @Autowired
    private EscuelaProfesionalInterface escuelaProfesionalInterface;

    @RequestMapping(value="api/escuelaprofesional")
    public List<EscuelaProfesional> getList(){
        return escuelaProfesionalInterface.getList();
    }
}
