package com.tutoria.tutoria.interfaces;

import com.tutoria.tutoria.beans.Usuario;

import java.util.List;

public interface UsuarioInterface {
    List<Usuario> getList();
    Usuario getUsuario();

    Usuario getAuthUsuario(Usuario usuario);
    void add();
    void delete();
}
