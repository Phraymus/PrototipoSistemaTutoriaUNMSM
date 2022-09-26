package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Tutor;
import com.tutoria.tutoria.beans.Tutorado;

import java.util.List;

public interface TutoradoInterface {
    List<Tutorado> getList();
    Tutorado getTutorado();
    void add();
    void delete();
}
