package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="persona")
@ToString @EqualsAndHashCode
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private long id;

    @Getter @Setter @Column(name="nombre")
    private String nombre;

    @Getter @Setter @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Getter @Setter @Column(name="apellido_materno")
    private String apellidoMaterno;

    @Getter @Setter @Column(name="dni")
    private String dni;

    @Getter @Setter @Column(name="sexo")
    private String sexo;

    @Getter @Setter @Column(name="correo")
    private String correo;

    /*@OneToMany(mappedBy = "persona")
    List<Usuario> usuario;*/
}
