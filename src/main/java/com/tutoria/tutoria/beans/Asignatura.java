package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

@Entity
@Table(name="asignatura")
@ToString @EqualsAndHashCode
public class Asignatura {

    @Id
    @Column(name = "codigo")
    @Getter @Setter
    private String codigo;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "escuela_profesional_id")
    @Getter @Setter
    private EscuelaProfesional escuelaProfesional;
}
