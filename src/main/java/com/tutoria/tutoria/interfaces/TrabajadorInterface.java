package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Trabajador;

import java.util.List;

public interface TrabajadorInterface {
    List<Trabajador> getList();
    Trabajador getTrabajador();
    void add();
    void delete();
}
