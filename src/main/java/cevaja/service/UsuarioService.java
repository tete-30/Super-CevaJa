package cevaja.service;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.converter.UsuarioConverter;
import cevaja.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPeloNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public void adicionar(UsuarioRequestDTO usuarioRequestDTO) {
        String nomeUsuarioAdicionado = usuarioRequestDTO.getNome();
        Usuario usuarioExistente = buscarPeloNome(nomeUsuarioAdicionado);

        // Verificar se usuário existe
        if (usuarioExistente != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possivel adicionar um usuário repetido. O usuário "
                    + nomeUsuarioAdicionado + "já existe no banco de dados.");
        } else {
            Usuario usuarioEntity = UsuarioConverter.converterParaEntidade(usuarioRequestDTO);
            usuarioRepository.save(usuarioEntity);
        }
    }

    public Usuario buscarPeloLogin(String usernameLogin) {
        return usuarioRepository.findByNome(usernameLogin);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario removerPorLogin(String usernameLogin) {
        Usuario usuarioRemoverPorLogin = usuarioRepository.findByUsernameLogin(usernameLogin);
        if (usuarioRemoverPorLogin == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possivel remover um usuario inexistente. O usuario " + usernameLogin + " não existe no banco de dados.");
        } else {
            usuarioRepository.delete(usuarioRemoverPorLogin);
        }
        return usuarioRemoverPorLogin;
    }


    public Usuario alterarNomeESobrenome(Long id, Usuario usuario) {
        Usuario usuarioParaAlterar = usuarioRepository.findById(id).get();
        if (usuarioParaAlterar == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possivel alterar um usuario inexistente. O usuario " + usuario.getNome() + " não existe no banco de dados.");

        } else {
            usuarioParaAlterar.setNome(usuario.getNome());
            usuarioParaAlterar.setSobrenome(usuario.getSobrenome());
            usuarioRepository.save(usuarioParaAlterar);

            return usuarioParaAlterar;
        }


    }
}

