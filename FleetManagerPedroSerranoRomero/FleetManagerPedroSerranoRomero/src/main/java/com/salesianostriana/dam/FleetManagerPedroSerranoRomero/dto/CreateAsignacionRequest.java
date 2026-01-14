package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto;

public record CreateAsignacionRequest(
        Long IdVehiculo,
        Long IdConductor,
        String fechaInicio,
        String fechaFin
) {
}
