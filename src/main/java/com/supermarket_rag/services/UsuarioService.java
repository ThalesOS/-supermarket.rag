package com.supermarket_rag.services;

import com.supermarket_rag.models.Usuario;
import com.supermarket_rag.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    public Usuario cadastrarUsuario (Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("Já existe um usuario cadastrado com esse email");
        }else{
            return usuarioRepository.save(usuario);
        }
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deleteById(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario updateById(Long id, Usuario dadosnovos){

        if (usuarioRepository.existsById(id)){

            Usuario usuario = findById(id);
            usuario.setNome(dadosnovos.getNome());
            usuario.setRole(dadosnovos.getRole());
            return usuarioRepository.save(usuario);

        }else{
            throw new RuntimeException("Usuário não encontrado");
        }



    }



}
