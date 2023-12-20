package cevaja.model.dto.converter;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;

public class UsuarioConverter {

    public static Usuario converterParaEntidade(UsuarioRequestDTO usuarioDto) {
        Usuario usuarioEntity = new Usuario();

        usuarioEntity.setNome(usuarioDto.getNome());
        usuarioEntity.setSobrenome(usuarioDto.getSobrenome());
        usuarioEntity.setDataDeNascimento(usuarioDto.getDataDeNascimento());
        usuarioEntity.setCpf(usuarioDto.getCpf());
        usuarioEntity.setUsernameLogin(usuarioDto.getUsernameLogin());
        usuarioEntity.setSenha(usuarioDto.getSenha());
        return usuarioEntity;
    }
}
