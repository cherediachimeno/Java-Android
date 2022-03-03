package es.ua.eps.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;
    RecyclerView.LayoutManager layout;
    RecyclerView.Adapter adaptador;

    String[] Data = new String[]{"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5"
    };

    @Override
            protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (RecyclerView) findViewById(R.id.recyclerview);

        // I'm connecting my RecyclerView to a Layout Manager. The idea here is to structure our list with a vertical
        // orientation.
        lista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // ¿?
        adaptador = new RecyclerAdapter(Data);
        lista.setAdapter(adaptador);




    }
}