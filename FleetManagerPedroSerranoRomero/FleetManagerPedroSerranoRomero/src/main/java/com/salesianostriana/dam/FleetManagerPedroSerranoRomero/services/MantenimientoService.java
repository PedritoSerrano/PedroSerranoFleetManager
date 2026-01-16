package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.services;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Estado;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Mantenimiento;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Vehiculo;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.MantenimientoRepository;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.TallerRepository;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MantenimientoService {

    private final VehiculoRepository vehiculoRepository;
    private final MantenimientoRepository mantenimientoRepository;
    private final TallerRepository tallerRepository;


    public void registrarMantenimiento (CreateMantenimientoRequest dto) {
        Vehiculo vehiculo = vehiculoRepository.findById(dto.idVehiculo())
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado."));

        if (vehiculo.getEstado() == Estado.ASIGNADO){
            throw new IllegalArgumentException("No se puede registrar un mantenimiento en un vehículo asignado.");
        }

        if(dto.kmEnRevision() < vehiculo.getKmActuales()){
            throw new IllegalArgumentException("El kilometraje debe ser igual o mayor que el kilometraje actual del vehículo.");
        }

        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setTipo(dto.tipo());
        mantenimiento.setFecha(dto.fecha());
        mantenimiento.setKmEnRevision(dto.kmEnRevision());
        mantenimiento.setVehiculo(vehiculo);

        mantenimiento.setTaller(tallerRepository.getReferenceById(dto.idTaller()));

        mantenimientoRepository.save(mantenimiento);
    }
}
