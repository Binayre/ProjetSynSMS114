package hupays_nenich.com.sms114.body;

import android.view.View;

import hupays_nenich.com.sms114.precisions.PrecisionActivity;

/**
 * Created by Jérémy on 23/01/2015.
 */
public class ValiderBodyListener implements View.OnClickListener{

    BodyActivity activity;

    public ValiderBodyListener(BodyActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if(activity.boutonSelectionne().equals("")){
            activity.getMessage().setZone_concernee("Non renseignées");
        }
        else
            activity.getMessage().setZone_concernee(activity.boutonSelectionne());

        activity.ecrireLog("Body --> Précisions");

        activity.lancerActivity(PrecisionActivity.class);

    }
}
