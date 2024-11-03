package br.edu.utfpr.cp.espjava.crudcidades.usuario;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record UsuarioRequestDTO(
                String nome,
                String senha,
                List<String> papeis) {

        public Usuario toEntity() {
                final BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setSenha(cifrador.encode(senha));
                usuario.setPapeis(papeis);
                return usuario;
        }
}
