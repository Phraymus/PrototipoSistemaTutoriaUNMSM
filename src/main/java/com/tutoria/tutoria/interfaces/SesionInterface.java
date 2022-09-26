package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Sesion;

import java.util.List;

public interface SesionInterface {
    List<Sesion> getList();
    List<Sesion> getList(long id);
    Sesion getSesion(long id);
    void add(Sesion sesion);
    void addInform(Sesion sesion);

    void generateReport(long id);
    void delete();
}
