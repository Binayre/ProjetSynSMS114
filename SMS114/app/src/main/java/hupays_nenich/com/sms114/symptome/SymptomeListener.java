package hupays_nenich.com.sms114.symptome;

import android.graphics.Color;
import android.view.View;
import android.widget.ToggleButton;

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
        if(activity.nbBoutonsSelectionnes()>0)
            activity.getBtnSuivant().setEnabled(true);
        else
            activity.getBtnSuivant().setEnabled(false);
    }
}
