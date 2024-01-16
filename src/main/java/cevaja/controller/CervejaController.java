package cevaja.controller;

import cevaja.model.TipoCerveja;
import cevaja.model.dto.TipoCervejaDTO;
import cevaja.service.CervejaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/cervejas")
public class CervejaController {
    private CervejaService cervejaService;

    public CervejaController(CervejaService cervejaService) {
        this.cervejaService = cervejaService;
    }

    @GetMapping("/tipos")
    public ResponseEntity<List<TipoCervejaDTO>> getTiposCervejas() {
        List<TipoCervejaDTO> tipoCervejas = cervejaService.listaTiposCervejas();
        return ResponseEntity.ok(tipoCervejas);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<TipoCerveja> removerTipoCervejaPeloNome (@PathVariable("nome") String nome){
        TipoCerveja tipoCervejaRemovido = cervejaService.removerPeloNome(nome);
        return new ResponseEntity<>(tipoCervejaRemovido, HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<TipoCerveja> alterarValorTipoCerveja(@RequestBody TipoCervejaDTO tipoCervejaDTO) {
        String nomeCerveja = tipoCervejaDTO.getNome();
        BigDecimal valorCerveja = tipoCervejaDTO.getValor();
        TipoCerveja tipoCervejaAlterado = cervejaService.alterarValorTipoCerveja(nomeCerveja, valorCerveja);
        return new ResponseEntity<>(tipoCervejaAlterado, HttpStatus.NO_CONTENT);
    }




}