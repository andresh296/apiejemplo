package com.ejemplo.request;


import com.ejemplo.models.Persona;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PersonaRequest {


    @NotBlank
    private String nombre;

    @NotNull
    @NotEmpty
    private String apellido;

    @NotNull
    @NotEmpty
    private String documento;

    @Email
    private String email;

    private int edad;

    public Persona toPersonaModel() {
        Persona persona = new Persona(
                        this.getNombre(),
                        this.getApellido(),
                        this.getDocumento(),
                        this.getEmail(),
                        this.getEdad()
        );

        return persona;
    }
}





