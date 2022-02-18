package es.ua.eps.elementosmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // Here we're creating objects from classes.

    Button play, stop;
    public MediaPlayer objectToPlaySounds;


    // VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.reproduciendo);
        stop = (Button) findViewById(R.id.parando);

        // video = (VideoView) findViewById(R.id.video);

        // Here I'm adding my video (located in Res/Raw) to my VideoView
        // This code allows us to put my video to my object.

        //String path = "android.resource://" + getPackageName() + "/" + R.raw.glaciar2;
        //video.setVideoURI(Uri.parse(path));


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //video.start();

                // Here the example of sounds
                objectToPlaySounds = MediaPlayer.create(getApplicationContext(), R.raw.transport);
               // objectToPlaySounds = MediaPlayer.create(MainActivity.this, R.raw.transport);
                objectToPlaySounds.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // videoTren.pause();

             // videoTren.pause();
               // videoTren.seekTo(0);
                // Here the example of sounds
                objectToPlaySounds.stop();
            }
        });

    }
}