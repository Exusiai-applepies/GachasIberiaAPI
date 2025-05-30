package com.gachasiberiaapi.controller;



import com.gachasiberiaapi.entity.Eidolon;
import com.gachasiberiaapi.entity.StarrailPersonaje;
import com.gachasiberiaapi.service.EidolonService;
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
@RequestMapping("/api/gachasIberia/eidolon")
public class EidolonController {
    private final EidolonService service;
    private final PersonajeService personajeService;

    public EidolonController(PersonajeService personajeService, EidolonService service) {
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
    public ResponseEntity<List<Eidolon>> findAll() {
        List<Eidolon> manufacturers = this.service.findAll();
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
    public ResponseEntity<List<Eidolon>> findByTitulo(@PathVariable String nombre) {
        List<Eidolon> encontrado = this.service.findByNombre(nombre);

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
    public ResponseEntity<String> create(@RequestBody Eidolon dto) {
        String nombre = dto.getNombrePersonaje();

        List<StarrailPersonaje> personajeList = personajeService.findByNombre(nombre);
        if (personajeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El personaje no existe.");
        }

        // Verificar si ya existe un Eidolon con ese nombre
        if (!service.findByNombre(nombre).isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un Eidolon para ese personaje.");
        }

        // Obtener el personaje desde la base de datos
        StarrailPersonaje personaje = personajeList.get(0);

        // Crear el eidolon correctamente asociado
        Eidolon eidolon = new Eidolon();
        eidolon.setPersonaje(personaje);  // esto también asigna el ID debido al @MapsId
        eidolon.setNombrePersonaje(personaje.getNombre()); // esto se puede omitir si el @MapsId lo hace
        eidolon.setE1(dto.getE1());
        eidolon.setE2(dto.getE2());
        eidolon.setE3(dto.getE3());
        eidolon.setE4(dto.getE4());
        eidolon.setE5(dto.getE5());
        eidolon.setE6(dto.getE6());

        service.save(eidolon);

        return ResponseEntity.ok("Eidolon creado con éxito.");
    }

    @Operation(summary = "Actualizar un curso existente", description = "Permite actualizar los datos de un curso existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping("/updateByNombre")
    public ResponseEntity<List<Eidolon>> updateByNombre(@RequestBody Map<String, String> updates) {
        String nombrePersonaje = updates.get("nombrePersonaje");

        if (nombrePersonaje == null || nombrePersonaje.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        List<Eidolon> eidolons = service.findByNombre(nombrePersonaje);
        if (eidolons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        for (Eidolon eidolon : eidolons) {
            if (updates.containsKey("e1")) eidolon.setE1(updates.get("e1"));
            if (updates.containsKey("e2")) eidolon.setE2(updates.get("e2"));
            if (updates.containsKey("e3")) eidolon.setE3(updates.get("e3"));
            if (updates.containsKey("e4")) eidolon.setE4(updates.get("e4"));
            if (updates.containsKey("e5")) eidolon.setE5(updates.get("e5"));
            if (updates.containsKey("e6")) eidolon.setE6(updates.get("e6"));
            service.save(eidolon);
        }

        return ResponseEntity.ok(eidolons);
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
