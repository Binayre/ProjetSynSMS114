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
            activity.getBtnSuivant().setText(R.string.precision);
            activity.barre.setProgress(0);
            activity.environ.setChecked(false);
        }
    }
}
