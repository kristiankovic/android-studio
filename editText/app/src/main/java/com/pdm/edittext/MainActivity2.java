package com.pdm.edittext;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nombre = (EditText)findViewById(R.id.txtNombre);

        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                /*if(count != 0){
                    Log.i("EVENTO", String.valueOf(s.charAt(start)));
                    Log.i("EVENTO", String.valueOf(s.charAt(before)));
                }*/
            }
        });

    }



    // INTENTS | INTENCIONES
    // explicito -> van dentro de la misma app
    // implicito -> sirven para operar fuera de la app
    public void openLayout(View view){

        // intencion de abrir otra vista
        Intent intent = new Intent(this, MainActivity.class); //actual, destino
        startActivity(intent);
    }

    // debe recibir un parametro de tipo view
    public void saludar(View view) {

        EditText nombre = (EditText)findViewById(R.id.txtNombre);
        Toast.makeText(this, nombre.getText(), Toast.LENGTH_SHORT).show();

        /*if (txtSaludar.getText().toString().isEmpty()){
            Drawable icon = ContextCompat.getDrawable(this, R.drawable.error_icon_foreground);

            if(icon != null){
                icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            }
        }

        else{
        }*/
    }

}