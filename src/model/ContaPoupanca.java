package model;

import utils.DataUtil;

import java.util.Date;

public class ContaPoupanca extends ContaBancaria{

    // Isso significa que ContaPoupanca vai utilizar tudo que ContaBancaria tem.
    public ContaPoupanca(String agencia, String conta, Integer digito, Double saldoInicial) {
        super(agencia, conta, digito, saldoInicial);
    }

    @Override
    public void ImprimirExtrato() {
        System.out.println("*****************************************");
        System.out.println("************Extrato Poupanca*************");
        System.out.println("*****************************************");
        System.out.println();

        System.out.println("Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes) {
            System.out.println(movimentacao);
            System.out.println();
        }


        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("*****************************************");


    }
}
