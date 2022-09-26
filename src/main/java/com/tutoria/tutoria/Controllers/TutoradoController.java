package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Tutorado;
import com.tutoria.tutoria.interfaces.TutoradoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutoradoController {

    @Autowired
    private TutoradoInterface tutoradoInterface;

    @RequestMapping(value = "api/tutorado")
    public List<Tutorado> getList(){
        return tutoradoInterface.getList();
    }
}
