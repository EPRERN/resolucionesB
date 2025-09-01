package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.T_temas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface T_temasRepository extends JpaRepository<T_temas, Long> {
}
