package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Vehiculo;

public record VehiculoSummaryDto(
        Long id,
        String matricula,
        String modelo
) {

    public static VehiculoSummaryDto of (Vehiculo vehiculo){
        return new VehiculoSummaryDto(
                vehiculo.getId(),
                vehiculo.getMatricula(),
                vehiculo.getModelo()
        );
    }

}
