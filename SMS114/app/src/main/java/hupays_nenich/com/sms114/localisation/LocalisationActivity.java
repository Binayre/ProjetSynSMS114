package hupays_nenich.com.sms114.localisation;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;


public class LocalisationActivity extends GlobalActivity {

    private EditText adresse;
    private Button domicile, geoloc;
    private GPSListener listener;
    private LocationManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);

        btnRetour = (Button)findViewById(R.id.btnRetourPrecision);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnMessage);
        btnSuivant.setOnClickListener(new ValiderLocalisationListener(this));

        domicile = (Button)findViewById(R.id.btnDomicile);
        domicile.setOnClickListener(new AdresseListener(this));


        adresse = (EditText)findViewById(R.id.edtAdresse);

        listener = new GPSListener(this);

        geoloc = (Button)findViewById(R.id.btnGeoloc);
        geoloc.setOnClickListener(listener);

        lm = (LocationManager)getSystemService(LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000,2,listener);
    }

    public void setTexte(String t){
        adresse.append(t);
    }

    public String getTexte(){
        return adresse.getText().toString();
    }

    @Override
    public String getNouveauTitre() {
        return "Localisation";
    }

    @Override
    public void finish(){
        super.finish();
        lm.removeUpdates(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_localisation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
