package com.example.sensorlistdemo;

import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		ListView lv = (ListView) findViewById(R.id.listView1);
		SensorManager sMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		List<Sensor> sList = sMgr.getSensorList(Sensor.TYPE_ALL);
		ArrayAdapter<Sensor> adapter = new ArrayAdapter<>(
				MainActivity.this, android.R.layout.simple_list_item_1, sList);
		lv.setAdapter(adapter);

		
	}

	
}
