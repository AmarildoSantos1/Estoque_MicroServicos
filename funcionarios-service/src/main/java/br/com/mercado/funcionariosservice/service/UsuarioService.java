package br.com.mercado.funcionariosservice.service;

import br.com.mercado.funcionariosservice.model.Usuario;
import br.com.mercado.funcionariosservice.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repo;

    public Usuario salvar(Usuario obj) {
        return repo.save(obj);
    }

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    public Usuario buscarOuFalhar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário com ID " + id + " não encontrado."));
    }

    public void deletar(Long id) {
        buscarOuFalhar(id); // garante que existe
        repo.deleteById(id);
    }
}
