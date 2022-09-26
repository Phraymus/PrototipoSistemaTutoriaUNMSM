package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sesion")
@ToString @EqualsAndHashCode
public class Sesion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private long id;

    @Column(name = "fecha")
    @Getter @Setter
    private Date fecha;

    @Column(name = "hora")
    @Getter @Setter
    private String hora;

    @Column(name = "asunto")
    @Getter @Setter
    private String asunto;

    @Column(name = "tipo")
    @Getter @Setter
    private char tipo;

    @Column(name = "informe")
    @Getter @Setter
    private String informe;

    @Column(name = "resolucion")
    @Getter @Setter
    private String resolucion;

    @Column(name = "observacion")
    @Getter @Setter
    private String observacion;

    @Column(name = "tutor_persona_id")
    @Getter @Setter
    private long tutor;

    @Column(name = "asignatura_codigo")
    @Getter @Setter
    private String asignatura;

    @Column(name = "tutorado_persona_id")
    @Getter @Setter
    private long tutorado;


}
