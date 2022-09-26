package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.EscuelaProfesional;
import com.tutoria.tutoria.interfaces.EscuelaProfesionalInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EscuelaProfesionalDAO implements EscuelaProfesionalInterface {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<EscuelaProfesional> getList() {
        String query="FROM EscuelaProfesional";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public EscuelaProfesional getEscuelaProfesional() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
