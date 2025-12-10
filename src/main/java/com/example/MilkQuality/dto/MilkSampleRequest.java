package com.example.MilkQuality.dto;

public class MilkSampleRequest {
    private double pH;
    private int temperatura;
    private int gosto;
    private int odor;
    private int gordura;
    private int turbidez;
    private int cor;

    // Construtor padrão
    public MilkSampleRequest() {
    }

    // Construtor com todos os campos
    public MilkSampleRequest(double pH, int temperatura, int gosto, int odor, int gordura, int turbidez, int cor) {
        this.pH = pH;
        this.temperatura = temperatura;
        this.gosto = gosto;
        this.odor = odor;
        this.gordura = gordura;
        this.turbidez = turbidez;
        this.cor = cor;
    }

    // Getters e Setters
    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getGosto() {
        return gosto;
    }

    public void setGosto(int gosto) {
        this.gosto = gosto;
    }

    public int getOdor() {
        return odor;
    }

    public void setOdor(int odor) {
        this.odor = odor;
    }

    public int getGordura() {
        return gordura;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public int getTurbidez() {
        return turbidez;
    }

    public void setTurbidez(int turbidez) {
        this.turbidez = turbidez;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "MilkSampleRequest{" +
                "pH=" + pH +
                ", temperatura=" + temperatura +
                ", gosto=" + gosto +
                ", odor=" + odor +
                ", gordura=" + gordura +
                ", turbidez=" + turbidez +
                ", cor=" + cor +
                '}';
    }
}
