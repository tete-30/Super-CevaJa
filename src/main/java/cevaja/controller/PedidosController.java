package cevaja.controller;

import cevaja.model.dto.PedidosDTO;
import cevaja.service.PedidosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("v1")
public class PedidosController {

    private PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }
    @PostMapping("/pedidos")
    public ResponseEntity<BigDecimal> adicionarPedido(@RequestBody PedidosDTO pedidoDTO){
        BigDecimal valorTotalPedido = pedidosService.adicionar(pedidoDTO);
        return new ResponseEntity<>(valorTotalPedido, HttpStatus.CREATED);
    }

}
