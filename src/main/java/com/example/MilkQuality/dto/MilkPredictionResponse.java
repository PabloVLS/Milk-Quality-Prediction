package com.example.MilkQuality.dto;

public class MilkPredictionResponse {
    private String nota;
    private String descricao;
    private boolean sucesso;

    // Construtor padrão
    public MilkPredictionResponse() {
    }

    // Construtor com campos
    public MilkPredictionResponse(String nota, String descricao, boolean sucesso) {
        this.nota = nota;
        this.descricao = descricao;
        this.sucesso = sucesso;
    }

    // Getters e Setters
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    @Override
    public String toString() {
        return "MilkPredictionResponse{" +
                "nota='" + nota + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sucesso=" + sucesso +
                '}';
    }
}
