package com.example.programamagia.BD;


public class SQL {

        static String a ="";

    public static String Create_TBL_Truques() {
        a="Create Table if not exists TBL_Truques (" +
                "Id_Truque Integer Primary Key Autoincrement, " +
                "Nome Text," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Valores() {
        a="Create Table if not exists TBL_Valores (" +
                "Id_Valores Integer Primary Key Autoincrement, " +
                "Id_Truque Integer Constraint FK_Truques_Valores References TBL_Truques(Id_Truque), " +
                "Id_Sub_Cap Integer Constraint FK_Sub_Cap_Valores References TBL_Sub_Capitulo(Id_Sub_Cap), " +
                "Valor Text," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Sub_Capitulo() {
        a="Create Table if not exists TBL_Sub_Capitulo (" +
                "Id_Sub_Cap Integer Primary Key Autoincrement," +
                "Id_Cap Integer Constraint FK_Capitulo_Sub_Cap References TBL_Capitulo(Id_Cap)," +
                "Nome Text," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Capitulo() {
        a="Create Table if not exists TBL_Capitulo (" +
                "Id_Cap Integer Primary Key Autoincrement," +
                "Nome Text," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Truque_Espectaculos() {
        a="Create Table if not exists TBL_Tru_Esp (" +
                "Id_Truque_Espectaculos Integer Primary Key Autoincrement, " +
                "Id_Truque Integer Constraint FK_Truque_Tru_Esp References TBL_Truques(Id_Truque), " +
                "Id_Espectaculo Integer Constraint FK_Espectaculos_Tru_Esp References TBL_Espectaculos(Id_Espectaculo), " +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Espectaculos() {
        a="Create Table if not exists TBL_Espectaculos (" +
                "Id_Espectaculo Integer Primary Key Autoincrement, " +
                "Nome Text," +
                "Tipo Text," +
                "Duracao  Text," +
                "Preco Real," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Esp_Ev() {
        a="Create Table if not exists TBL_Esp_Ev (" +
                "Id_Esp_Ev Integer Primary Key Autoincrement, " +
                "Id_Evento Integer Constraint FK_Eventos_Esp_Ev References TBL_Eventos(Id_Evento), " +
                "Id_Espectaculo Integer Constraint FK_Espectaculos_Esp_Ev References TBL_Espectaculos(Id_Espectaculo), " +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Eventos() {
        a="Create Table if not exists TBL_Eventos (" +
                "Id_Evento Integer Primary Key Autoincrement, " +
                "Id_Cliente Integer Constraint FK_Clientes_Eventos References TBL_Clientes(Id_Cliente), " +
                "Data Text," +
                "Obs Text" +
                ")";
        return a;
    }
    public static String Create_TBL_Cliente() {
        a="Create Table if not exists TBL_Clientes (" +
                "Id_Cliente Integer Primary Key Autoincrement, " +
                "Nome Text," +
                "Numero Integer," +
                "Email Text," +
                "Obs Text" +
                ")";
        return a;
    }

}