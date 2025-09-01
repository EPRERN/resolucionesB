package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.T_resoluciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface T_resolucionesRepository extends JpaRepository<T_resoluciones, Long> {
}
