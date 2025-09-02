package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.T_resoluciones;
import com.eprern.resoluciones.servicio.T_resolucionesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/t_resolucioness")
public class T_resolucionesController {

    @Autowired
    private T_resolucionesService t_resolucionesService;
    
    // Crear resolución con PDF
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<T_resoluciones> createT_resoluciones(
            @RequestPart("resolucion") T_resoluciones resolucion,
            @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        
        if (file != null && !file.isEmpty()) {
            resolucion.setT_resolucionesblob(file.getBytes());
        }
        
        T_resoluciones nuevo = t_resolucionesService.guardarT_resoluciones(resolucion);
        return ResponseEntity.ok(nuevo);
    }

    
    
    // Descargar PDF
    @GetMapping("/{id}/file")
    public ResponseEntity<byte[]> descargarArchivo(@PathVariable Long id) {
        T_resoluciones resolucion = t_resolucionesService.getT_resolucionesById(id);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resolucion_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resolucion.getT_resolucionesblob());
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
