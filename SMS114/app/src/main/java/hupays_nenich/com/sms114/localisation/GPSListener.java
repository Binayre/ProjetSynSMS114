package hupays_nenich.com.sms114.localisation;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;

import geographie.AngleDMS;

/**
 * Created by Jérémy on 20/01/2015.
 */
public class GPSListener implements View.OnClickListener, LocationListener{

    private LocalisationActivity activity;
    private Location location;

    public GPSListener(LocalisationActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onClick(View v) {
        String geoloc = "";

        AngleDMS dms = new AngleDMS(location.getLongitude(), false);
        AngleDMS dms1 = new AngleDMS(location.getLatitude(), true);

        geoloc = geoloc + "Latitude: "+ dms1.toString()+"\n";
        geoloc = geoloc + "Longitude: "+ dms.toString()+"\n";

        activity.setTexte(geoloc);
    }
}
