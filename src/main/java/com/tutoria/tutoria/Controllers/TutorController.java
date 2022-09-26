package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Tutor;
import com.tutoria.tutoria.interfaces.TutorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorController {

    @Autowired
    private TutorInterface tutorInterface;

    @RequestMapping(value = "api/tutor")
    public List<Tutor> getList(){
        return tutorInterface.getList();
    }

}
