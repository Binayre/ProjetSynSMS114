package hupays_nenich.com.sms114.causes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

/**
 * Created by Jérémy on 11/01/2015.
 */

/**
 * classe mere de toutes les activity servant a detailler les causes
 */
public abstract class DetailCauseActivity extends GlobalActivity{

    private ArrayList<ToggleButton> liste_boutons;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.creerListe();
    }

    public void setListener(){
        this.setBoutonListener(new DetailCauseListener(this));

        btnRetour = (Button)findViewById(R.id.btnRetourCauses);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant =(Button)findViewById(R.id.btnNbVictime);
        btnSuivant.setOnClickListener(new ValiderDetailListener(this));

        btnSuivant.setEnabled(false);
    }

    public void creerListe(){
        this.liste_boutons = new ArrayList<ToggleButton>();
    }

    public void ajouterBouton(ToggleButton btn){
        this.liste_boutons.add(btn);
    }

    public void setBoutonListener(DetailCauseListener listener){
        for(int i=0; i<liste_boutons.size();i++){

            liste_boutons.get(i).setOnClickListener(listener);
        }
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
        String details = new String();
        boolean premier = true;

        for(int i=0; i<liste_boutons.size(); i++){
            if(liste_boutons.get(i).isChecked()){
                if(premier)
                {
                    details = liste_boutons.get(i).getText().toString();
                    premier = false;
                }
                else details = details + ", " + liste_boutons.get(i).getText().toString();
            }
        }

        return details;
    }
}
