package com.ejemplo.controller;

import com.ejemplo.models.Persona;
import com.ejemplo.request.PersonaRequest;
import com.ejemplo.service.PersonaService;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<?>  getAll() {
        return new ResponseEntity<List<Persona>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Persona getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PersonaRequest personaRequest) {
        Persona personaDB = service.save(personaRequest.toPersonaModel());
        return new ResponseEntity<Persona>(personaDB, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Persona update(@Valid @RequestBody PersonaRequest personaRequest, @PathVariable Long id) {
        Persona personaUpdate = personaRequest.toPersonaModel();
        personaUpdate.setId(id);

        return service.update(personaUpdate);
    }
}














