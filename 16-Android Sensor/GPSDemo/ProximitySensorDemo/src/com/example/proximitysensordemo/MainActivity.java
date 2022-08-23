package com.example.proximitysensordemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import android.provider.Settings;

public class MainActivity extends Activity implements SensorEventListener{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		tv = (TextView) findViewById(R.id.textView1);
		SensorManager sMger = (SensorManager) getSystemService(SENSOR_SERVICE);
		Sensor proximity = sMger.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sMger.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}
	@Override
	public void onSensorChanged(SensorEvent event) {
		tv.setText(""+event.values[0]);
		if(event.values[0] <= 0.0f){
			Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
			Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
			r.play();
		}
		
	}

}
