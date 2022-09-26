package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.EscuelaProfesional;

import java.util.List;

public interface EscuelaProfesionalInterface {
    List<EscuelaProfesional> getList();
    EscuelaProfesional getEscuelaProfesional();
    void add();
    void delete();

}
