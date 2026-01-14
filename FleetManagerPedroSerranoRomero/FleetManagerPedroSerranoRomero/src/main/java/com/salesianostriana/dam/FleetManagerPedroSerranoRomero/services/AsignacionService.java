package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.services;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto.CreateAsignacionRequest;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Asignacion;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Estado;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.AsignacionRepository;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.ConductorRepository;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsignacionService {

    private final VehiculoRepository vehiculoRepository;
    private final AsignacionRepository asignacionRepository ;
    private final ConductorRepository conductorRepository;


    public void asignarVehiculoAConductor(CreateAsignacionRequest dto) {

        if (asignacionRepository.existsByVehiculoIdAndFechaFinIsNull(dto.IdVehiculo())){
            throw new IllegalArgumentException("El vehículo ya tiene una asignación activa.");
        }
        if (asignacionRepository.existsByConductorIdAndFechaFinIsNull(dto.IdConductor())){
            throw new IllegalArgumentException("El conductor ya tiene una asignación activa.");
        }

        Asignacion asignacion = new Asignacion();

        asignacion.setVehiculo(vehiculoRepository.getReferenceById(dto.IdVehiculo()));
        asignacion.setConductor(conductorRepository.getReferenceById(dto.IdConductor()));

        asignacion.setFechaInicio(dto.fechaInicio());
        asignacion.setFechaFin(dto.fechaFin());
        asignacionRepository.save(asignacion);
    }

    public void cerrarAsignacion(Long idAsignacion) {
        Asignacion asignacion = asignacionRepository.findById(idAsignacion)
                .orElseThrow(() -> new IllegalArgumentException("Asignación no encontrada."));

        if (asignacion.getFechaFin() != null) {
            throw new IllegalArgumentException("La asignación ya ha sido cerrada.");
        }

        asignacion.setFechaFin(java.time.LocalDateTime.now());
        asignacionRepository.save(asignacion);

    }

}
