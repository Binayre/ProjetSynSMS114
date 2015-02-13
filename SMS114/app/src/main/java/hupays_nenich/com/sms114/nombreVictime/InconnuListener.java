package hupays_nenich.com.sms114.nombreVictime;

import android.widget.CompoundButton;

import hupays_nenich.com.sms114.R;

/**
 * Created by Jérémy on 19/01/2015.
 */
public class InconnuListener implements CompoundButton.OnCheckedChangeListener {

    NombreVictimeActivity activity;

    public InconnuListener(NombreVictimeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(activity.inconnu.isChecked()) {
            activity.getBtnSuivant().setText(R.string.DetailVictime);
            activity.barre.setEnabled(false);
            activity.environ.setChecked(false);
            activity.environ.setEnabled(false);
            activity.nbvict.setEnabled(false);
        }
        else{
            activity.barre.setEnabled(true);
            activity.environ.setEnabled(true);
            activity.nbvict.setEnabled(true);

            if(activity.barre.getProgress() == 0){
                activity.getBtnSuivant().setText(R.string.precision);
            }
        }
    }
}
