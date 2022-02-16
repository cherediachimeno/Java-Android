package es.ua.eps.repaso;

import androidx.appcompat.app.AppCompatActivity;

// Here I have to import classes (button, edittext and textview).

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Here I'm creating some objects from classes. I have a textview,
    // an edittext and a button. So it's necessary to create objects of
    // them.

    //CLASS --  OBJECT
    TextView texto;
    EditText textoEditar;
    Button boton;
    Button botonToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ok, I have some objects, but it's necessary to link
        // them to my ID's, the elements I have on my layout
        //OBJECT =  (Typology) method to find and ID (R.id.ID).
        texto =     (TextView) findViewById(R.id.text);
        // So, right now, texto is linked to my id entitled "text".
        textoEditar = (EditText) findViewById(R.id.editar);
        boton = (Button) findViewById(R.id.boton);
        botonToast = (Button) findViewById(R.id.toast);

        // Now, we're going to do something...


        // the idea here is this one... My "boton" is going to "listen"
        // when the user clicks it.

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // If you want to do something when the user clicks,
                // it's necessary to write the instructions here!

                // We want to get the text from the user. The text he/she
                // will write on the editText. So, I will save this
                // information into my string called textFromUser
                String textFromUser = textoEditar.getText().toString();
                texto.setText(textFromUser);
            }
        });

        // the idea here is the same. My "botonToast" is going to "listen"
        // when the user clicks it. However, I want to show
        // a message instead of changing texts.

        botonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The message I want is a "toast". Here you can see its syntaxis
                //CLASS + METHOD ( ITS CONTEXT, ITS TEXT, ITS SPEED) AND THE METHOD TO SHOW
                Toast.makeText(MainActivity.this, "I'm a TOAST", Toast.LENGTH_SHORT).show();
            }                     //You can use nameofclass.this
                                  // or you can use getApplicationContext()
                                 // this form indicates "this context".
        });




    }
}