package com.example.startupservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBootUpReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")){
			Intent i = new Intent(context, MyCustomService.class);
			context.startService(i);
		}
	}

}
