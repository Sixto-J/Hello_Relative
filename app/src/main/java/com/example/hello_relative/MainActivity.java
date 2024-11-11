package com.example.hello_relative;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    int numerodecontador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_portrait);


        Button btnEnviar1 = findViewById(R.id.button);
        btnEnviar1.setOnClickListener(v -> {
            // código a ejecutar cuando sea pulsado
            TextView tv1 = findViewById(R.id.textView);
            String text = tv1.getText().toString();
            Toast.makeText(MainActivity.this, "TU PUNTUACION ES " + text, Toast.LENGTH_SHORT).show();
        });

        Button btnEnviar2 = findViewById(R.id.button2);
        btnEnviar2.setOnClickListener(v -> {
            // código a ejecutar cuando sea pulsado
            TextView tv1 = findViewById(R.id.textView);
            String aux_string = tv1.getText().toString();
            numerodecontador = Integer.parseInt(aux_string);
            //.replaceAll("[\\D]", ""));
            numerodecontador++;
            tv1.setText(String.valueOf(numerodecontador));
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView tv1 = findViewById(R.id.textView);
        outState.putString("YourTextViewTextIdentifier", tv1.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView tv1 = findViewById(R.id.textView);
        tv1.setText(savedInstanceState.getString("YourTextViewTextIdentifier"));
    }


}

/*
Content of button <Button> is partially covered by textView <TextView> in 4 preview configurations.
 This may affect text readability. Fix this issue by adjusting widget positioning.

android:layout_above=“@id/textView” en el boton de arriba

android:layout_below=“@id/button" en el TextVIew de debajo

Estas dos instrucciones en el oton y el textedit respectivamente crean una contradicción que deja
la pantalla en blanco y arroja el error: Circular dependencies cannot exist in RelativeLayout
 */