package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Solicitud;

import java.util.List;

public interface SolicitudInterface {
    List<Solicitud> getList();
    Solicitud getSolicitud(long id);
    void add(Solicitud solicitud);
    void updateEstado(Solicitud solicitud);
    void delete();
    List<Solicitud> getSolicitudTutorado(long id);
}
