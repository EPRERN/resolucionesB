package com.eprern.resoluciones.servicio;

import com.eprern.resoluciones.model.T_resoluciones;
import com.eprern.resoluciones.repository.T_resolucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class T_resolucionesService {

    @Autowired
    private T_resolucionesRepository t_resolucionesRepository;

    public T_resoluciones guardarT_resoluciones(T_resoluciones t_resoluciones) {
        return t_resolucionesRepository.save(t_resoluciones);
    }

    public List<T_resoluciones> getAllT_resolucioness() {
        return t_resolucionesRepository.findAll();
    }

    public T_resoluciones getT_resolucionesById(Long id) {
        return t_resolucionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_resoluciones not found with id " + id));
    }

    public T_resoluciones updateT_resoluciones(Long id, T_resoluciones t_resolucionesDetails) {
            T_resoluciones t_resoluciones = t_resolucionesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("T_resoluciones not found with id " + id));
            BeanUtils.copyProperties(t_resolucionesDetails, t_resoluciones, "id");

            return t_resolucionesRepository.save(t_resoluciones);
    }

    public void deleteT_resoluciones(Long id) {
        T_resoluciones t_resoluciones = t_resolucionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_resoluciones not found with id " + id));
        t_resolucionesRepository.delete(t_resoluciones);
    }
}
