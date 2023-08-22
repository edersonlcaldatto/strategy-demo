package com.br.strategydemo.strategy.juros.api;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.api.response.SimulacaoResponse;
import com.br.strategydemo.strategy.juros.service.SimulacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulador")
public class SimulacaoApi {

    private SimulacaoService simulacaoService;

    public SimulacaoApi(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @PostMapping
    public ResponseEntity<SimulacaoResponse> simularFinanciamento(@RequestBody SimulacaoRequest simulacaoRequest) {
        return ResponseEntity.ok(simulacaoService.simularFinanciamentoBancario(simulacaoRequest));
    }

}
