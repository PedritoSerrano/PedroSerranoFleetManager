package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto;

import java.time.LocalDateTime;

public record CreateAsignacionRequest(
        Long IdVehiculo,
        Long IdConductor,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin
) {
}
