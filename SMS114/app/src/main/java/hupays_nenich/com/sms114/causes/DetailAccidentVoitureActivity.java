package hupays_nenich.com.sms114.causes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ToggleButton;

import hupays_nenich.com.sms114.Message;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

/**
 * permet de selectionner les vehicules impliques dans un accident de voiture
 */
public class DetailAccidentVoitureActivity extends DetailCauseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_accident_voiture);

        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVoiture));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVelo));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnMoto));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnCamion));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnBus));

        setListener();
    }

    @Override
    public String getNouveauTitre() {
        return "Accident";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_accident_voiture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
