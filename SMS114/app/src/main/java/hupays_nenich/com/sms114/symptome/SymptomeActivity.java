package hupays_nenich.com.sms114.symptome;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class SymptomeActivity extends GlobalActivity {

    private ArrayList<ToggleButton> liste_boutons;
    private ToggleButton btn_saignement, btn_douleurs, btn_brulure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptome);

        btnRetour = (Button)findViewById(R.id.btnRetourDetailVictime);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnPrecisions);
        btnSuivant.setOnClickListener(new ValiderSymptomeListener(this));

        btnSuivant.setEnabled(false);

        this.liste_boutons = new ArrayList<ToggleButton>();

        liste_boutons.add((ToggleButton)findViewById(R.id.btnPbRespi));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnArretCardiaque));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnDouleurInterne));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnVomissement));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnInconscient));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnSpasmes));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnSaignement));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnBrulure));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnContraction));
        liste_boutons.add((ToggleButton)findViewById(R.id.btnPerteEaux));

        btn_saignement = (ToggleButton)findViewById(R.id.btnSaignement);
        btn_douleurs = (ToggleButton)findViewById(R.id.btnDouleurInterne);
        btn_brulure = (ToggleButton)findViewById(R.id.btnBrulure);

        SymptomeListener listener = new SymptomeListener(this);

        for(int i=0; i<liste_boutons.size();i++){

            liste_boutons.get(i).setOnClickListener(listener);
        }
    }

    @Override
    public String getNouveauTitre() {
        return "Symptome";
    }

    // si True, lancer le body
    public boolean lancerBody(){
        if(message.getNb_victime().matches("[2-9]+[^0-9]*")){
            return false;
        }

        return btn_saignement.isChecked() || btn_douleurs.isChecked() || btn_brulure.isChecked();
    }

    public int nbBoutonsSelectionnes(){
        int nb = 0;

        for(int i=0; i<liste_boutons.size();i++){

            if(liste_boutons.get(i).isChecked()){
                nb++;
            }
        }

        return nb;
    }

    public String boutonSelectionne(){
        String symptomes = "";

        for(int i=0; i<liste_boutons.size();i++){

            if(liste_boutons.get(i).isChecked()){
                symptomes = symptomes+", "+liste_boutons.get(i).getText().toString();
            }
        }

        return symptomes;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_symptome, menu);
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
