package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.rolDto.RolDto;
import cu.edu.cujae.gestor.core.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rol/")
@Tag(name = "Controlador de Rol",
        description = "Controlador para gestionar las operaciones relacionadas con los roles en el sistema.")
public class RolController {
    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("")
    @Operation(summary = "Insertar un nuevo rol",
            description = "Permite insertar un nuevo rol en el sistema. " +
                    "El rol debe contener un nombre y una descripción.")
    public ResponseEntity<?> insertarRol(RolDto rol) throws SearchException {
        try{
            rolService.insertarRol(rol);
            return ResponseEntity.ok("Rol insertado correctamente: " + rol.nombreRol());
        } catch (Exception e) {
            throw new SearchException("Error al insertar el rol: " + e.getMessage());
        }
    }

    @PutMapping("{rolId}")
    @Operation(summary = "Modificar un rol existente",
            description = "Permite modificar un rol existente en el sistema. " +
                    "Se debe proporcionar el ID del rol y los nuevos datos.")
    public ResponseEntity<?> modificarRol(@RequestBody RolDto rol, @PathVariable Long rolId) throws SearchException {
        try {
            rolService.modificarRol(rol, rolId);
            return ResponseEntity.ok("Rol modificado correctamente: " + rol.nombreRol());
        } catch (SearchException e) {
            throw new SearchException("Error al modificar el rol: " + e.getMessage());
        }
    }

    @DeleteMapping("{rolId}")
    @Operation(summary = "Eliminar un rol",
            description = "Permite eliminar un rol del sistema. " +
                    "Se debe proporcionar el ID del rol a eliminar.")
    public ResponseEntity<?> eliminarRol(@PathVariable Long rolId) throws SearchException {
        try {
            rolService.eliminarRol(rolId);
            return ResponseEntity.ok("Rol eliminado correctamente el rol con ID: " + rolId);
        } catch (SearchException e) {
            throw new SearchException("Error al eliminar el rol: " + e.getMessage());
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los roles",
            description = "Permite obtener una lista de todos los roles existentes en el sistema.")
    public ResponseEntity<?> listarRol() {
        try {
            return ResponseEntity.ok(rolService.listarRol());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al listar los roles: " + e.getMessage());
        }
    }
}
