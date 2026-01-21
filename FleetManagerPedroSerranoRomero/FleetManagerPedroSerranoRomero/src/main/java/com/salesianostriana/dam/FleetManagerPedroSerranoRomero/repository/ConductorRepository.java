package com.salesianostriana.dam.FleetManagerPedroSerranoRomero.repository;

import com.salesianostriana.dam.FleetManagerPedroSerranoRomero.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

//    @Query


}
