package hupays_nenich.com.sms114.mesInfos;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.AccueilActivity;

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
        activity.finish();
    }
}
