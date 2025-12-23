package br.com.ebac.ebac_modulo_50.builder;

import br.com.ebac.ebac_modulo_50.response.UsuarioResponse;

public class UsuarioResponseBuilder {
    private Integer id;
    private String usuario;
    private String senha;

    public static UsuarioResponseBuilder create() {
        return new UsuarioResponseBuilder();
    }

    public UsuarioResponseBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UsuarioResponseBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public UsuarioResponseBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioResponse build() {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setUsuario(usuario);
        usuarioResponse.setSenha(senha);
        return usuarioResponse;
    }
}
