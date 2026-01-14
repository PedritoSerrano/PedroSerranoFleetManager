package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Estado;
import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Vehiculo;

public record VehiculoDetailDto(
        Long id,
        String matricula,
        String modelo,
        Integer kmActuales,
        Estado estado
        ) {

    public static VehiculoDetailDto of (Vehiculo vehiculo){
        return new VehiculoDetailDto(
                vehiculo.getId(),
                vehiculo.getMatricula(),
                vehiculo.getModelo(),
                vehiculo.getKmActuales(),
                vehiculo.getEstado()
        );
    }

}
