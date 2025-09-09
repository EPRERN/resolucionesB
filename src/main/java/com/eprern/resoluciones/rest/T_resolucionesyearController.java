package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_resolucionesyear;
import com.eprern.resoluciones.service.T_resolucionesyearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/t_resolucionesyears")
public class T_resolucionesyearController {

    @Autowired
    private T_resolucionesyearService t_resolucionesyearService;

    @PostMapping
    public ResponseEntity<T_resolucionesyear> createT_resolucionesyear(@RequestBody T_resolucionesyear t_resolucionesyear) {
        T_resolucionesyear nuevoT_resolucionesyear = t_resolucionesyearService.guardarT_resolucionesyear(t_resolucionesyear);
        return ResponseEntity.ok(nuevoT_resolucionesyear);
    }

    @GetMapping
    public ResponseEntity<List<T_resolucionesyear>> getAllT_resolucionesyears() {
        List<T_resolucionesyear> t_resolucionesyears = t_resolucionesyearService.getAllT_resolucionesyears();
        return ResponseEntity.ok(t_resolucionesyears);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T_resolucionesyear> getT_resolucionesyearById(@PathVariable Long id) {
        T_resolucionesyear t_resolucionesyear = t_resolucionesyearService.getT_resolucionesyearById(id);
        return ResponseEntity.ok(t_resolucionesyear);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T_resolucionesyear> updateT_resolucionesyear(@PathVariable Long id, @RequestBody T_resolucionesyear t_resolucionesyearDetails) {
        T_resolucionesyear updatedT_resolucionesyear = t_resolucionesyearService.updateT_resolucionesyear(id, t_resolucionesyearDetails);
        return ResponseEntity.ok(updatedT_resolucionesyear);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteT_resolucionesyear(@PathVariable Long id) {
        t_resolucionesyearService.deleteT_resolucionesyear(id);
        return ResponseEntity.noContent().build();
    }
}
