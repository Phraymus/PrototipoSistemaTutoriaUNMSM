package com.tutoria.tutoria.beans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;

@Entity
@Table(name = "tutorado")
@ToString @EqualsAndHashCode
public class Tutorado {

    @Id
    @Column(name = "persona_id")
    @Getter @Setter
    private long id;

    @Column(name = "codigo")
    @Getter @Setter
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "escuela_profesional_id")
    @Getter @Setter
    private EscuelaProfesional escuelaProfesional;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Getter @Setter
    private Persona persona;
}
