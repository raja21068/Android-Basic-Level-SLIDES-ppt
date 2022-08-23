package com.example.smsdemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
       
         tv = (TextView) findViewById(R.id.textView1);
         registerReceiver(new MySMSReciever(),
        		 new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }


    class MySMSReciever extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			Object[] pdus = (Object[]) intent.getExtras().get("pdus");
			for (int i = 0; i < pdus.length; i++) {
				SmsMessage mesg = SmsMessage.createFromPdu((byte[]) pdus[i]);
				String num = mesg.getOriginatingAddress();
				String text = mesg.getDisplayMessageBody();
				tv.setText("From: "+num+"\nMessage: "+text);
				
			}
			
			
			
			
		}
    	
    	
    	
    }
    
}
