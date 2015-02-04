package hupays_nenich.com.sms114.body;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;


public class BodyActivity extends GlobalActivity {

    private ArrayList<ElementBody> liste_boutons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        btnRetour = (Button)findViewById(R.id.btnRetourSymptome);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnVersPrecision);
        btnSuivant.setOnClickListener(new ValiderBodyListener(this));

        this.liste_boutons = new ArrayList<ElementBody>();

        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnTete),getString(R.string.tete)));

        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnTorse),getString(R.string.torse)));

        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnVentre),getString(R.string.ventre)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnBrasDroit),getString(R.string.bras_droit)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnBrasGauche),getString(R.string.bras_gauche)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnMainDroite),getString(R.string.main_droite)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnMainGauche),getString(R.string.main_gauche)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnJambeDroite),getString(R.string.jambe_droite)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnJambeGauche),getString(R.string.jambe_gauche)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnPiedDroit),getString(R.string.pied_droit)));
        liste_boutons.add(new ElementBody((ToggleButton)findViewById(R.id.btnPiedGauche),getString(R.string.pied_gauche)));

    }

    @Override
    public String getNouveauTitre(){
        return "Corps";
    }

    public String boutonSelectionne(){
        String zones = new String();
        boolean premier = true;

        for(int i=0; i<liste_boutons.size(); i++){
            if(liste_boutons.get(i).getBtn().isChecked()){
                if(premier)
                {
                    zones = liste_boutons.get(i).getPartie();
                    premier = false;
                }
                else zones = zones + ", "+liste_boutons.get(i).getPartie();
            }
        }
        return zones;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_body, menu);
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
