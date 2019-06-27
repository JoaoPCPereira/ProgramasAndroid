package com.example.programamagia.Comandos_SQL.Entidades;

public class Esp_Ev {

            private Integer Id_Esp_Ev;
            private Integer Id_Evento;
            private Integer Id_Espectaculo;
            private String Obs;


            public Esp_Ev(){

                this.setId_Espectaculo(null);
                this.setId_Evento(null);
                this.setObs(null);

            }

    public Integer getId_Evento() {
        return Id_Evento;
    }

    public void setId_Evento(Integer id_Evento) {
        Id_Evento = id_Evento;
    }

    public Integer getId_Espectaculo() {
        return Id_Espectaculo;
    }

    public void setId_Espectaculo(Integer id_Espectaculo) {
        Id_Espectaculo = id_Espectaculo;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public Integer getId_Esp_Ev() {
        return Id_Esp_Ev;
    }

    public void setId_Esp_Ev(Integer id_Esp_Ev) {
        Id_Esp_Ev = id_Esp_Ev;
    }
}
