package hupays_nenich.com.sms114.nombreVictime;

import android.widget.CompoundButton;

/**
 * Created by Jérémy on 19/01/2015.
 */
public class EnvironListener implements CompoundButton.OnCheckedChangeListener{

    NombreVictimeActivity activity;

    public EnvironListener(NombreVictimeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(activity.environ.isChecked())
            activity.inconnu.setChecked(false);
    }
}
