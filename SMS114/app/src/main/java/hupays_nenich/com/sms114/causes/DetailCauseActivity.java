package hupays_nenich.com.sms114.causes;

import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;

import hupays_nenich.com.sms114.GlobalActivity;

/**
 * Created by Jérémy on 11/01/2015.
 */

/**
 * classe mere de toutes les activity servant a detailler les causes
 */
public class DetailCauseActivity extends GlobalActivity{

    private ArrayList<ToggleButton> liste_boutons;
    protected  Button btnRetour, btnSuivant;

    public void creerListe(){
        this.liste_boutons = new ArrayList<ToggleButton>();
    }

    public void ajouterBouton(ToggleButton btn){
        this.liste_boutons.add(btn);
    }

    public void setBoutonListener(detailCauseListener listener){
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
        String details = "";

        for(int i=0; i<liste_boutons.size();i++){

            if(liste_boutons.get(i).isChecked()){
                details = details+", "+liste_boutons.get(i).getText().toString();
            }
        }

        return details;
    }
}
