package com.br.strategydemo.strategy.juros.api.request;

import java.math.BigDecimal;

public record SimulacaoRequest(String nome,
                               BigDecimal valorSimulado,
                               Integer prazo) {
}
