package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tutor")
@ToString @EqualsAndHashCode
public class Tutor {

    @Id
    @Column(name = "persona_id")
    @Getter @Setter
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Getter @Setter
    private Persona persona;

    @Column(name = "estado")
    @Getter @Setter
    private char estado;

    @Column(name="codigo")
    @Getter @Setter
    private String codigo;

    @OneToMany(mappedBy = "tutor",cascade = CascadeType.ALL)
    List<Preferencia> listPreferencias;
}
