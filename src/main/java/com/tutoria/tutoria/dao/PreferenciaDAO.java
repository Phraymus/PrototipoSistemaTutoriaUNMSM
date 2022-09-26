package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Preferencia;
import com.tutoria.tutoria.interfaces.PreferenciaInterface;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PreferenciaDAO implements PreferenciaInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Preferencia> getList() {
        String query="FROM Preferencia";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Preferencia getPreferencia() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
