package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private long id;

    @Column(name="nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "contrasenia")
    @Getter @Setter
    private String contrasenia;

    @Column(name = "perfil")
    @Getter @Setter
    private char perfil;

    @ManyToOne
    @JoinColumn(name="persona_id")
            @Getter @Setter
    private Persona persona;
}
