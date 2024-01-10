package cevaja.controller;

import cevaja.model.dto.converter.TipoCervejaDTO;
import cevaja.service.CervejaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}