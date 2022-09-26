package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Usuario;
import com.tutoria.tutoria.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioInterface usuarioInterface;

    @RequestMapping(value="api/login")
    private Usuario login(@RequestBody Usuario usuario){
        Usuario resultUsuario=usuarioInterface.getAuthUsuario(usuario);
        if (resultUsuario!=null){
            return resultUsuario;
        }else{
            return null;
        }
    }
}

