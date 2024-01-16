package cevaja.model.dto;

import cevaja.model.TipoCerveja;
import cevaja.model.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class PedidosDTO {

    private Usuario usuario;
    private List<TipoCerveja> tipoCerveja;
}

