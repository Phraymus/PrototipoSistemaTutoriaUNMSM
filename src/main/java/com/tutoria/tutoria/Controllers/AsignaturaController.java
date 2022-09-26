package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Asignatura;
import com.tutoria.tutoria.interfaces.AsignaturaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsignaturaController {

    @Autowired
    private AsignaturaInterface asignaturaInterface;

    @RequestMapping(value = "api/asignatura")
    public List<Asignatura> getList(){
        return asignaturaInterface.getList();
    }

    @RequestMapping(value = "api/asignatura/{codigo}")
    public Asignatura getAsignatura(@PathVariable String codigo) {
        return asignaturaInterface.getAsignatura(codigo);
    }
}
