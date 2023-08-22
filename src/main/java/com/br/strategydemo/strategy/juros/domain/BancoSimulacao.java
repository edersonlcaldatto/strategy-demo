package com.br.strategydemo.strategy.juros.domain;

import java.math.BigDecimal;

public record BancoSimulacao(String banco,
                             BigDecimal taxaJuro,
                             BigDecimal valorCalculado) {
}
