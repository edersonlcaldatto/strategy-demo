package com.br.strategydemo.StrategyWithEnum.domain;

import java.math.BigDecimal;

public enum PerfilEnum {

    VENDEDOR {
        public BigDecimal getMaxPercentualDesconto(){
            return new BigDecimal("0.03");
        }
    },
    GERENTE {
        public BigDecimal getMaxPercentualDesconto() {
            return new BigDecimal("0.10");
        }
    },
    DIRETOR {
        public BigDecimal getMaxPercentualDesconto(){
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal getMaxPercentualDesconto();


}
