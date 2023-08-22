package com.br.strategydemo.strategy.juros.domain;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.strategy.JurosStrategy;
import com.br.strategydemo.strategy.juros.utils.JurosService;

import java.math.BigDecimal;

public class BancoLaranja extends Banco implements JurosStrategy {

    public BancoLaranja() {
        this.nome = "Banco Inter";
    }

    @Override
    public BigDecimal juroPorPrazo(SimulacaoRequest simulacaoRequest) {
        return switch (simulacaoRequest.prazo()) {
            case 12 -> new BigDecimal("1.0");
            case 24 -> new BigDecimal("1.5");
            case 36 -> new BigDecimal("2.0");
            case 48 -> new BigDecimal("2.5");
            case 60 -> new BigDecimal("3.0");
            default -> new BigDecimal("3.8");
        };
    }

    @Override
    public BigDecimal valorComJuros(SimulacaoRequest simulacaoRequest) {
        return JurosService.valorComJuros(simulacaoRequest, juroPorPrazo(simulacaoRequest));
    }

}
