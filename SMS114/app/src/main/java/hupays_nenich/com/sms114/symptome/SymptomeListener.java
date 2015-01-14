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

        ToggleButton btn = (ToggleButton)v;

        if(btn.isChecked()){
            btn.setBackgroundColor(Color.argb(255, 0, 255, 0));
        }
        else{
            btn.setBackgroundColor(Color.argb(255,224,224,224));
        }

        if(activity.nbBoutonsSelectionnes()>0)
            activity.getBtnSuivant().setEnabled(true);
        else
            activity.getBtnSuivant().setEnabled(false);
    }
}
