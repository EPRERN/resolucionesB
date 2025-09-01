package com.eprern.resoluciones.service;

import com.eprern.resoluciones.model.T_distribuidoras;
import com.eprern.resoluciones.repository.T_distribuidorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class T_distribuidorasService {

    @Autowired
    private T_distribuidorasRepository t_distribuidorasRepository;

    public T_distribuidoras guardarT_distribuidoras(T_distribuidoras t_distribuidoras) {
        return t_distribuidorasRepository.save(t_distribuidoras);
    }

    public List<T_distribuidoras> getAllT_distribuidorass() {
        return t_distribuidorasRepository.findAll();
    }

    public T_distribuidoras getT_distribuidorasById(Long id) {
        return t_distribuidorasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_distribuidoras not found with id " + id));
    }

    public T_distribuidoras updateT_distribuidoras(Long id, T_distribuidoras t_distribuidorasDetails) {
            T_distribuidoras t_distribuidoras = t_distribuidorasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("T_distribuidoras not found with id " + id));
            BeanUtils.copyProperties(t_distribuidorasDetails, t_distribuidoras, "id");

            return t_distribuidorasRepository.save(t_distribuidoras);
    }

    public void deleteT_distribuidoras(Long id) {
        T_distribuidoras t_distribuidoras = t_distribuidorasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_distribuidoras not found with id " + id));
        t_distribuidorasRepository.delete(t_distribuidoras);
    }
}
