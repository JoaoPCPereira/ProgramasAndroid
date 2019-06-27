package com.example.programamagia.Comandos_SQL.Entidades;

public class Espectaculo {

            private Integer Id_Espectaculo;
            private String Nome;
            private String Tipo;
            private String Duracao;
            private Float Preco;
            private String Obs;

            public Espectaculo(){

                this.setNome(null);
                this.setTipo(null);
                this.setDuracao(null);
                this.setPreco(null);
                this.setObs(null);

            }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDuracao() {
        return Duracao;
    }

    public void setDuracao(String duracao) {
        Duracao = duracao;
    }

    public Float getPreco() {
        return Preco;
    }

    public void setPreco(Float preco) {
        Preco = preco;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public Integer getId_Espectaculo() {
        return Id_Espectaculo;
    }

    public void setId_Espectaculo(Integer id_Espectaculo) {
        Id_Espectaculo = id_Espectaculo;
    }
}
