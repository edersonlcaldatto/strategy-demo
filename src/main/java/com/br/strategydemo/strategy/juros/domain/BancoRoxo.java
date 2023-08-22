package com.br.strategydemo.strategy.juros.domain;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.strategy.JurosStrategy;
import com.br.strategydemo.strategy.juros.utils.JurosService;

import java.math.BigDecimal;

public class BancoRoxo extends Banco implements JurosStrategy {

    public BancoRoxo() {
        this.nome = "Nubank";
    }

    @Override
    public BigDecimal juroPorPrazo(SimulacaoRequest simulacaoRequest) {
        return switch (simulacaoRequest.prazo()) {
            case 12 -> new BigDecimal("1.1");
            case 24 -> new BigDecimal("1.6");
            case 36 -> new BigDecimal("2.0");
            case 48 -> new BigDecimal("2.4");
            case 60 -> new BigDecimal("2.9");
            default -> new BigDecimal("3.4");
        };
    }

    @Override
    public BigDecimal valorComJuros(SimulacaoRequest simulacaoRequest) {
        return JurosService.valorComJuros(simulacaoRequest, juroPorPrazo(simulacaoRequest));
    }

}
