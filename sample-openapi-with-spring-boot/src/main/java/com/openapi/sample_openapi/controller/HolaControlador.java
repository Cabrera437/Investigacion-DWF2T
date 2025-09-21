package com.openapi.sample_openapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Hola")
public class HolaControlador {

    private final List<String> saludos = new ArrayList<>();

    @Operation(
        summary = "Saludo personalizado",
        description = "Devuelve un mensaje de bienvenida personalizado usando el nombre proporcionado"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saludo generado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Falta el parámetro 'name'")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloworld(
        @Parameter(description = "Nombre del usuario para el saludo", required = true)
        @RequestParam String name
    ) {
        return "Hola bienvenido, " + name + ". Bienvenido a la interfaz de OpenAPI!";
    }

    @Operation(
        summary = "Guardar saludo",
        description = "Guarda un saludo personalizado en memoria"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saludo guardado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Falta el parámetro 'name'")
    })
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String guardarSaludo(
        @Parameter(description = "Nombre del usuario para guardar el saludo", required = true)
        @RequestParam String name
    ) {
        String saludo = "Hola bienvenido, " + name + ". Bienvenido a la interfaz de OpenAPI!";
        saludos.add(saludo);
        return "Saludo guardado: " + saludo;
    }

    @Operation(
        summary = "Eliminar saludo",
        description = "Elimina un saludo por nombre si existe en memoria"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saludo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontró el saludo")
    })
    @DeleteMapping
    public String eliminarSaludo(
        @Parameter(description = "Nombre del usuario cuyo saludo se desea eliminar", required = true)
        @RequestParam String name
    ) {
        String saludo = "Hola bienvenido, " + name + ". Bienvenido a la interfaz de OpenAPI!";
        if (saludos.remove(saludo)) {
            return "Saludo eliminado: " + saludo;
        } else {
            return "No se encontró el saludo para: " + name;
        }
    }
}
