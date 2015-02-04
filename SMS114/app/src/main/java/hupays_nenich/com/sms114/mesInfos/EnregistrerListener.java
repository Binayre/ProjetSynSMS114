package hupays_nenich.com.sms114.mesInfos;

import android.view.View;

/**
 * Created by Jérémy on 07/01/2015.
 */
public class EnregistrerListener implements View.OnClickListener{

    MesInfosActivity activity;

    public EnregistrerListener(MesInfosActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.sauvegarderDonnees();
        activity.onBackPressed();
        activity.finish();
    }
}
