package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Trabajador;
import com.tutoria.tutoria.interfaces.TrabajadorInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TrabajadorDAO implements TrabajadorInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Trabajador> getList() {
        String query="FROM Trabajador";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Trabajador getTrabajador() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
