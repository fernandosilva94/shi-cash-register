package com.shi.shicash.controllers;

import com.shi.shicash.dto.UsuarioDTO;
import com.shi.shicash.models.UsuarioModel;
import com.shi.shicash.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) throws Exception {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuarioModel));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid UsuarioDTO usuarioDTO) throws Exception {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);

        usuarioModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.salvarUsuario(usuarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) throws Exception  {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        usuarioService.deleteUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario" + usuarioModel.getNome() + "foi deletado.");
    }
}
