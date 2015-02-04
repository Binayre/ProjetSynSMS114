package hupays_nenich.com.sms114.causes;

import android.view.View;

/**
 * Created by Jérémy on 11/01/2015.
 */

/**
 * Avtive le bouton d acces la l activity suivante si au moins un item est selectionne
 */
public class DetailCauseListener implements View.OnClickListener{


    private DetailCauseActivity activity;

    public DetailCauseListener(DetailCauseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if(activity.nbBoutonsSelectionnes()>0)
            activity.getBtnSuivant().setEnabled(true);
        else
            activity.getBtnSuivant().setEnabled(false);
    }
}
