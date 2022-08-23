package com.example.telephonydemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
        TextView tv =(TextView) findViewById(R.id.textView1);
        
        TelephonyManager tMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String SimNo = tMgr.getLine1Number();
        String IMEI = tMgr.getDeviceId();
        String country = tMgr.getSimCountryIso();
        String operator = tMgr.getNetworkOperatorName();
        String NetType = "UNKNOWN";
        switch (tMgr.getNetworkType()) {
		case TelephonyManager.NETWORK_TYPE_CDMA:
			      NetType = "CDMA";
			break;
			
		case TelephonyManager.NETWORK_TYPE_GPRS:
		      NetType = "GPRS";
		break;
				
		default:
			break;
		}
        
        GsmCellLocation loc = (GsmCellLocation) tMgr.getCellLocation();
        int CellId = loc.getCid();
        int LAC = loc.getLac();
        
        tv.setText("My Device Info\n");
        tv.append("IMEI No: "+ IMEI);
        tv.append("\nSim No: "+ SimNo);
        tv.append("\nCountry : "+ country);
        tv.append("\nOperator: "+ operator);
        tv.append("\nNetwork : "+ NetType);
        tv.append("\nCell ID: "+ CellId);
        tv.append("\nLAC : "+ LAC);
       
        
        
		
	}

}
