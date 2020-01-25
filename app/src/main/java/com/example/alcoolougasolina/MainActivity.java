package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editAlcool;
    private EditText editGasolina;
    private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void escolherMelhorCombustivel(View view){
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();
        Boolean camposValidados = validarCampos(precoAlcool,precoGasolina);
        if (camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if ((valorAlcool/valorGasolina)>=0.7){
                textResultado.setText("É melhor utilizar Gasolina");
            }
            else{
                textResultado.setText("É melhor utilizar Alcool");
            }
        }
        else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if (pAlcool.equals("")){
            camposValidados = false;
        }
        else if(pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}
