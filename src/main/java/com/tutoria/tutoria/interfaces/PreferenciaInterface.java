package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Preferencia;

import java.util.List;

public interface PreferenciaInterface {
    List<Preferencia> getList();
    Preferencia getPreferencia();
    void add();
    void delete();
}
