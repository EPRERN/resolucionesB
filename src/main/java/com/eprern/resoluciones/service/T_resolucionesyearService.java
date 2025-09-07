package com.eprern.resoluciones.service;

import com.eprern.resoluciones.model.T_resolucionesyear;
import com.eprern.resoluciones.repository.T_resolucionesyearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class T_resolucionesyearService {

    @Autowired
    private T_resolucionesyearRepository t_resolucionesyearRepository;

    public T_resolucionesyear guardarT_resolucionesyear(T_resolucionesyear t_resolucionesyear) {
        return t_resolucionesyearRepository.save(t_resolucionesyear);
    }

    public List<T_resolucionesyear> getAllT_resolucionesyears() {
        return t_resolucionesyearRepository.findAll();
    }

    public T_resolucionesyear getT_resolucionesyearById(Long id) {
        return t_resolucionesyearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_resolucionesyear not found with id " + id));
    }

    public T_resolucionesyear updateT_resolucionesyear(Long id, T_resolucionesyear t_resolucionesyearDetails) {
            T_resolucionesyear t_resolucionesyear = t_resolucionesyearRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("T_resolucionesyear not found with id " + id));
            BeanUtils.copyProperties(t_resolucionesyearDetails, t_resolucionesyear, "id");

            return t_resolucionesyearRepository.save(t_resolucionesyear);
    }

    public void deleteT_resolucionesyear(Long id) {
        T_resolucionesyear t_resolucionesyear = t_resolucionesyearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_resolucionesyear not found with id " + id));
        t_resolucionesyearRepository.delete(t_resolucionesyear);
    }
}
