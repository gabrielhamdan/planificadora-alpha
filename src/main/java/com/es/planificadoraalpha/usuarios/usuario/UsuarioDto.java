package com.es.planificadoraalpha.usuarios.usuario;

public record UsuarioDto(
        int id,
        String usuario,
        String nome,
        String cpf,
        String area
) {
}
