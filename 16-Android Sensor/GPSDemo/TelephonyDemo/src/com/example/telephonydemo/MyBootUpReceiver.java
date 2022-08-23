package com.example.telephonydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBootUpReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context c, Intent i) {
		// TODO Auto-generated method stub
		if(i.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")){
			Intent intent = new Intent(c,Background.class);
			c.startService(intent);
		}
	}

}
