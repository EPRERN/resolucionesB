package com.eprern.resoluciones.servicio;

import com.eprern.resoluciones.model.T_temas;
import com.eprern.resoluciones.repository.T_temasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class T_temasService {

    @Autowired
    private T_temasRepository t_temasRepository;

    public T_temas guardarT_temas(T_temas t_temas) {
        return t_temasRepository.save(t_temas);
    }

    public List<T_temas> getAllT_temass() {
        return t_temasRepository.findAll();
    }

    public T_temas getT_temasById(Long id) {
        return t_temasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_temas not found with id " + id));
    }

    public T_temas updateT_temas(Long id, T_temas t_temasDetails) {
            T_temas t_temas = t_temasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("T_temas not found with id " + id));
            BeanUtils.copyProperties(t_temasDetails, t_temas, "id");

            return t_temasRepository.save(t_temas);
    }

    public void deleteT_temas(Long id) {
        T_temas t_temas = t_temasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("T_temas not found with id " + id));
        t_temasRepository.delete(t_temas);
    }
}
