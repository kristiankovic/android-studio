package com.op.contador;

import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {

    // variables globales
    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        contador = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // metodos para cada accion
    public void inc(View view){
        contador++;
        showResult();
    }

    public void dec(View view){
        contador--;
        showResult();
    }

    public void reset(View view){
        contador = 0;
        showResult();
    }

    public void showResult(){
        TextView txtResult = (TextView)findViewById(R.id.lblContador);

        txtResult.setText("Contador: " + contador);
    }
}