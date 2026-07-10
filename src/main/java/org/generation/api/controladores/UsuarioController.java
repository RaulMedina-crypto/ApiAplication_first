package org.generation.api.controladores;

import org.generation.api.dto.PassDto;
import org.generation.api.modelos.Usuario;
import org.generation.api.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }//getUsuarios

    @GetMapping(path = "{usuarioId}")
    public Usuario getUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.getUsuario(id);
    }//getUsuario

    @DeleteMapping(path = "{usuarioId}")
    public Usuario deleteUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.deleteUsuario(id);
    }//deleteUsuario

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }//crearUsuario

    @PutMapping(path = "{usuarioId}")
    public Usuario actualizarUsuario(@PathVariable("usuarioId") Long id,
                                     @RequestBody PassDto dto) {
return usuarioService.actualizarUsuario(id, dto);
    }//actualizarUsuario

}//class Controller
