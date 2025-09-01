package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_resoluciones;
import com.eprern.resoluciones.servicio.T_resolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/t_resolucioness")
public class T_resolucionesController {

    @Autowired
    private T_resolucionesService t_resolucionesService;

    @PostMapping
    public ResponseEntity<T_resoluciones> createT_resoluciones(@RequestBody T_resoluciones t_resoluciones) {
        T_resoluciones nuevoT_resoluciones = t_resolucionesService.guardarT_resoluciones(t_resoluciones);
        return ResponseEntity.ok(nuevoT_resoluciones);
    }

    @GetMapping
    public ResponseEntity<List<T_resoluciones>> getAllT_resolucioness() {
        List<T_resoluciones> t_resolucioness = t_resolucionesService.getAllT_resolucioness();
        return ResponseEntity.ok(t_resolucioness);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T_resoluciones> getT_resolucionesById(@PathVariable Long id) {
        T_resoluciones t_resoluciones = t_resolucionesService.getT_resolucionesById(id);
        return ResponseEntity.ok(t_resoluciones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T_resoluciones> updateT_resoluciones(@PathVariable Long id, @RequestBody T_resoluciones t_resolucionesDetails) {
        T_resoluciones updatedT_resoluciones = t_resolucionesService.updateT_resoluciones(id, t_resolucionesDetails);
        return ResponseEntity.ok(updatedT_resoluciones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteT_resoluciones(@PathVariable Long id) {
        t_resolucionesService.deleteT_resoluciones(id);
        return ResponseEntity.noContent().build();
    }
}
