package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {

    boolean existsByVehiculoIdAndFechaFinIsNull(Long vehiculoId);
    boolean existsByConductorIdAndFechaFinIsNull(Long conductorId);

}
