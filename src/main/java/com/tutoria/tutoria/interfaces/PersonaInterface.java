package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Persona;

import java.util.List;

public interface PersonaInterface {
    List<Persona> getList();
    Persona getPersona(long id);
    void add();
    void delete();
}
