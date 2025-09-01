package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.T_temaslotus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface T_temaslotusRepository extends JpaRepository<T_temaslotus, Long> {
}
