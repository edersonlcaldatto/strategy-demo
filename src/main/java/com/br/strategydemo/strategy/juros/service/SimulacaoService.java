package com.br.strategydemo.strategy.juros.service;

import com.br.strategydemo.strategy.juros.api.request.SimulacaoRequest;
import com.br.strategydemo.strategy.juros.api.response.SimulacaoResponse;
import com.br.strategydemo.strategy.juros.domain.BancoLaranja;
import com.br.strategydemo.strategy.juros.domain.BancoRoxo;
import com.br.strategydemo.strategy.juros.domain.BancoSimulacao;
import com.br.strategydemo.strategy.juros.domain.Sicredi;
import com.br.strategydemo.strategy.juros.strategy.JurosStrategy;
import com.br.strategydemo.strategy.juros.strategy.SimuladorFinanciamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulacaoService {

    public SimulacaoResponse simularFinanciamentoBancario(SimulacaoRequest simulacaoRequest) {

        var opcoesSimulacao = new ArrayList<BancoSimulacao>();
        var bancosDisponives = List.of(new Sicredi(), new BancoRoxo(), new BancoLaranja());

        bancosDisponives.forEach(banco -> {
            opcoesSimulacao.add(fazSimulacao(banco.getNome(), banco, simulacaoRequest));
        });
        return new SimulacaoResponse(simulacaoRequest, opcoesSimulacao);
    }

    private BancoSimulacao fazSimulacao(String nomeBanco, JurosStrategy strategy, SimulacaoRequest simulacaoRequest) {
        var simuladorSicredi = new SimuladorFinanciamento(strategy);
        return new BancoSimulacao(nomeBanco, simuladorSicredi.taxaJuros(simulacaoRequest),  simuladorSicredi.simular(simulacaoRequest));
    }
}
