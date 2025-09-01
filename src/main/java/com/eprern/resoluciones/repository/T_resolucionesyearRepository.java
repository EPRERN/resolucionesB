package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.T_resolucionesyear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface T_resolucionesyearRepository extends JpaRepository<T_resolucionesyear, Long> {
}
