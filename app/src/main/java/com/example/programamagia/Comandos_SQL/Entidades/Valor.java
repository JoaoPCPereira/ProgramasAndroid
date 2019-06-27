package com.example.programamagia.Comandos_SQL.Entidades;

public class Valor {

    private Integer Id_Valores;
    private Truque truque;
    private Sub_Capitulo sub_Cap;
    private String Valor;
    private String Obs;

    public Valor(){

        this.setTruque(null);
        this.setSub_Cap(null);
        this.setValor(null);
        this.setObs(null);

    }



    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public Integer getId_Valores() {
        return Id_Valores;
    }

    public void setId_Valores(Integer id_Valores) {
        Id_Valores = id_Valores;
    }

    @Override
    public String toString() {
        return this.sub_Cap.getNome() + " | " + this.truque.getNome() + " | " + this.getValor();
    }

    public Truque getTruque() {
        return truque;
    }

    public void setTruque(Truque truque) {
        this.truque = truque;
    }

    public Sub_Capitulo getSub_Cap() {
        return sub_Cap;
    }

    public void setSub_Cap(Sub_Capitulo sub_Cap) {
        this.sub_Cap = sub_Cap;
    }
}