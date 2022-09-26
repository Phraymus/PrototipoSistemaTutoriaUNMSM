package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Sesion;
import com.tutoria.tutoria.interfaces.SesionInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SesionDAO implements SesionInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Sesion> getList() {
        String query="FROM Sesion";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Sesion> getList(long id) {
        String query="FROM Sesion WHERE tutorado_persona_id= :idTutorado OR tutor_persona_id= :idTutor";
        return entityManager.createQuery(query)
                .setParameter("idTutorado",id)
                .setParameter("idTutor",id)
                .getResultList();
    }

    @Override
    public Sesion getSesion(long id) {
        return entityManager.find(Sesion.class,id);
    }

    @Override
    public void add(Sesion sesion) {
        entityManager.merge(sesion);
    }

    @Override
    public void addInform(Sesion sesion) {
        Sesion sesionTmp=getSesion(sesion.getId());
        sesionTmp.setInforme(sesion.getInforme());
        sesionTmp.setObservacion(sesion.getObservacion());
        entityManager.merge(sesionTmp);
    }

    @Override
    public void generateReport(long id) {

    }

    @Override
    public void delete() {

    }
}
