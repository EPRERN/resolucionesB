package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_distribuidoras;
import com.eprern.resoluciones.service.T_distribuidorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/t_distribuidorass")
public class T_distribuidorasController {

    @Autowired
    private T_distribuidorasService t_distribuidorasService;

    @PostMapping
    public ResponseEntity<T_distribuidoras> createT_distribuidoras(@RequestBody T_distribuidoras t_distribuidoras) {
        T_distribuidoras nuevoT_distribuidoras = t_distribuidorasService.guardarT_distribuidoras(t_distribuidoras);
        return ResponseEntity.ok(nuevoT_distribuidoras);
    }

    @GetMapping
    public ResponseEntity<List<T_distribuidoras>> getAllT_distribuidorass() {
        List<T_distribuidoras> t_distribuidorass = t_distribuidorasService.getAllT_distribuidorass();
        return ResponseEntity.ok(t_distribuidorass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T_distribuidoras> getT_distribuidorasById(@PathVariable Long id) {
        T_distribuidoras t_distribuidoras = t_distribuidorasService.getT_distribuidorasById(id);
        return ResponseEntity.ok(t_distribuidoras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T_distribuidoras> updateT_distribuidoras(@PathVariable Long id, @RequestBody T_distribuidoras t_distribuidorasDetails) {
        T_distribuidoras updatedT_distribuidoras = t_distribuidorasService.updateT_distribuidoras(id, t_distribuidorasDetails);
        return ResponseEntity.ok(updatedT_distribuidoras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteT_distribuidoras(@PathVariable Long id) {
        t_distribuidorasService.deleteT_distribuidoras(id);
        return ResponseEntity.noContent().build();
    }
}
