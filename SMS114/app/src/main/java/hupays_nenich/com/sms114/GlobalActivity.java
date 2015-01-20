package hupays_nenich.com.sms114;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;

/**
 * Created by Jérémy on 10/01/2015.
 */
public abstract  class GlobalActivity extends ActionBarActivity{

    protected Message message;
    protected String titre;
    protected Button btnRetour, btnSuivant;
    private static  int numero = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();


        if(intent != null){
            this.message = (Message)intent.getSerializableExtra("message");
            this.titre = intent.getStringExtra("titre");
        }

        //pour la gestion du fil d'Arianne
        numero++;
        if(titre!=null) {
            if(numero%4 == 0)
                this.setTitle("...>" + getNouveauTitre());
            else
                this.setTitle(titre + ">" + getNouveauTitre());
        }
        else{
            this.setTitle(getNouveauTitre());
        }
    }

    public abstract String getNouveauTitre();

    public void animationNouvelleActivite(){
        //l'activite entrante arrive par la droite, l'activite sortante sort par la gauche
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

    @Override
    public void finish(){
        super.finish();
        numero--;
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    public Button getBtnRetour() {
        return btnRetour;
    }

    public Button getBtnSuivant() {
        return btnSuivant;
    }

    public Message getMessage() { return message; }

    public void lancerActivity(Class<?> suivante){
        Intent intent = new Intent(this,suivante);
        intent.putExtra("message",message);
        intent.putExtra("titre",this.getTitle());
        startActivity(intent);
        animationNouvelleActivite();
    }
}
