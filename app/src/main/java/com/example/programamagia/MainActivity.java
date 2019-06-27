package com.example.programamagia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_info;
    private Button btn_Reportorio, btn_Espectaculos, btn_Eventos, btn_Efeitos,btn_Clientes, btn_Definicoes, btn_Entrar;
    private int opc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Reportorio = (Button) findViewById(R.id.button_Truques);
        btn_Espectaculos = (Button) findViewById(R.id.button_Espectaculos);
        btn_Eventos = (Button) findViewById(R.id.button_Eventos);
        btn_Efeitos = (Button) findViewById(R.id.button_Efeitos);
        btn_Clientes = (Button) findViewById(R.id.button_Clientes);
        btn_Definicoes = (Button) findViewById(R.id.button_Definicoes);
        btn_Entrar = (Button) findViewById(R.id.button_Entrar);
        text_info = (TextView) findViewById(R.id.textView_info);


        text_info.setVisibility(View.INVISIBLE);
        btn_Entrar.setVisibility(View.INVISIBLE);
        btn_Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atv_open;
                if (opc==1) {
                    atv_open = new Intent(MainActivity.this, Gestao_Reportorio.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
                else if (opc==2) {
                    atv_open = new Intent(MainActivity.this, Gestao_Espectaculos.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
                else if (opc==3) {
                    atv_open = new Intent(MainActivity.this, Gestao_Eventos.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
                else if (opc==4) {
                    atv_open = new Intent(MainActivity.this, Gestao_Truques_App.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
                else if (opc==5) {
                    atv_open = new Intent(MainActivity.this, Gestao_Clientes.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
                else if (opc==6) {
                    atv_open = new Intent(MainActivity.this, Gestao_Definicoes.class);
                    startActivity(atv_open);
                    text_info.setVisibility(View.INVISIBLE);
                    btn_Entrar.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_Reportorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=1;
                text_info.setText(getString(R.string.RepText));
                btn_Entrar.setVisibility(View.VISIBLE);
                text_info.setVisibility(View.VISIBLE);

            }
        });
        btn_Espectaculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=2;
                text_info.setText(getString(R.string.EspText));
                text_info.setVisibility(View.VISIBLE);
                btn_Entrar.setVisibility(View.VISIBLE);
            }
        });
        btn_Eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=3;
                text_info.setText(getString(R.string.EvText));
                text_info.setVisibility(View.VISIBLE);
                btn_Entrar.setVisibility(View.VISIBLE);
            }
        });
        btn_Efeitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=4;
                text_info.setText(getString(R.string.EfText));
                text_info.setVisibility(View.VISIBLE);
                btn_Entrar.setVisibility(View.VISIBLE);
            }
        });
        btn_Clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=5;
                text_info.setText(getString(R.string.CliText));
                text_info.setVisibility(View.VISIBLE);
                btn_Entrar.setVisibility(View.VISIBLE);
            }
        });
        btn_Definicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opc=6;
                text_info.setText(getString(R.string.btn_Definicoes));
                text_info.setVisibility(View.VISIBLE);
                btn_Entrar.setVisibility(View.VISIBLE);
            }
        });
    }
}
