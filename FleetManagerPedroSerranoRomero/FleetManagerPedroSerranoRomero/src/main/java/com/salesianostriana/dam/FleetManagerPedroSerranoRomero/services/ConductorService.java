package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.services;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Conductor;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.ConductorRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public ConductorService(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    List<Conductor> filtrar (String nombre, String email) {
        return conductorRepository.findAll();
    }

    private static class ConductorSpecs {

        static Specification<Conductor> nombreContains (String nombre) {
            return ((root, query, criteriaBuilder) ->
                    nombre == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
        }
    }
}
