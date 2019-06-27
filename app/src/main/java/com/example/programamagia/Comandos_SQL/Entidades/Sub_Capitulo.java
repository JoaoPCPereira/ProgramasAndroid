package com.example.programamagia.Comandos_SQL.Entidades;

public class Sub_Capitulo {

    private Integer Id_Sub_Cap;
    private String Nome;
    private Integer Id_Cap;
    private String Obs;


    public Sub_Capitulo() {

        this.setId_Cap(null);
        this.setNome(null);
        this.setObs(null);

    }


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

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public Integer getId_Sub_Cap() {
        return Id_Sub_Cap;
    }

    public void setId_Sub_Cap(Integer id_Sub_Cap) {
        Id_Sub_Cap = id_Sub_Cap;
    }
    @Override
    public String toString() {
        return this.getNome() + " | " + this.getId_Cap() + " | " + this.getObs();
    }
}
