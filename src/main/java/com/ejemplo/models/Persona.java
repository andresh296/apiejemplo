package com.ejemplo.models;

import lombok.*;

import javax.persistence.*;

@Getter // Esto nos crea todos lo get de los atributos
@Setter // Nos crea todos los set
@NoArgsConstructor // crea el contructor vacio
@AllArgsConstructor // crea constructor con todos los atributos
@Entity // Esto nos mappea la clase a una tabla
@Table(name = "personas") // esto me cambia el nombre de la tabla en la base de datos
public class Persona {

    @Id // Nos identifica que atributo es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID sea auto incremental
    private Long id;

    private String nombre;

    private String apellido;

    private String documento;

    private String email;

    private int edad;

    public Persona(String nombre, String apellido, String documento, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.edad = edad;
    }
}
