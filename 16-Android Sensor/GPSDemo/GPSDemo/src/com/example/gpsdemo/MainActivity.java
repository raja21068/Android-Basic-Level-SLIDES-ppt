package com.example.gpsdemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements LocationListener{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		LocationManager lMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
		lMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000,3, this);
   
		
	}

	@Override
	public void onLocationChanged(Location loc) {
				tv.setText("Latitude: "+loc.getLatitude()+"\nLongitude: "+loc.getLongitude());
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

	
}
