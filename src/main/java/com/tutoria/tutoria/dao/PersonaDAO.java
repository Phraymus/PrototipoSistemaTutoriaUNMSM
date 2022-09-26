package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Persona;
import com.tutoria.tutoria.interfaces.PersonaInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonaDAO implements PersonaInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Persona> getList() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Persona getPersona(long id) {
        String query="FROM Persona WHERE id= :id";
        return (Persona) entityManager.createQuery(query)
                .setParameter("id",id)
                .getResultList().get(0);
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
