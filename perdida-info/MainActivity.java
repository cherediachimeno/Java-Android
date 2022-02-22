package es.ua.eps.perdida_informacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Here I'm creating objects from class and I'm adding some attributes such as this String
    static final String TAG = "DATO";
    static String prueba = "Soy la prueba";
    static int entradas = 50;
    TextView texto;
    EditText editarTexto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Here the utility "log.d" will print the message "oncreate" to understand exactly
        // where I am, where the code runs.

        Log.d(TAG, "Hemos ejecutado el método onCreate");

        texto = (TextView) findViewById(R.id.textview);
        editarTexto = (EditText) findViewById(R.id.edittext);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                texto.setText(editarTexto.getText().toString());
            }
        });
    }

    // Here we're building two methods to manage our information/data in order to save them.

    // onSaveInstanceState -> almacenar estado de la activity y algunos datos (pero TENEMOS QUE
    // INDICARLE QUÉ DATOS QUIERES ALMACENAR).

    //  onRestoreInstanceState -> recupera la información guardada.

    public void onSaveInstanceState(Bundle outState) {
        outState.putString("saved", texto.getText().toString());
        outState.putInt("savedInt", entradas);
        outState.putString("saved2", prueba);
        //outState.putInt("my int", 15);
        //outState.putBoolean("trabajo", true);
        super.onSaveInstanceState(outState);
        Log.d(TAG,"Hemos grabado el String por SAVE");
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        texto.setText(savedInstanceState.getString("saved"));
            //Here I'm creating two new variables from data I kept with the method
            // onSaveInstanceState
        //edad = savedInstanceState.getInt("my int");
       // String grabadoPorElUsuario = savedInstanceState.getString("saved");
        Log.d(TAG, "Hemos grabado el String por RESTORE");
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Hemos ejecutado el método onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Hemos ejecutado el método onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Hemos ejecutado el método onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Hemos ejecutado el método onStop");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Hemos ejecutado el método onRestart");
        ;
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Hemos ejecutado el método onDestroy");
    }


}