package com.br.strategydemo.strategy.juros.utils;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;

import java.math.BigDecimal;

public abstract class JurosService {

    public static BigDecimal valorComJuros(SimulacaoRequest simulacao, BigDecimal juroPorPrazo){
        var juroCalculado = juroPorPrazo.divide(BigDecimal.valueOf(100));
        var valorJuro = simulacao.valorSimulado().multiply(juroCalculado).multiply( BigDecimal.valueOf(simulacao.prazo()));
        return simulacao.valorSimulado().add(valorJuro);
    }
}
