package com.br.strategydemo.StrategyWithEnum.domain;

import java.math.BigDecimal;

public class DescontoStrategyDemo {

    public static void main(String[] args) {

        var pedido = new Pedido(new BigDecimal("138"));
        var aprovador = new Aprovador("Joao", PerfilEnum.VENDEDOR );

        var desconto = pedido.valor().multiply(aprovador.perfil().getMaxPercentualDesconto());

        System.out.println(desconto);
    }

}
