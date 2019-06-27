package com.example.programamagia;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.programamagia.Adapter.Adapter_Edittxt;
import com.example.programamagia.BD.BaseDados;
import com.example.programamagia.Comandos_SQL.Clientes_SQL;

import java.util.ArrayList;
import java.util.Locale;

public class Gestao_Definicoes extends AppCompatActivity {
    private BaseDados BD;
    private Button btn_idiomas, btn_geral, btn_misc;
    private SQLiteDatabase connection;

    private ListView listView;

    final int PORTUGUESE = 1;
    final int ENGLISH = 2;
    final int SPANISH = 3;
    final int FRENCH = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_definicoes);
        BD = new BaseDados(this);
        connection = BD.getWritableDatabase();

        btn_idiomas = findViewById(R.id.button_geral);
        btn_geral = findViewById(R.id.button_idiomas);
        btn_misc = findViewById(R.id.button_misc);

     /*   RadioGroup radioGroupIdioma = (RadioGroup) findViewById(R.id.radioGroupIdioma);
        radioGroupIdioma.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonPortuguese:
                    mudarIdioma(PORTUGUESE);
                    break;
                    case R.id.radioButtonEnglish:
                        mudarIdioma(ENGLISH);
                        break;
                    case R.id.radioButtonSpanish:
                        mudarIdioma(SPANISH);
                        break;
                    case R.id.radioButtonFrench:
                        mudarIdioma(FRENCH);
                        break;
                }
            }
        });
    }

    void mudarIdioma(int idioma){
    String language = null;
        switch (idioma){
            case PORTUGUESE:
                language = "pt";
            break;
            case ENGLISH:
                language = "en";
                break;
            case SPANISH:
                language = "es";
                break;
            case FRENCH:
                language = "fr";
                break;
        }

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = this.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        Intent intent = new Intent(this, Gestao_Definicoes.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        atualizarViews();


    }

    void atualizarViews(){
        TextView textView = (TextView) findViewById(R.id.textView123);
        textView.setText(getString(R.string.btn_Espectaculos));

        RadioButton radioButtonPortuguese = (RadioButton) findViewById(R.id.radioButtonPortuguese);
        radioButtonPortuguese.setText(getString(R.id.portuguese));
        RadioButton radioButtonEnglish = (RadioButton) findViewById(R.id.radioButtonEnglish);
        radioButtonEnglish.setText(getString(R.id.english));
        RadioButton radioButtonSpanish = (RadioButton) findViewById(R.id.radioButtonSpanish);
        radioButtonSpanish.setText(getString(R.id.spanish));
        RadioButton radioButtonFrench = (RadioButton) findViewById(R.id.radioButtonFrench);
        radioButtonFrench.setText(getString(R.id.french));
*/
    }
}
