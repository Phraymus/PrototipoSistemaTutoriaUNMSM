package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Asignatura;

import java.util.List;

public interface AsignaturaInterface {
    List<Asignatura> getList();
    Asignatura getAsignatura(String codigo);
    void add();
    void delete();
}
