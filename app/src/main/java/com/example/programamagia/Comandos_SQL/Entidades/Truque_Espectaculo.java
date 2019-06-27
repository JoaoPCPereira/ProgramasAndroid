package com.example.programamagia.Comandos_SQL.Entidades;

public class Truque_Espectaculo {

            private Integer Id_Truque_Espectaculos;
            private Integer Id_Truque;
            private Integer Id_Espectaculo;
            private String Obs;

           public Truque_Espectaculo(){

               this.setId_Espectaculo(null);
               this.setId_Truque(null);
               this.setObs(null);

           }


    public Integer getId_Truque() {
        return Id_Truque;
    }

    public void setId_Truque(Integer id_Truque) {
        Id_Truque = id_Truque;
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

    public Integer getId_Truque_Espectaculos() {
        return Id_Truque_Espectaculos;
    }

    public void setId_Truque_Espectaculos(Integer id_Truque_Espectaculos) {
        Id_Truque_Espectaculos = id_Truque_Espectaculos;
    }
}
