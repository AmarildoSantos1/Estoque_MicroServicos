package br.com.mercado.funcionariosservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.funcionariosservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
