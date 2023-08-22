package com.br.strategydemo.strategy.juros.domain;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.strategy.JurosStrategy;
import com.br.strategydemo.strategy.juros.utils.JurosService;

import java.math.BigDecimal;

public class Sicredi extends Banco implements JurosStrategy {

    public Sicredi() {
        this.nome = "Sicredi";
    }

    @Override
    public BigDecimal juroPorPrazo(SimulacaoRequest simulacaoRequest) {
        return switch (simulacaoRequest.prazo()) {
            case 12 -> new BigDecimal("0.5");
            case 24 -> new BigDecimal("0.8");
            case 36 -> new BigDecimal("1.1");
            case 48 -> new BigDecimal("1.5");
            case 60 -> new BigDecimal("2.2");
            default -> new BigDecimal("2.8");
        };
    }

    @Override
    public BigDecimal valorComJuros(SimulacaoRequest simulacaoRequest) {
        return JurosService.valorComJuros(simulacaoRequest, juroPorPrazo(simulacaoRequest));
    }
}
