package cevaja.model.dto;

import cevaja.model.Usuario;

public class UsuarioConverter {

    public static Usuario converterParaEntidade(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuarioEntity.setDataDeNascimento(usuarioRequestDTO.getDataDeNascimento());
        usuarioEntity.setCpf(usuarioRequestDTO.getCpf());
        usuarioEntity.setUsernameLogin(usuarioRequestDTO.getUsernameLogin());

        return usuarioEntity;
    }

}
