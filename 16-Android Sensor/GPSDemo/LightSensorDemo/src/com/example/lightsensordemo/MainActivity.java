package com.example.lightsensordemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements SensorEventListener{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		tv = (TextView) findViewById(R.id.textView1);
		SensorManager sMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		Sensor sLight = sMgr.getDefaultSensor(Sensor.TYPE_LIGHT);
		sMgr.registerListener(this, sLight, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		tv.setText(event.values[0]+"");
	}

	

}
