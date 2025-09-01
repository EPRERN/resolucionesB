package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_temas;
import com.eprern.resoluciones.servicio.T_temasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/t_temass")
public class T_temasController {

    @Autowired
    private T_temasService t_temasService;

    @PostMapping
    public ResponseEntity<T_temas> createT_temas(@RequestBody T_temas t_temas) {
        T_temas nuevoT_temas = t_temasService.guardarT_temas(t_temas);
        return ResponseEntity.ok(nuevoT_temas);
    }

    @GetMapping
    public ResponseEntity<List<T_temas>> getAllT_temass() {
        List<T_temas> t_temass = t_temasService.getAllT_temass();
        return ResponseEntity.ok(t_temass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T_temas> getT_temasById(@PathVariable Long id) {
        T_temas t_temas = t_temasService.getT_temasById(id);
        return ResponseEntity.ok(t_temas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T_temas> updateT_temas(@PathVariable Long id, @RequestBody T_temas t_temasDetails) {
        T_temas updatedT_temas = t_temasService.updateT_temas(id, t_temasDetails);
        return ResponseEntity.ok(updatedT_temas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteT_temas(@PathVariable Long id) {
        t_temasService.deleteT_temas(id);
        return ResponseEntity.noContent().build();
    }
}
