package com.ejemplo.service;

import com.ejemplo.models.Persona;
import com.ejemplo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // sirve para indicarle a spring que este es un servicio
public class PersonaServiceImpl implements PersonaService {

    @Autowired // para que spring vaya y busque el componente que necesito
    private PersonaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAll() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }
}
