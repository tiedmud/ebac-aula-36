package br.com.ebac.ebac_modulo_50.service;

import br.com.ebac.ebac_modulo_50.entity.Usuario;
import br.com.ebac.ebac_modulo_50.repository.UsuarioRepository;
import br.com.ebac.ebac_modulo_50.request.UsuarioRequest;
import br.com.ebac.ebac_modulo_50.response.UsuarioResponse;
import br.com.ebac.ebac_modulo_50.utils.ConvertToResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(final UsuarioRepository categoriaRepository, final PasswordEncoder passwordEncoder) {
        this.repository = categoriaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponse> listarTodos() {
        List<Usuario> categorias = repository.findAll();
        List<UsuarioResponse> response = new ArrayList<>();

        categorias.forEach(c -> response.add(ConvertToResponse.UsuarioToResponse(c)));

        return response;
    }

    public void deletarTodos() throws Exception {
        repository.deleteAll();
    }

    public void testar() {
        Usuario usuario1 = new Usuario();
        usuario1.setUsuario("ricardo");
        usuario1.setSenha("123");
        repository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setUsuario("luiza");
        usuario2.setSenha("456");
        repository.save(usuario2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    public void criarUsuario(UsuarioRequest request) {
        Usuario u = new Usuario();
        u.setUsuario(request.getUsuario());
        u.setSenha(passwordEncoder.encode(request.getSenha()));

        repository.save(u);
    }

    public void deletarUsuarioPorId(String id) {
        repository.deleteById(UUID.fromString(id));
    }
}
