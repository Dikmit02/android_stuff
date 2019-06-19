package com.diksha.creatingaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
   // Button clk1,clk2,clk3;
    MediaPlayer mplayer;
    int duration;
    AudioManager audioManager;
    public void clkplay(View view){
        mplayer.start();
        //MediaPlayer mplayer=MediaPlayer.create(this,R.raw.twinkle); if it is defined here and not in oncreate method than eveytime we pause the video it wil start again
        //from start ana dwill nt resume from where it was left
    }
    public void clkpause(View view){

        mplayer.pause();
    }
    public void clkstop(View view){
        mplayer.stop();
       mplayer=MediaPlayer.create(this,R.raw.twinkle);// to start agin the audio whenever te audio button is pressed

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* clk1=(Button) findViewById(R.id.play);
        clk2=(Button) findViewById(R.id.pause);
        clk3=(Button)findViewById(R.id.stop);*/
         mplayer=MediaPlayer.create(this,R.raw.twinkle);
         duration=mplayer.getDuration();
         //TO WORK WITH OUR DEVICE AUDIO

        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxvolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currcolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        //setting max and min value with repect to seekbaar
        SeekBar volumecontroll=(SeekBar) findViewById(R.id.seekBar);
        volumecontroll.setMax(maxvolume);
        volumecontroll.setProgress(currcolume);


        final SeekBar volumecon =(SeekBar) findViewById(R.id.seekBar2);
        volumecon.setMax(duration);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                volumecon.setProgress(mplayer.getCurrentPosition());
            }
        },10,1);


        volumecon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("hidikshamittal","ddddddddddddddd");
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();

                //mplayer.stop();

            }
        });



       volumecontroll.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               Log.i("seekbar value",Integer.toString(progress));
               //chnage volume with seek
               audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

    }
}
