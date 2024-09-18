package com.example.medicinainterna.core.controller;

import com.example.medicinainterna.core.dto.especialidad.EspecialidadDto;
import com.example.medicinainterna.core.dto.especialidad.EspecialidadDtoList;
import com.example.medicinainterna.core.model.Especialidad;
import com.example.medicinainterna.core.repository.EspecialidadRepository;
import com.example.medicinainterna.core.service.EspecialidadService;
import com.example.medicinainterna.core.utils.Validacion;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/especialidad")
public class EspecialidadController {

    private final EspecialidadService especialidadService;
    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService, EspecialidadRepository especialidadRepository) {
        this.especialidadService = especialidadService;
        this.especialidadRepository = especialidadRepository;
    }

    @PostMapping("/")
    public ResponseEntity<?> insertarEspecialidad(@RequestBody EspecialidadDto especialidad) {
        try {
            Validacion.validarUnsupportedOperationException(especialidad);
            especialidadService.insertarEspecialidad(new Especialidad(especialidad));
            return ResponseEntity.ok("Especialidad insertado correctamente");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEspecialidad(@RequestBody EspecialidadDto especialidad, @PathVariable(value = "id") Long id) {
        try {
            Validacion.validarUnsupportedOperationException(especialidad);
            especialidad.setId(id);
            especialidadService.insertarEspecialidad(new Especialidad(especialidad));
            return ResponseEntity.ok("Especialidad modificada correctamente");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEspecialidad(@PathVariable(value = "id") Long id) {
        try {
            especialidadService.eliminarEspecialidad(id);
            return ResponseEntity.ok("Especialidad modificada correctamente");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @Operation(summary = "Obtener la lista de las especialidades")
    public ResponseEntity<?> listarEspecialidad() {
        try {
            return ResponseEntity.ok(especialidadRepository.findAll().stream().map(EspecialidadDto::new).toList());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo obtener el listado de especialidades");
        }
    }

    @GetMapping("/listar")
    @Operation(summary = "Obtener la lista de las especialidades")
    public ResponseEntity<?> listarEspecialidadconDoctores() {
        try {
            return ResponseEntity.ok(especialidadRepository.findAll().stream().map(EspecialidadDtoList::new).toList());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo obtener el listado de especialidades con sus doctores");
        }
    }
}
