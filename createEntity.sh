#!/bin/bash
#
#./createEntity.sh + (NOMBRE DE LA ENTIDAD)
#
# Función para convertir la primera letra de una cadena a minúsculas
lowercaseFirst() {
    echo "$(tr '[:upper:]' '[:lower:]' <<< "${1:0:1}")${1:1}"
}

# Verificar si se proporcionó un nombre de entidad
if [ -z "$1" ]; then
  echo "Por favor, proporciona el nombre de la entidad."
  exit 1
fi

# Nombre de la entidad con la primera letra en mayúsculas
entityName=$(echo "$1" | sed -r 's/(^|-)(\w)/\U\2/g')

# Convertir nombre de entidad a minúsculas
entityNameLower=$(lowercaseFirst "$entityName")

# Ruta base
basePath="src/main/java/com/eprern/resoluciones"

# Crear directorios necesarios si no existen
mkdir -p ${basePath}/model
mkdir -p ${basePath}/repository
mkdir -p ${basePath}/service
mkdir -p ${basePath}/rest

# Crear archivo de entidad
cat <<EOT >> ${basePath}/model/${entityName}.java
package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ${entityName} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;



    public ${entityName}(){}


}
EOT

# Crear archivo de repository
cat <<EOT >> ${basePath}/repository/${entityName}Repository.java
package com.eprern.resoluciones.repository;

import com.eprern.resoluciones.model.${entityName};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${entityName}Repository extends JpaRepository<${entityName}, Long> {
}
EOT

# Crear archivo de services
cat <<EOT >> ${basePath}/service/${entityName}Service.java
package com.eprern.resoluciones.service;

import com.eprern.resoluciones.model.${entityName};
import com.eprern.resoluciones.repository.${entityName}Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class ${entityName}Service {

    @Autowired
    private ${entityName}Repository ${entityNameLower}Repository;

    public ${entityName} guardar${entityName}(${entityName} ${entityNameLower}) {
        return ${entityNameLower}Repository.save(${entityNameLower});
    }

    public List<${entityName}> getAll${entityName}s() {
        return ${entityNameLower}Repository.findAll();
    }

    public ${entityName} get${entityName}ById(Long id) {
        return ${entityNameLower}Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("${entityName} not found with id " + id));
    }

    public ${entityName} update${entityName}(Long id, ${entityName} ${entityNameLower}Details) {
            ${entityName} ${entityNameLower} = ${entityNameLower}Repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("${entityName} not found with id " + id));
            BeanUtils.copyProperties(${entityNameLower}Details, ${entityNameLower}, "id");

            return ${entityNameLower}Repository.save(${entityNameLower});
    }

    public void delete${entityName}(Long id) {
        ${entityName} ${entityNameLower} = ${entityNameLower}Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("${entityName} not found with id " + id));
        ${entityNameLower}Repository.delete(${entityNameLower});
    }
}
EOT

# Crear archivo de controlador
cat <<EOT >> ${basePath}/rest/${entityName}Controller.java
package com.eprern.resoluciones.rest;

import com.eprern.resoluciones.model.${entityName};
import com.eprern.resoluciones.service.${entityName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/${entityNameLower}s")
public class ${entityName}Controller {

    @Autowired
    private ${entityName}Service ${entityNameLower}Service;

    @PostMapping
    public ResponseEntity<${entityName}> create${entityName}(@RequestBody ${entityName} ${entityNameLower}) {
        ${entityName} nuevo${entityName} = ${entityNameLower}Service.guardar${entityName}(${entityNameLower});
        return ResponseEntity.ok(nuevo${entityName});
    }

    @GetMapping
    public ResponseEntity<List<${entityName}>> getAll${entityName}s() {
        List<${entityName}> ${entityNameLower}s = ${entityNameLower}Service.getAll${entityName}s();
        return ResponseEntity.ok(${entityNameLower}s);
    }

    @GetMapping("/{id}")
    public ResponseEntity<${entityName}> get${entityName}ById(@PathVariable Long id) {
        ${entityName} ${entityNameLower} = ${entityNameLower}Service.get${entityName}ById(id);
        return ResponseEntity.ok(${entityNameLower});
    }

    @PutMapping("/{id}")
    public ResponseEntity<${entityName}> update${entityName}(@PathVariable Long id, @RequestBody ${entityName} ${entityNameLower}Details) {
        ${entityName} updated${entityName} = ${entityNameLower}Service.update${entityName}(id, ${entityNameLower}Details);
        return ResponseEntity.ok(updated${entityName});
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete${entityName}(@PathVariable Long id) {
        ${entityNameLower}Service.delete${entityName}(id);
        return ResponseEntity.noContent().build();
    }
}
EOT

echo "${entityName} entity, repository, service, and controller created successfully."