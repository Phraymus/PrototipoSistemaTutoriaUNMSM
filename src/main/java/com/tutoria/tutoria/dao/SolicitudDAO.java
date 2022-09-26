package com.tutoria.tutoria.dao;

import com.tutoria.tutoria.beans.Sesion;
import com.tutoria.tutoria.beans.Solicitud;
import com.tutoria.tutoria.interfaces.SolicitudInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SolicitudDAO implements SolicitudInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Solicitud> getList() {
        String query="FROM Solicitud ORDER BY fecha DESC";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Solicitud getSolicitud(long id) {
        return entityManager.find(Solicitud.class,id);
    }

    @Override
    public void add(Solicitud solicitud) {
        entityManager.merge(solicitud);
    }

    @Override
    public void updateEstado(Solicitud solicitud) {
        Solicitud solicitudReal=getSolicitud(solicitud.getId());
        solicitudReal.setEstado(solicitud.getEstado());
        entityManager.merge(solicitudReal);
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Solicitud> getSolicitudTutorado(long id) {
        String query="FROM Solicitud WHERE tutorado_persona_id= :id";
        return entityManager.createQuery(query)
                .setParameter("id",id)
                .getResultList();
    }
}
