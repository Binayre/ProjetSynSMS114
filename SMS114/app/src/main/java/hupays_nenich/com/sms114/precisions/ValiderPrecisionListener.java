package hupays_nenich.com.sms114.precisions;

import android.view.View;

import hupays_nenich.com.sms114.localisation.LocalisationActivity;

/**
 * Created by Jérémy on 17/01/2015.
 */
public class ValiderPrecisionListener implements View.OnClickListener{

    private PrecisionActivity activity;

    public ValiderPrecisionListener(PrecisionActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.getMessage().setPrecisions(activity.precisions());

        activity.ecrireLog("Précisions ---> Localisation");

        activity.lancerActivity(LocalisationActivity.class);
    }
}
