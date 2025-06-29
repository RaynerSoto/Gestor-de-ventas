package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.core.service.TrabajadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trabajador/")
@Tag(name = "Controlador del Trabajador",
        description = "Controlador para gestionar las operaciones relacionadas con los trabajadores.")
public class TrabajadorController {
    private final TrabajadorService trabajadorService;

    @Autowired
    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }
}
