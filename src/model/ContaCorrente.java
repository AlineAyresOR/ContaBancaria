package model;

//Herança: ContaCorrente está herdando tudo de ContaBancaria.

import utils.DataUtil;

import java.util.Date;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String agencia, String conta, Integer digito, Double saldoInicial) {
        // metódo super cria uma (ContaCorrente) filho por baixo com os mesmos atributos do pai (ContaBancaria).
        super(agencia, conta, digito, saldoInicial);
    }

    @Override
    public void ImprimirExtrato() {

        System.out.println("*****************************************");
        System.out.println("************Extrato Bancario*************");
        System.out.println("*****************************************");
        System.out.println();

        System.out.println("Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes) {
            System.out.println(movimentacao);
            System.out.println();
        }


            System.out.println();
            System.out.println("*****************************************");
            System.out.println("*****************************************");
            System.out.println("*****************************************");

        }



    }

