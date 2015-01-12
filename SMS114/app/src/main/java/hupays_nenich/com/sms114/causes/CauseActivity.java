package hupays_nenich.com.sms114.causes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.Message;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;
import hupays_nenich.com.sms114.mesInfos.MesInfosActivity;


/**
 * permet de choisir la cause de l'appel
 */
public class CauseActivity extends GlobalActivity {

   private Button btnAccident, btnIncendie, btnBlessureAnimale, btnCatastrophe, btnAutre, btnRetourAccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cause);

        Intent intent = this.getIntent();

        if(intent != null){
            this.message = (Message) intent.getSerializableExtra("message");
        }


        btnAccident = (Button)findViewById(R.id.btnAccidentRoute);
        btnAccident.setOnClickListener(new CauseListener(this, DetailAccidentVoitureActivity.class));

        btnIncendie = (Button)findViewById(R.id.btnIncendie);
        btnIncendie.setOnClickListener(new CauseListener(this, DetailIncendieActivity.class));

        btnBlessureAnimale = (Button)findViewById(R.id.btnBlessuresAnimales);
        btnBlessureAnimale.setOnClickListener(new CauseListener(this, DetailAnimauxActivity.class));

        btnCatastrophe = (Button)findViewById(R.id.btnCatastrophes);
        btnCatastrophe.setOnClickListener(new CauseListener(this, MesInfosActivity.class));

        btnAutre = (Button)findViewById(R.id.btnAutresCauses);
        btnAutre.setOnClickListener(new CauseListener(this, MesInfosActivity.class));

        btnRetourAccueil = (Button)findViewById(R.id.btnRetourAccueil);
        btnRetourAccueil.setOnClickListener(new RetourListener(this));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cause, menu);
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
