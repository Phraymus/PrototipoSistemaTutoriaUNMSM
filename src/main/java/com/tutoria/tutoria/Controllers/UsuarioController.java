package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Usuario;
import com.tutoria.tutoria.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioInterface usuarioInterface;

    @RequestMapping(value = "api/usuario")
    public List<Usuario> getList(){
        return usuarioInterface.getList();
    }
}
