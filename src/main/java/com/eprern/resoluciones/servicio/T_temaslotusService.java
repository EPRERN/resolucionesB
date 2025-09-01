package com.eprern.resoluciones.servicio;

import com.eprern.resoluciones.model.T_temaslotus;
import com.eprern.resoluciones.repository.T_temaslotusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class T_temaslotusService {

    @Autowired
    private T_temaslotusRepository t_temaslotusRepository;

    public T_temaslotus guardarT_temaslotus(T_temaslotus t_temaslotus) {
        return t_temaslotusRepository.save(t_temaslotus);
    }

    public List<T_temaslotus> getAllT_temaslotuss() {
        return t_temaslotusRepository.findAll();
    }

    public T_temaslotus getT_temaslotusById(Long id) {
        return t_temaslotusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_temaslotus not found with id " + id));
    }

    public T_temaslotus updateT_temaslotus(Long id, T_temaslotus t_temaslotusDetails) {
            T_temaslotus t_temaslotus = t_temaslotusRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("T_temaslotus not found with id " + id));
            BeanUtils.copyProperties(t_temaslotusDetails, t_temaslotus, "id");

            return t_temaslotusRepository.save(t_temaslotus);
    }

    public void deleteT_temaslotus(Long id) {
        T_temaslotus t_temaslotus = t_temaslotusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_temaslotus not found with id " + id));
        t_temaslotusRepository.delete(t_temaslotus);
    }
}
