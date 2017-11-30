package assaf.zfani.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView one,two,three;
    Sensor accel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accel=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accel!= null)
        {
            sensorManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);

        }






    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        one.setText(event.values[0]+"");
        two.setText(event.values[1]+"");
        three.setText(event.values[2]+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void setViews()
    {
        one = (TextView)findViewById(R.id.one);
        two = (TextView)findViewById(R.id.two);
        three = (TextView)findViewById(R.id.three);
    }
}
