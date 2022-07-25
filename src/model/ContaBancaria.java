package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

//Estou informando que essa classe é abstrata apenas serve para modelo e não pode ser instanciada.
public abstract class ContaBancaria {


    //#region Atributos

    //Atributos: O que tem dentro da conta bancária.
    protected String agencia;

    protected String conta;

    protected Integer digito;

    protected Date dataAbertura;

    protected ArrayList <Movimentacao> movimentacoes;

    protected Double VALOR_MINIMO_DEPOSITO = 10.0; // Toda constante tem que ser escrita em maíuscul e separada por_.

    //# endregion

    //regionConstrutores
    //Construtor: a forma que o objeto será construido.

    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        //Estou instanciando o meu Array se não ele vai dar um erro de nullPointerException.
        this.movimentacoes = new ArrayList<Movimentacao>();

        //Criando a primeira movimentação.
        Movimentacao movimentacao = new Movimentacao("Abertura de conta",saldoInicial);

        //Estou salvando a movimentação dentro do meu array de movimentações.
        //Estou iniciando meu extrato bancário.
        this.movimentacoes.add(movimentacao);

    }
    //endregion

    //#regionGetters e Setters
    // Getters e Setters : Metódos de acesso aos atributos

    private Double saldo;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    //#endregion

    //#regionMetódos
    //Metódos: São recursos dentro de uma classe ou objeto que transformam ou geram comportamentos.

    public void depositar(Double valor){

        // Verifica se o valor de depósito é menor que o valor mínimo e se for não havera depósito.

        if(valor < VALOR_MINIMO_DEPOSITO){
            throw new InputMismatchException("O valor mínimo de deposito é R$ " + VALOR_MINIMO_DEPOSITO);
        }

        // Efetua o depósito somando o valor ao saldo.
        this.saldo += valor;

        // Faço uma movimentação no extrato.

        Movimentacao movimentacao = new Movimentacao("Deposito",valor);
        this.movimentacoes.add(movimentacao);

    }

    public Double sacar(Double valor){

        // Verifica se o valor é maior que o saldo da conta se for ele notifica que o saldo é insuficiente.
        if(valor > this.saldo){
            throw new InputMismatchException("O saldo é insuficiente!");
        }

        // Subtraimos o valor de saque do saldo atual.
        this.saldo -= valor;

        Movimentacao movimentacao = new Movimentacao("Retirada de valor",valor);
        this.movimentacoes.add(movimentacao);

        // Retorna o valor sacado.
        return valor;

    }

    public void transferir(Double valor, ContaBancaria contaDestino){

        //Efetua um saque na conta atual.
        this.sacar(valor);

        //Efetua o depósito na conta de destino.
        contaDestino.depositar(valor);


    }

    //#endregion

    // Metódo abstrato não tem implementação só damos nome a ele.
    //Quem herdar esse metódo da classe (ContaBancaria) é obrigado implementar esse metódo.
    public abstract void ImprimirExtrato();

}
