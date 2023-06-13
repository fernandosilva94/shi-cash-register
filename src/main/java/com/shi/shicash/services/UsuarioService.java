package com.shi.shicash.services;

import com.shi.shicash.models.UsuarioModel;
import com.shi.shicash.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioModel usuarioModel;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioModel salvarUsuario(UsuarioModel usuario) throws Exception {
        try{
            if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
                throw new Exception("O nome é obrigatório.");
            } else if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                throw new Exception("O email é obrigatório.");
            } else if (usuario.getDocNumero() == null || usuario.getDocNumero().isEmpty()) {
                throw new Exception("O documento é obrigatória.");
            }else if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
                throw new Exception("A senha é obrigatória.");
            }
        } catch (Exception e) {
            throw new Exception("Usuário não encontrado.");
        }

        return usuarioRepository.save(usuarioModel);
    }


    public Optional<UsuarioModel> findById(Long id) throws Exception {
        Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(id);
        try {
            if (usuarioModelOptional.isPresent()) {
                return usuarioModelOptional;
            }
        } catch (Exception e) {
            throw new Exception("Usuário não encontrado.");
        }
        return usuarioModelOptional;
    }

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void deleteUsuario(UsuarioModel usuarioModel) throws Exception {
        try{
            if (usuarioModel.getId() == null) {
                throw new Exception("O nome é obrigatório.");
            }
            else {
                usuarioRepository.delete(usuarioModel);
            }
        } catch (Exception e) {
            throw new Exception("Usuário não encontrado.");
        }
        usuarioRepository.delete(usuarioModel);
    }
}
