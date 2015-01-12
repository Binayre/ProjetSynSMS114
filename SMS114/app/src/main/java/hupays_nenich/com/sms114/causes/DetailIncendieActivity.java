package hupays_nenich.com.sms114.causes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ToggleButton;

import hupays_nenich.com.sms114.Message;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class DetailIncendieActivity extends DetailCauseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_incendie);

        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVehicule));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVegetation));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnBatiment));

        setListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_incendie, menu);
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
