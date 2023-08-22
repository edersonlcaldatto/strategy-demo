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

@Service
public class SimulacaoService {

    public SimulacaoResponse simularFinanciamentoBancario(SimulacaoRequest simulacaoRequest) {

        var opcoes = new ArrayList<BancoSimulacao>();

        var sicredi = new Sicredi();
        opcoes.add(fazSimulacao(sicredi.getNome(), sicredi, simulacaoRequest));

        var roxo = new BancoRoxo();
        opcoes.add(fazSimulacao(roxo.getNome(), roxo, simulacaoRequest));

        var laranja = new BancoLaranja();
        opcoes.add(fazSimulacao(laranja.getNome(), laranja, simulacaoRequest));

        return new SimulacaoResponse(simulacaoRequest, opcoes);
    }

    private BancoSimulacao fazSimulacao(String nomeBanco, JurosStrategy strategy, SimulacaoRequest simulacaoRequest) {
        var simuladorSicredi = new SimuladorFinanciamento(strategy);
        return new BancoSimulacao(nomeBanco, simuladorSicredi.taxaJuros(simulacaoRequest),  simuladorSicredi.simular(simulacaoRequest));
    }
}
