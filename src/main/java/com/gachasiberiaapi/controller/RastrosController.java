package com.gachasiberiaapi.controller;

import com.gachasiberiaapi.entity.RastrosStarrail;
import com.gachasiberiaapi.entity.StarrailPersonaje;
import com.gachasiberiaapi.service.RastrosService;
import com.gachasiberiaapi.service.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gachasIberia/rastros")
public class RastrosController {
    private final RastrosService service;
    private final PersonajeService personajeService;

    public RastrosController(PersonajeService personajeService, RastrosService service) {
        this.personajeService = personajeService;
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
    public ResponseEntity<List<RastrosStarrail>> findAll() {
        List<RastrosStarrail> manufacturers = this.service.findAll();
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
    public ResponseEntity<List<RastrosStarrail>> findByTitulo(@PathVariable String nombre) {
        List<RastrosStarrail> encontrado = this.service.findByNombre(nombre);

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
    @PostMapping("/crear")
    public ResponseEntity<String> create(@RequestBody RastrosStarrail dto) {
        String nombre = dto.getNombrePersonaje();

        List<StarrailPersonaje> personajeList = personajeService.findByNombre(nombre);
        if (personajeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El personaje no existe.");
        }

        if (!service.findByNombre(nombre).isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un Eidolon para ese personaje.");
        }

        StarrailPersonaje personaje = personajeList.get(0);

        RastrosStarrail rastrosStarrail = new RastrosStarrail();
        rastrosStarrail.setPersonaje(personaje);
        rastrosStarrail.setNombrePersonaje(personaje.getNombre());
        rastrosStarrail.setRastro1(dto.getRastro1());
        rastrosStarrail.setRastro2(dto.getRastro2());
        rastrosStarrail.setRastro3(dto.getRastro3());
        rastrosStarrail.setRastro4(dto.getRastro4());

        service.save(rastrosStarrail);

        return ResponseEntity.ok("Habilidad creada con éxito.");
    }

    @Operation(summary = "Actualizar un curso existente", description = "Permite actualizar los datos de un curso existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping("/updateByNombre")
    public ResponseEntity<List<RastrosStarrail>> updateByNombre(@RequestBody Map<String, String> updates) {
        String nombrePersonaje = updates.get("nombrePersonaje");

        if (nombrePersonaje == null || nombrePersonaje.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        List<RastrosStarrail> habilidades = service.findByNombre(nombrePersonaje);
        if (habilidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        for (RastrosStarrail habilidad : habilidades) {
            if (updates.containsKey("nombre")) habilidad.setNombrePersonaje(updates.get("nombre"));
            if (updates.containsKey("rastro1")) habilidad.setRastro1(updates.get("rastro1"));
            if (updates.containsKey("rastro2")) habilidad.setRastro2(updates.get("rastro2"));
            if (updates.containsKey("rastro3")) habilidad.setRastro3(updates.get("rastro3"));
            if (updates.containsKey("rastro4")) habilidad.setRastro4(updates.get("rastro4"));

            service.save(habilidad);
        }

        return ResponseEntity.ok(habilidades);
    }

    @Operation(summary = "Elimina un curso por ID", description = "Permite eliminar un curso según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @DeleteMapping("/{nombre}")
    public ResponseEntity<String> deleteById(@PathVariable("nombre") String nombre) {
        System.out.println("Intentando borrar eidolon: " + nombre);
        int result = service.deleteByNombre(nombre);
        if (result == -1) {
            return ResponseEntity.noContent().build();  // No encontrado
        }
        return ResponseEntity.ok("Eidolon borrado con éxito");
    }
}
