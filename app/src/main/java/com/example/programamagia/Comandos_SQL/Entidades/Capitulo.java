package com.example.programamagia.Comandos_SQL.Entidades;

public class Capitulo {

    private Integer Id_Cap;
    private String Nome;
    private String Obs;

    public Capitulo(){
        this.setId_Cap(0);
        this.setNome("");
        this.setObs("");

    };

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getId_Cap() {
        return Id_Cap;
    }

    public void setId_Cap(Integer id_Cap) {
        Id_Cap = id_Cap;
    }
    @Override
    public String toString() {
        return this.getNome();
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }
}
