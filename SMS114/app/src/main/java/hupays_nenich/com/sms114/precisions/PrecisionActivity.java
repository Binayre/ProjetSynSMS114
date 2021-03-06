package hupays_nenich.com.sms114.precisions;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class PrecisionActivity extends GlobalActivity {

    private EditText edtPrecisions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precision);

        edtPrecisions = (EditText)findViewById(R.id.edtPrecision);

        btnRetour = (Button)findViewById(R.id.btnRetourBody);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnSuivantLocalisation);
        btnSuivant.setOnClickListener(new ValiderPrecisionListener(this));

        if(!message.getZone_concernee().equals("")){
            btnRetour.setText(R.string.emplacement_douloureux);
        }
        else if(message.getNb_victime().matches("[1-9]+[^0-9]*") ){
            btnRetour.setText(R.string.symptome);
        }
        else{
            btnRetour.setText(R.string.nb_victime);
        }
    }

    @Override
    public String getNouveauTitre() {
        return "Precisions";
    }

    public String precisions(){
        return edtPrecisions.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_precision, menu);
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
