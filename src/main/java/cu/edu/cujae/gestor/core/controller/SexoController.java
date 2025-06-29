package cu.edu.cujae.gestor.core.controller;

import cu.edu.cujae.gestor.core.dto.sexoDto.SexoDto;
import cu.edu.cujae.gestor.core.service.SexoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sexo/")
public class SexoController {
    private final SexoService sexoService;

    @Autowired
    public SexoController(SexoService sexoService) {
        this.sexoService = sexoService;
    }

    @PostMapping("")
    public ResponseEntity<?> insertarSexo(@RequestBody SexoDto sexoDto) {
        sexoService.insertarSexo(sexoDto);
        return ResponseEntity.ok("Se insertó el sexo con nombre: " + sexoDto.nombre());
    }
}
