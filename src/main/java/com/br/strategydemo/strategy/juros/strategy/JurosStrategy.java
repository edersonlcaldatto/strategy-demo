package com.br.strategydemo.strategy.juros.strategy;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;

import java.math.BigDecimal;

public interface JurosStrategy {

    BigDecimal juroPorPrazo(SimulacaoRequest simulacaoRequest);
    BigDecimal valorComJuros(SimulacaoRequest simulacaoRequest);

}
