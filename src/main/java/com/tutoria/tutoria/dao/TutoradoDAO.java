package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Tutorado;
import com.tutoria.tutoria.interfaces.TutoradoInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TutoradoDAO implements TutoradoInterface {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Tutorado> getList() {

        String query="FROM Tutorado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Tutorado getTutorado() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
