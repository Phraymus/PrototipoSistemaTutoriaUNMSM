package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "trabajador")
@ToString @EqualsAndHashCode
public class Trabajador {

    @Id
    @Column(name = "persona_id")
    @Getter @Setter
    private long id;

    @Column(name = "foto")
    @Getter @Setter
    private String foto;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Getter @Setter
    private Persona persona;
}
