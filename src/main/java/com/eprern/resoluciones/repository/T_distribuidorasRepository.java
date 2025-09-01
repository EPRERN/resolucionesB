package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.T_distribuidoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface T_distribuidorasRepository extends JpaRepository<T_distribuidoras, Long> {
}
