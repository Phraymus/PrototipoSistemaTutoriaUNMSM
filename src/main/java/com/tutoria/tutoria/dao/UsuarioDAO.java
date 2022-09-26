package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Usuario;
import com.tutoria.tutoria.interfaces.UsuarioInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class UsuarioDAO implements UsuarioInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getList() {
        String query="FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUsuario() {
        return null;
    }

    @Override
    public Usuario getAuthUsuario(Usuario usuario) {
        String query="FROM Usuario WHERE nombre= :nombre AND contrasenia= :contrasenia";
        List<Usuario> list=entityManager.createQuery(query)
                .setParameter("nombre",usuario.getNombre())
                .setParameter("contrasenia",usuario.getContrasenia())
                .getResultList();
        if (!list.isEmpty()){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
