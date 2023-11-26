package paginawebveterinaria.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import paginawebveterinaria.entities.UsuarioEntity;
import paginawebveterinaria.services.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired private UsuarioService usuarioService;

    //FUNCION BUSQUEDA
    @GetMapping("/busqueda1")
    public ResponseEntity<List<UsuarioEntity>> busquedaTabellaPrueba1(
        @RequestParam(required = false) Integer  id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email
    ) 
    {
        List<UsuarioEntity> result = usuarioService.busqueda_tabla_prueba_1(id, name, email);
        System.out.println(result);

        return ResponseEntity.ok(result);
    }

   
}
