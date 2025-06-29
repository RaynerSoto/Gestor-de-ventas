package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.proyectoDto.ProyectoDto;
import cu.edu.cujae.gestor.core.service.ProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/proyecto/")
@Tag(name = "Controlador de Proyecto",
        description = "Controlador para gestionar las operaciones relacionadas con los proyectos en el sistema")
public class ProyectoController {
    private final ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) { this.proyectoService = proyectoService; }

    @PostMapping("")
    @Operation(summary = "Insertar un nuevo proyecto",
            description = "Permite insertar un nuevo proyecto en el sistema. " +
            "El proyecto debe contener un titulo y una descripcion")
    public ResponseEntity<?> insertarProyecto(ProyectoDto proyecto) throws SearchException {
        try{
            proyectoService.insertarProyecto(proyecto);
            return ResponseEntity.ok("Proyecto insertado correctamente: " + proyecto.titulo());
        } catch(Exception e){
            throw new SearchException("Error al insertar el proyecto: " + e.getMessage());
        }
    }

    @PutMapping("{proyectoId}")
    @Operation(summary = "Modificar un proyecto existente",
            description = "Permite modificar un proyecto existente en el sistema. " +
                    "Se debe proporcionar el ID del proyecto y los datos a modificar.")
    public ResponseEntity<?> modificarProyecto(@RequestBody ProyectoDto proyecto, @PathVariable Long idProyecto) throws SearchException {
        try{
            proyectoService.modificarProyecto(proyecto, idProyecto);
            return ResponseEntity.ok("Rol modificado correctamente: " + proyecto.titulo());
        } catch(Exception e){
            throw new SearchException("Error al modificar el proyecto. " + e.getMessage());
        }
    }

    @DeleteMapping("{proyectoId}")
    @Operation(summary = "Eliminar un proyecto",
            description = "Permite eliminar un proyecto del sistema. " +
                    "Se debe proporcionar el ID del proyecto a eliminar.")
    public ResponseEntity<?> eliminarProyecto(@PathVariable Long proyectoId) throws SearchException {
        try {
            proyectoService.eliminarProyecto(proyectoId);
            return ResponseEntity.ok("Proyecto eliminado correctamente el proyecto con ID: " + proyectoId);
        } catch (SearchException e) {
            throw new SearchException("Error al eliminar el proyecto: " + e.getMessage());
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los proyectos",
            description = "Permite obtener una lista de todos los proyectos existentes en el sistema.")
    public ResponseEntity<?> listarProyecto() {
        try {
            return ResponseEntity.ok(proyectoService.listarProyectos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al listar los proyectos: " + e.getMessage());
        }
    }
}
