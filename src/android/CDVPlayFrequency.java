package me.rahul.plugins.playfrequency;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class CDVPlayFrequency extends CordovaPlugin {

    private int freq;
    private int sampleRate;
    private  AudioTrack track;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("playfrequency")) {

            freq = Integer.getInteger(args.getString(0),16000);
            sampleRate = Integer.getInteger(args.getString(1),44100);
            Log.d("CordovaLog","Frequency = "+freq);
            Log.d("CordovaLog","Sample Rate = "+sampleRate);
            this.playTone();
            return true;
        }
        else if(action.equals("stopfrequency")){
            Log.d("CordovaLog","Stoping Tone");
            track.stop();
            return true;
        } else {
            return false;
        }
    }

    private void playTone() {
        Log.d("CordovaLog","Playing Tone");
        int count = (int)(sampleRate * 2.0 * (5000 / 1000.0)) & ~1;
        short[] samples = new short[count];
        for(int i = 0; i < count; i += 2){
            short sample = (short)(Math.sin(2 * Math.PI * i / (44100.0 / freq)) * 0x7FFF);
            samples[i + 0] = sample;
            samples[i + 1] = sample;
        }
        track = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
                count * (Short.SIZE / 8), AudioTrack.MODE_STATIC);
        track.write(samples, 0, count);
        track.play();
    }
}
