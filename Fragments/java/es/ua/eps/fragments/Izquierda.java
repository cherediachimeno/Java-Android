package es.ua.eps.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import es.ua.eps.fragments.EnviarMensaje;
import es.ua.eps.fragments.R;

public class Izquierda extends Fragment {

    Button boton;
    EditText campo;
    EnviarMensaje EM;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.izquierda, container, false);

        campo = (EditText) rootView.findViewById(R.id.campotexto);
        boton = (Button) rootView.findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje;
                mensaje = campo.getText().toString();
                EM.EnviarDatos(mensaje);
            }
        });

        return rootView;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            EM = (EnviarMensaje) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Necesitas implementar un mensaje");
        }
    }
}
