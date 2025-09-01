package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_temaslotus;
import com.eprern.resoluciones.servicio.T_temaslotusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/t_temaslotuss")
public class T_temaslotusController {

    @Autowired
    private T_temaslotusService t_temaslotusService;

    @PostMapping
    public ResponseEntity<T_temaslotus> createT_temaslotus(@RequestBody T_temaslotus t_temaslotus) {
        T_temaslotus nuevoT_temaslotus = t_temaslotusService.guardarT_temaslotus(t_temaslotus);
        return ResponseEntity.ok(nuevoT_temaslotus);
    }

    @GetMapping
    public ResponseEntity<List<T_temaslotus>> getAllT_temaslotuss() {
        List<T_temaslotus> t_temaslotuss = t_temaslotusService.getAllT_temaslotuss();
        return ResponseEntity.ok(t_temaslotuss);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T_temaslotus> getT_temaslotusById(@PathVariable Long id) {
        T_temaslotus t_temaslotus = t_temaslotusService.getT_temaslotusById(id);
        return ResponseEntity.ok(t_temaslotus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T_temaslotus> updateT_temaslotus(@PathVariable Long id, @RequestBody T_temaslotus t_temaslotusDetails) {
        T_temaslotus updatedT_temaslotus = t_temaslotusService.updateT_temaslotus(id, t_temaslotusDetails);
        return ResponseEntity.ok(updatedT_temaslotus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteT_temaslotus(@PathVariable Long id) {
        t_temaslotusService.deleteT_temaslotus(id);
        return ResponseEntity.noContent().build();
    }
}
