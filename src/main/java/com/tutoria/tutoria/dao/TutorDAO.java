package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Tutor;
import com.tutoria.tutoria.interfaces.TutorInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TutorDAO implements TutorInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tutor> getList() {
        String query="FROM Tutor";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Tutor getTutor() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
