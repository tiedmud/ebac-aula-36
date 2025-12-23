package br.com.ebac.ebac_modulo_50.utils;

import br.com.ebac.ebac_modulo_50.builder.UsuarioResponseBuilder;
import br.com.ebac.ebac_modulo_50.entity.Usuario;
import br.com.ebac.ebac_modulo_50.response.UsuarioResponse;

public class ConvertToResponse {

    public static UsuarioResponse UsuarioToResponse(Usuario u) {
        return
                UsuarioResponseBuilder.create()
                .usuario(u.getUsername())
                .senha(u.getPassword()).build();
    }
}
