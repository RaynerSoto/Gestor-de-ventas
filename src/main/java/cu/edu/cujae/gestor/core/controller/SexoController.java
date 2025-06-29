package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.core.dto.sexoDto.SexoDto;
import cu.edu.cujae.gestor.core.service.SexoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sexo/")
@Tag(name = "Controllador de Sexo",
        description = "Controlador para gestionar las operaciones relacionadas con los sexos en el sistema.")
public class SexoController {
    private final SexoService sexoService;

    @Autowired
    public SexoController(SexoService sexoService) {
        this.sexoService = sexoService;
    }

    @PostMapping("")
    @Operation(summary = "Insertar un nuevo sexo",
            description = "Inserta un nuevo sexo en el sistema. El nombre del sexo debe ser único.")
    public ResponseEntity<?> insertarSexo(@RequestBody SexoDto sexoDto) {
        try {
            sexoService.insertarSexo(sexoDto);
            return ResponseEntity.ok("Se insertó el sexo con nombre: " + sexoDto.nombre());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un sexo existente",
            description = "Actualiza un sexo existente en el sistema. El ID del sexo debe ser válido y el nombre debe ser único.")
    public ResponseEntity<?> actualizarSexo(@PathVariable Long id, @RequestBody SexoDto sexoDto) {
        try {
            sexoService.modificarSexo(sexoDto,id);
            return ResponseEntity.ok("Se actualizó el sexo con ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un sexo",
            description = "Elimina un sexo del sistema. El ID del sexo debe ser válido.")
    public ResponseEntity<?> eliminarSexo(@PathVariable Long id) {
        try {
            sexoService.eliminarSexo(id);
            return ResponseEntity.ok("Se eliminó el sexo con ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    @Operation(summary = "Obtener todos los sexos",
            description = "Obtiene todos los sexos del sistema.")
    public ResponseEntity<?> obtenerTodosLosSexos() {
        try {
            return ResponseEntity.ok(sexoService.listarSexo());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
