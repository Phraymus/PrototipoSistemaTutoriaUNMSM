package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Preferencia;
import com.tutoria.tutoria.interfaces.PreferenciaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PreferenciaController {

    @Autowired
    private PreferenciaInterface preferenciaInterface;

    @RequestMapping(value = "api/preferencia")
    public List<Preferencia> getList(){
        return preferenciaInterface.getList();
    }
}
