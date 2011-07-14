package org.safermobile.intheclear.data;

import org.safermobile.intheclear.ITCConstants;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class MovementTracker {
	private static LocationManager lm;	
	private static Criteria criteria;
	
	Context _c;
	
	public MovementTracker(Context c) {
		_c = c;
		lm = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		Log.d(ITCConstants.Log.ITC,"movement tracker started");
	}
	
	public static String testData() {
		StringBuffer sb = new StringBuffer();
		double[] loc = updateLocation();
		sb.append("Latitude: " + loc[0] + "\nLongitude: " + loc[1] + "\n");
		return sb.toString();
	}
	
	public static double[] updateLocation() {
		String bestProvider = lm.getBestProvider(criteria, false);
		Location l = lm.getLastKnownLocation(bestProvider);
		return new double[] {l.getLatitude(),l.getLongitude()};
	}
}
