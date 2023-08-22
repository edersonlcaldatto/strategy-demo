package com.br.strategydemo.strategy.juros.api.response;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.domain.BancoSimulacao;

import java.util.List;

public record SimulacaoResponse(SimulacaoRequest request,
                                List<BancoSimulacao> opcoes) {
}
