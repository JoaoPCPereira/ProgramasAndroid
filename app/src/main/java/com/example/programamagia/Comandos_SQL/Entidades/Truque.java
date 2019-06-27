package com.example.programamagia.Comandos_SQL.Entidades;

public class Truque {

    private Integer Id_Truque;
    private String Nome;
    private String Obs;

    public Truque(){
        this.setNome("");
        this.setObs("");


    };


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getId_Truque() {
        return Id_Truque;
    }

    public void setId_Truque(Integer id_Truque) {
        Id_Truque = id_Truque;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }
}
