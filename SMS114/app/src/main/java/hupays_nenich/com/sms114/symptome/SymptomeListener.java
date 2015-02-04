package hupays_nenich.com.sms114.symptome;

import android.view.View;

import hupays_nenich.com.sms114.R;

/**
 * Created by Jérémy on 14/01/2015.
 */
public class SymptomeListener implements View.OnClickListener{

    private SymptomeActivity activity;

    public SymptomeListener(SymptomeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        /*if(activity.nbBoutonsSelectionnes()>0)
            activity.getBtnSuivant().setEnabled(true);
        else
            activity.getBtnSuivant().setEnabled(false);*/

        if(activity.lancerBody())
            activity.getBtnSuivant().setText(R.string.emplacement_douloureux);
        else
            activity.getBtnSuivant().setText(R.string.precision);
    }
}
