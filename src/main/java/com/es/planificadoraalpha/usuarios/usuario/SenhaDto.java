package com.es.planificadoraalpha.usuarios.usuario;

public record SenhaDto(
        int idUsuario,
        String novaSenha,
        String confirmacaoSenha
) {
}
