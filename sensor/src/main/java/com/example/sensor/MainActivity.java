package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager systemService;
    private ListAll listAll;
    private int[] vides={R.raw.weichat_audio,R.raw.womenzhijian,R.raw.zhuiguangzhe};
    private int index=0;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemService = (SensorManager) getSystemService(SENSOR_SERVICE);
      //  getAllSensor();
      // uesrOre();//方向
    //   userLight();//光线
    //   userLight2();//综合
       userAcce();


        }

    private void userAcce() {
        mediaPlayer = MediaPlayer.create(this, vides[index]);
        mediaPlayer.start();
        Sensor acc = systemService.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        systemService.registerListener(new ListAll(),acc,SensorManager.SENSOR_DELAY_NORMAL);

    }

    private void userLight2() {
        Sensor defaultSensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        listAll = new ListAll();
        systemService.registerListener(listAll,defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
    public class ListAll implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
                float value = event.values[0];

            }else if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                float light = event.values[0];


            }else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float X = event.values[0];
                float Y = event.values[1];
                float Z = event.values[2];
                Log.i("111", "x="+X+",y="+Y+",z="+Z);
                if(Z>12){
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.release();

                }
                index++;
                index=index%vides.length;
                MediaPlayer.create(MainActivity.this,vides[index]);
                mediaPlayer.start();
                 }
            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void userLight() {
        Sensor light = systemService.getDefaultSensor(Sensor.TYPE_LIGHT);
        systemService.registerListener(new lis2(),light,SensorManager.SENSOR_DELAY_NORMAL);

    }
    public class lis2 implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                float value = event.values[0];
                Log.i("111","光线值 ："+value);
            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    /**
     * 方向传感器
     * 1.获得方法传感器
     *2.创建传感器的监听器
     * 3.注册传感器，添加监听器
     * 4.在监听器的onSensorChanged方法中获取传感器感应到的数据，然后进行业务逻辑的处理
     */
    private void uesrOre() {
        Sensor defaultSensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        systemService.registerListener(new Lis1(),defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);//注册
    }
    public class Lis1 implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            Log.i("111","方向角度 :"+value);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }


    private void getAllSensor() {

        List<Sensor> sensorList = systemService.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            String name = sensor.getName();
            String vendor = sensor.getVendor();//得到生成厂商
            int version = sensor.getVersion();//得到版本
            Log.i("111", "Msg : " + name + "," + vendor + "," + vendor);

        }

    }

}
