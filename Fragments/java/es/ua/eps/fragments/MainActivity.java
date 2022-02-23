package es.ua.eps.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements EnviarMensaje {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void EnviarDatos(String mensaje) {
    Derecha right = (Derecha) getSupportFragmentManager().findFragmentById(R.id.derecha);
    right.ObtenerDatos(mensaje);
    }
}