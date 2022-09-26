package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Sesion;
import com.tutoria.tutoria.interfaces.SesionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SesionController {
    @Autowired
    private SesionInterface sesionInterface;

    @RequestMapping (value ="api/sesion")
    public List<Sesion> getList(){
        return sesionInterface.getList();
    }

    @RequestMapping (value ="api/sesion/{id}")
    public List<Sesion> getList(@PathVariable long id){
        return sesionInterface.getList(id);
    }

    @RequestMapping (value ="api/sesion/report/{id}")
    public void generateReport(@PathVariable long id){
        sesionInterface.generateReport(id);
    }

    @RequestMapping(value = "api/sesion",method = RequestMethod.POST)
    public void add(@RequestBody Sesion sesion){
        sesionInterface.add(sesion);
    }

    @RequestMapping(value = "api/sesion",method = RequestMethod.PUT)
    public void addInforme(@RequestBody Sesion sesion){
        sesionInterface.addInform(sesion);
    }
}
