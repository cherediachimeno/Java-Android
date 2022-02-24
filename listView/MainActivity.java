package es.ua.eps.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button getElement;
    ListView listView;
    EditText editarTexto;
    List<String> miLista = new ArrayList<>();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getElement = (Button) findViewById(R.id.boton);
        listView = (ListView) findViewById(R.id.listView);
        editarTexto = (EditText) findViewById(R.id.usuario);

        getElement.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton: String texto = editarTexto.getText().toString();
            // Adding the text the user is writing to my array (called miLista).
            miLista.add(texto);
            editarTexto.getText().clear();
            // I'm connecting my array (miLista) with my template, in this case a default template
                // called simple_list_item_1.
            adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, miLista);
            // Here I'm attaching my "adaptador" into my listView on layout.xml (activity_main.xml).
            listView.setAdapter(adaptador);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}