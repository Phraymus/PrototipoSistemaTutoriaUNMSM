package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "solicitud")
@ToString @EqualsAndHashCode
public class Solicitud {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private long id;

    @Column(name = "asunto")
    @Getter @Setter
    private String asunto;

    @Column(name = "tipo")
    @Getter @Setter
    private char tipo;
    
    @Column(name = "fecha")
    @Getter @Setter
    private Date fecha;

    @Column(name = "estado")
    @Getter @Setter
    private char estado;

    @Column(name = "tutorado_persona_id")
    @Getter @Setter
    private long tutorado;

    @Column(name = "asignatura_codigo")
    @Getter @Setter
    private String asignatura;
}
