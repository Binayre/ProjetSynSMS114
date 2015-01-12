package hupays_nenich.com.sms114.causes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ToggleButton;

import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class DetailCatastropheActivity extends DetailCauseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catastrophe);

        this.ajouterBouton((ToggleButton)findViewById(R.id.btnInondation));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVentViolent));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnVolcan));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnAvalanche));
        this.ajouterBouton((ToggleButton)findViewById(R.id.btnSeisme));

        setListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_catastrophe, menu);
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
