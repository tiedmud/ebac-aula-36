package br.com.ebac.ebac_modulo_50.repository;

import br.com.ebac.ebac_modulo_50.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsuario(String usuario);
}
