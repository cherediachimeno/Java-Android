package es.ua.eps.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

// Here I have to import classes (button, edittext and textview).

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Here I'm creating some objects from classes. I have a textview,
    // an edittext and a button. So it's necessary to create objects of
    // them.

    //CLASS --  OBJECT
    TextView texto;
    EditText textoEditar;
    Button boton;
    Button botonToast;
    Button changeActivity;
    Button toCall;
    Button sendSMS;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ok, I have some objects, but it's necessary to link
        // them to my ID's, the elements I have on my layout
        //OBJECT =  (Typology) method to find and ID (R.id.ID).
        texto = (TextView) findViewById(R.id.text); // So, right now, texto is linked to my id entitled "text".
        textoEditar = (EditText) findViewById(R.id.editar);
        boton = (Button) findViewById(R.id.boton);
        botonToast = (Button) findViewById(R.id.toast);
        changeActivity = (Button) findViewById(R.id.buttonChange);
        toCall = (Button) findViewById(R.id.llamar);
        sendSMS = (Button) findViewById(R.id.sendSMS);
        web = (WebView) findViewById(R.id.website);

        // It's mandatory to activate the buttons you need.

        boton.setOnClickListener(this);
        botonToast.setOnClickListener(this);
        changeActivity.setOnClickListener(this);
        toCall.setOnClickListener(this);
        sendSMS.setOnClickListener(this);

        // Now, we're going to do something DIFFERENT.
        // We're not going to use onclicklistener method ON the object.
        // WHY? let's see...

        // Way to storage string from strings.xml: String name = (String) getText(R.string.app_name);

        // Here we're going to configure my webview
        // First, I need to enabled JavaScript
        web.getSettings().setJavaScriptEnabled(true);
        // Secondly, I will add an url
        web.loadUrl("http://www.duckduckgo.com");
        web.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });



    }
    @Override
    public void onClick(View v) {
        // Here I'm going to use a switch. If the user clicks on a button, then the actions do.

        switch (v.getId()){

            case R.id.boton:
                //Actions to execute if the user clicks on the button called "boton".
                String textFromUser = textoEditar.getText().toString();
                texto.setText(textFromUser);
                break;
            case R.id.toast:
                //Actions to execute if the user clicks on my button called "toast
                Toast.makeText(MainActivity.this, "I'm a TOAST", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonChange:
                Intent intentToDoSomething = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intentToDoSomething);
                break;
            case R.id.llamar:
                Uri telephone = Uri.parse("tel:+34615916610");
                Intent firstTry = new Intent(Intent.ACTION_CALL, telephone);
                startActivity(firstTry);
                break;
            case R.id.sendSMS:
                String messageToSend = "this is the message";
                String number = "615916610";
                SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
                /*

                Uri msg = Uri.parse("smsto:+34615916610");
                Intent firstSMS = new Intent(Intent.ACTION_SENDTO, msg);
                firstSMS.putExtra("subject", "SOS");
                firstSMS.putExtra("sms_body", "Help please");
                startActivity(firstSMS); */
                break;
        }

    }
}