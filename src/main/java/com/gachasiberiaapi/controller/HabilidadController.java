package com.gachasiberiaapi.controller;

import com.gachasiberiaapi.entity.HabilidadStarrail;
import com.gachasiberiaapi.entity.StarrailPersonaje;
import com.gachasiberiaapi.service.HabilidadService;
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
@RequestMapping("/api/gachasIberia/habilidad")
public class HabilidadController {
    private final HabilidadService service;
    private final PersonajeService personajeService;

    public HabilidadController(PersonajeService personajeService, HabilidadService service) {
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
    public ResponseEntity<List<HabilidadStarrail>> findAll() {
        List<HabilidadStarrail> manufacturers = this.service.findAll();
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
    public ResponseEntity<List<HabilidadStarrail>> findByTitulo(@PathVariable String nombre) {
        List<HabilidadStarrail> encontrado = this.service.findByNombre(nombre);

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
    public ResponseEntity<String> create(@RequestBody HabilidadStarrail dto) {
        String nombre = dto.getNombre();

        List<StarrailPersonaje> personajeList = personajeService.findByNombre(nombre);
        if (personajeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El personaje no existe.");
        }

        if (!service.findByNombre(nombre).isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un Eidolon para ese personaje.");
        }

        StarrailPersonaje personaje = personajeList.get(0);

        HabilidadStarrail habilidad = new HabilidadStarrail();
        habilidad.setPersonaje(personaje);
        habilidad.setNombre(personaje.getNombre());
        habilidad.setNombreAtaqueBasico(dto.getNombreAtaqueBasico());
        habilidad.setDescripcionAtaqueBasico((dto.getDescripcionAtaqueBasico()));
        habilidad.setNombreHabilidadBasica(dto.getNombreHabilidadBasica());
        habilidad.setdescripcionHabilidadBasico(dto.getdescripcionHabilidadBasico());
        habilidad.setNombreDefinitiva(dto.getNombreDefinitiva());
        habilidad.setDescripcionDefinitiva(dto.getDescripcionDefinitiva());
        habilidad.setNombreTalento(dto.getNombreTalento());
        habilidad.setDescripcionTalento(dto.getDescripcionTalento());
        habilidad.setNombreTecnica(dto.getNombreTecnica());
        habilidad.setDescripcionTecnica(dto.getDescripcionTecnica());
        habilidad.setRupturaBasico(dto.getRupturaBasico());
        habilidad.setRupturaHabilidad(dto.getRupturaHabilidad());
        habilidad.setRupturaDefinitiva(dto.getRupturaDefinitiva());
        habilidad.setTipoTalento(dto.getTipoTalento());
        habilidad.setRupturaTecnica(dto.getRupturaTecnica());

        service.save(habilidad);

        return ResponseEntity.ok("Habilidad creada con éxito.");
    }

    @Operation(summary = "Actualizar un curso existente", description = "Permite actualizar los datos de un curso existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping("/updateByNombre")
    public ResponseEntity<List<HabilidadStarrail>> updateByNombre(@RequestBody Map<String, String> updates) {
        String nombrePersonaje = updates.get("nombre");

        if (nombrePersonaje == null || nombrePersonaje.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        List<HabilidadStarrail> habilidades = service.findByNombre(nombrePersonaje);
        if (habilidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        for (HabilidadStarrail habilidad : habilidades) {
            if (updates.containsKey("nombre")) habilidad.setNombre(updates.get("nombre"));
            if (updates.containsKey("nombreAtaqueBasico")) habilidad.setNombreAtaqueBasico(updates.get("nombreAtaqueBasico"));
            if (updates.containsKey("descripcionAtaqueBasico")) habilidad.setDescripcionAtaqueBasico(updates.get("descripcionAtaqueBasico"));
            if (updates.containsKey("nombreHabilidadBasica")) habilidad.setNombreHabilidadBasica(updates.get("nombreHabilidadBasica"));
            if (updates.containsKey("descripcionHabilidadBasico")) habilidad.setdescripcionHabilidadBasico(updates.get("descripcionHabilidadBasico"));
            if (updates.containsKey("nombreDefinitiva")) habilidad.setNombreDefinitiva(updates.get("nombreDefinitiva"));
            if (updates.containsKey("descripcionDefinitiva")) habilidad.setDescripcionDefinitiva(updates.get("descripcionDefinitiva"));
            if (updates.containsKey("nombreTalento")) habilidad.setNombreTalento(updates.get("nombreTalento"));
            if (updates.containsKey("descripcionTalento")) habilidad.setDescripcionTalento(updates.get("descripcionTalento"));
            if (updates.containsKey("nombreTecnica")) habilidad.setNombreTecnica(updates.get("nombreTecnica"));
            if (updates.containsKey("descripcionTecnica")) habilidad.setDescripcionTecnica(updates.get("descripcionTecnica"));
            if (updates.containsKey("rupturabasico")) habilidad.setRupturaBasico(updates.get("rupturabasico"));
            if (updates.containsKey("rupturahabilidad")) habilidad.setRupturaHabilidad(updates.get("rupturahabilidad"));
            if (updates.containsKey("rupturadefinitiva")) habilidad.setRupturaDefinitiva(updates.get("rupturadefinitiva"));
            if (updates.containsKey("tipoTalento")) habilidad.setTipoTalento(updates.get("tipoTalento"));
            if (updates.containsKey("rupturatecnica")) habilidad.setRupturaTecnica(updates.get("rupturatecnica"));

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
