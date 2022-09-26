package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Tutor;

import java.util.List;

public interface TutorInterface {
    List<Tutor> getList();
    Tutor getTutor();
    void add();
    void delete();
}
