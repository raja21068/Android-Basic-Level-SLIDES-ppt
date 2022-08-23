package com.example.telephonydemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Background extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
//		TelephonyManager tMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
//        String SimNo = tMgr.getLine1Number();
//        String IMEI = tMgr.getDeviceId();
//        String country = tMgr.getSimCountryIso();
        
        Toast.makeText(this, "Service Starting", 1).show();
        return START_STICKY;
	}

}
