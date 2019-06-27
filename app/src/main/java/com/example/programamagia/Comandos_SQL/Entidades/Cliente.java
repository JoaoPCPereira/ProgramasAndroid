package com.example.programamagia.Comandos_SQL.Entidades;

public class Cliente {

            private Integer Id_Cliente;
            private String Nome;
            private Integer Numero;
            private String Email;
            private String Obs;

        public Cliente(){

            this.setNome(null);
            this.setNumero(null);
            this.setEmail(null);
            this.setObs(null);

        }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }
}
