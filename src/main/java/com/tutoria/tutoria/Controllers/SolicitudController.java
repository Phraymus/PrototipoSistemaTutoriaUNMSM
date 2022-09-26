package com.tutoria.tutoria.Controllers;

import com.tutoria.tutoria.beans.Solicitud;
import com.tutoria.tutoria.beans.Tutorado;
import com.tutoria.tutoria.interfaces.SolicitudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudInterface solicitudInterface;

    @RequestMapping(value = "api/solicitud")
    public List<Solicitud> getList(){
        return solicitudInterface.getList();
    }

    @RequestMapping(value = "api/solicitud/{id}")
    public List<Solicitud> getSolicitudTutorado (@PathVariable long id){
        return solicitudInterface.getSolicitudTutorado(id);
    }

    @RequestMapping(value = "api/solicitud",method = RequestMethod.PUT)
    public void updateEstado (@RequestBody Solicitud solicitud){
        solicitudInterface.updateEstado(solicitud);
    }

    @RequestMapping(value = "api/solicitud",method = RequestMethod.POST)
    public void add(@RequestBody Solicitud solicitud){
        //solicitud.setFecha(Calendar.getInstance().getTime());
        solicitud.setEstado('E');
        solicitudInterface.add(solicitud);
    }
}
