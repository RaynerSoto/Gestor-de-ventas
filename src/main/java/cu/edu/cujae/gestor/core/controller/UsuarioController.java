package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.core.dto.usuarioDto.UsuarioDto;
import cu.edu.cujae.gestor.core.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario/")
@Tag(name = "Controlador del Usuario",
        description = "Controlador para gestionar las operaciones relacionadas con los usuarios.")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("")
    @Operation(summary = "Insertar un nuevo usuario",
            description = "Permite insertar un nuevo usuario en el sistema. " +
                    "El usuario debe contener un nombre, contraseña, nombre de usuario y email.")
    public ResponseEntity<?> insertarUsuario(UsuarioDto usuarioDto) {
        try {
            usuarioService.insertarUsuario(usuarioDto);
            return ResponseEntity.ok("Usuario insertado correctamente: " + usuarioDto.nombre());
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al insertar el usuario: " + e.getMessage());
        }
    }

    @PutMapping("{idUsuario}")
    @Operation(summary = "Modificar un usuario existente",
            description = "Permite modificar un usuario existente en el sistema. " +
                    "Se debe proporcionar el ID del usuario y los nuevos datos.")
    public ResponseEntity<?> modificarUsuario(@RequestBody UsuarioDto usuarioDto, @PathVariable Long idUsuario) {
        try {
            usuarioService.modificarUsuario(usuarioDto, idUsuario);
            return ResponseEntity.ok("Usuario modificado correctamente: " + usuarioDto.nombre());
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al modificar el usuario: " + e.getMessage());
        }
    }

    @DeleteMapping("{idUsuario}")
    @Operation(summary = "Eliminar un usuario",
            description = "Permite eliminar un usuario del sistema. " +
                    "Se debe proporcionar el ID del usuario a eliminar.")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long idUsuario) {
        try {
            usuarioService.eliminarUsuario(idUsuario);
            return ResponseEntity.ok("Usuario eliminado correctamente con ID: " + idUsuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los usuarios",
            description = "Permite obtener una lista de todos los usuarios existentes en el sistema.")
    public ResponseEntity<?> listarUsuarios() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuarios());
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al listar los usuarios: " + e.getMessage());
        }
    }
}
