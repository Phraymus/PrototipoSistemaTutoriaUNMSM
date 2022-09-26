package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "escuela_profesional")
@ToString @EqualsAndHashCode
public class EscuelaProfesional {

    @Id
    @Column(name = "id")
    @Getter @Setter
    private long id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;
}
