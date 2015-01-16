package hupays_nenich.com.sms114.causes;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.Dialogue;
import hupays_nenich.com.sms114.nombreVictime.NombreVictimeActivity;

/**
 * Created by Jérémy on 11/01/2015.
 */

/***
 * Valide les details de la cause selectionnes par l'utilisateur, cette classe fonctionne pour tous types de causes
 */
public class ValiderDetailListener implements View.OnClickListener{

    DetailCauseActivity activity;

    public ValiderDetailListener(DetailCauseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setDetails_causes(activity.boutonSelectionne());
        Intent intent = new Intent(activity, NombreVictimeActivity.class);
        intent.putExtra("message",activity.getMessage());
        activity.startActivity(intent);
        activity.animationNouvelleActivite();
    }
}
