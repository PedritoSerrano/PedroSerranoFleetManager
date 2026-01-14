package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.dto;

import java.time.LocalDateTime;

public record CreateMantenimientoRequest(
        Long idVehiculo,
        Long idTaller,
        String tipo,
        LocalDateTime fecha,
        Integer kmEnRevision
) {
}
