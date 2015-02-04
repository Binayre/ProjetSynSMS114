package hupays_nenich.com.sms114.causes;

import android.view.View;

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

        activity.ecrireLog(activity.getMessage().getDetails_causes());

        activity.lancerActivity(NombreVictimeActivity.class);
    }
}
