package com.br.strategydemo.strategy.juros.strategy;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SimuladorFinanciamento {

    private final Logger logger = LoggerFactory.getLogger(SimuladorFinanciamento.class);

    JurosStrategy jurosStrategy;
    public SimuladorFinanciamento(JurosStrategy jurosStrategy) {
        this.jurosStrategy = jurosStrategy;
    }

    public BigDecimal simular(SimulacaoRequest simulacaoRequest) {
        logger.info("Dados da simulacao: {}", simulacaoRequest);
        logger.info("Juro calculado para o prazo: {}", jurosStrategy.juroPorPrazo(simulacaoRequest));
        return jurosStrategy.valorComJuros(simulacaoRequest);
    }

    public BigDecimal taxaJuros(SimulacaoRequest simulacaoRequest) {
        return jurosStrategy.juroPorPrazo(simulacaoRequest);
    }


}
