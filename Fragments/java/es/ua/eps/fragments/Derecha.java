package es.ua.eps.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.ua.eps.fragments.R;

public class Derecha extends Fragment {

    TextView txt;
    View rootView;

    @Override
    //This method will link my derecha.xml with my derecha.java
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.derecha, container, false);
        txt = (TextView) rootView.findViewById(R.id.text);
        return rootView;
    }

    public void ObtenerDatos(String mensaje){
        txt.setText(mensaje);
    }


}
