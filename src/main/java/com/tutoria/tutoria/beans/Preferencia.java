package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="preferencia")
@ToString @EqualsAndHashCode
public class Preferencia {
    @Id
    @Column(name="id")
    @Getter @Setter
    private long id;

    @Column(name="tipo")
    @Getter @Setter
    private char tipo;

    @ManyToOne
    @JoinColumn(name = "tutor_persona_id")
    @Getter @Setter
    private Tutor tutor;
}
