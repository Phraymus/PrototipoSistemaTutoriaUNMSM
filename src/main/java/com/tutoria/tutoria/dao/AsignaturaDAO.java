package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Asignatura;
import com.tutoria.tutoria.interfaces.AsignaturaInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AsignaturaDAO implements AsignaturaInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Asignatura> getList() {
        String query="FROM Asignatura";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Asignatura getAsignatura(String codigo) {
        String query="FROM Asignatura WHERE codigo= :codigo";
        return (Asignatura) entityManager.createQuery(query)
                .setParameter("codigo",codigo)
                .getResultList().get(0);
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
