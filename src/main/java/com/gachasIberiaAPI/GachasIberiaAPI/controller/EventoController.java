package com.gachasIberiaAPI.GachasIberiaAPI.controller;



import com.gachasIberiaAPI.GachasIberiaAPI.entity.Evento;
import com.gachasIberiaAPI.GachasIberiaAPI.service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gachasIberia/Evento")
public class EventoController {
    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    /*
    GET http://localhost:8080/api/gachasIberia
     */
    @Operation(summary = "Obtener todos los cursos", description = "Devuelve la lista de todos los cursos disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cursos encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron cursos")
    })
    @GetMapping
    public ResponseEntity<List<Evento>> findAll() {
        List<Evento> manufacturers = this.service.findAll();
        if (manufacturers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(manufacturers);
    }

    /*
    GET http://localhost:8080/api/cursos/titulo/DAW
     */
    @Operation(summary = "Buscar cursos por título", description = "Devuelve los cursos cuyo título coincida con el especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cursos encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron cursos")
    })
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Evento>> findByTitulo(@PathVariable String nombre) {
        List<Evento> encontrado = this.service.findByNombre(nombre);

        if (!encontrado.isEmpty()) {
            return ResponseEntity.ok(encontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un nuevo curso", description = "Permite crear un nuevo curso en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento starrailPersonaje) {
        if (starrailPersonaje.getNombre() == null)
            return ResponseEntity.badRequest().build();

        this.service.save(starrailPersonaje);
        return ResponseEntity.ok(starrailPersonaje);
    }

    @Operation(summary = "Actualizar un curso existente", description = "Permite actualizar los datos de un curso existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping
    public ResponseEntity<Evento> update(@RequestBody Evento manufacturer) {
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @Operation(summary = "Elimina un curso por ID", description = "Permite eliminar un curso según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @DeleteMapping("/{nombre}")
    public ResponseEntity<String> deleteById(@PathVariable("nombre") String nombre) {
        if (this.service.deleteByNombre(nombre) == 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok("Personaje no encontrada");
        }
    }
}
