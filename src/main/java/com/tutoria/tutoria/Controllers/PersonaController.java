package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Persona;
import com.tutoria.tutoria.beans.Usuario;
import com.tutoria.tutoria.interfaces.PersonaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaInterface personaInterface;

    @RequestMapping(value="api/persona")
    public List<Persona> getList(){
        return personaInterface.getList();
    }

    @RequestMapping(value = "api/persona/{id}")
    public Persona getPersona(@PathVariable long id){
        return personaInterface.getPersona(id);
    }
}
