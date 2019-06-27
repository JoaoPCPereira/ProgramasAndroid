package com.example.programamagia.Comandos_SQL.Entidades;

public class Evento {

            private Integer Id_Evento;
            private Integer Id_Cliente;
            private String Data;
            private String Obs;

            public Evento(){

                this.setId_Cliente(null);
                this.setData(null);

            }


    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Integer getId_Evento() {
        return Id_Evento;
    }

    public void setId_Evento(Integer id_Evento) {
        Id_Evento = id_Evento;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }
}
