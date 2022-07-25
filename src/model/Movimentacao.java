package model;

import utils.DataUtil;

import java.util.Date;

// Criando os atributos da classe movimentação.
public class Movimentacao {
    private String descricao;

    private Date data;

    private Double valor;

    //Criando os contrutores.

    public Movimentacao(String descricao, Double valor) {
        this.descricao = descricao;
        this.data = new Date();
        this.valor = valor;
    }

    // Criando os Getters e Setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    //Anotação para dizer que estou sobre escrevendo o Tostring.
    // Descrição
    // Data e hora - Valor

    @Override
    public String toString(){
        String dataFormatada = DataUtil.converterDateParaDataEHora(this.getData());
        return this.getDescricao() + "\n" + dataFormatada + " - R$" + this.valor;


    }


}
