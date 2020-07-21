package com.example.sensor2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager systemService;
    private int[] music={};
    private int index=0;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemService = (SensorManager) getSystemService(SENSOR_SERVICE);
        initAll();
        initLight();
        initFangxiang();
        initMusic();
    }

    private void initMusic() {
        mediaPlayer = MediaPlayer.create(this, music[index]);
        mediaPlayer.start();
        Sensor music = systemService.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    private void initFangxiang() {
        Sensor defaultSensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        systemService.registerListener(new listAll(),defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void initLight() {
        Sensor light = systemService.getDefaultSensor(Sensor.TYPE_LIGHT);
        systemService.registerListener(new listAll(),light,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public class listAll implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                float value = event.values[0];

            }else if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
                float value = event.values[0];

            }else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float X = event.values[0];
                float Y = event.values[1];
                float Z = event.values[2];
                if(mediaPlayer !=null){
                    mediaPlayer.stop();
                }
                index++;
                index=index%music.length;
                 mediaPlayer = MediaPlayer.create(MainActivity.this, music[index]);
                 mediaPlayer.start();


            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void initAll() {
        List<Sensor> sensorList = systemService.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            String name = sensor.getName();
            String vendor = sensor.getVendor();
            int version = sensor.getVersion();

        }

    }
}
