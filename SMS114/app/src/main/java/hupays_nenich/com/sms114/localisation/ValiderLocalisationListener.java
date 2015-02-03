package hupays_nenich.com.sms114.localisation;

import android.view.View;

import hupays_nenich.com.sms114.message.MessageActivity;

/**
 * Created by Jérémy on 20/01/2015.
 */
public class ValiderLocalisationListener implements View.OnClickListener{

    private LocalisationActivity activity;

    public ValiderLocalisationListener(LocalisationActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.getMessage().setAdresse(activity.getTexte());

        activity.ecrireLog(activity.getMessage().getAdresse());

        activity.lancerActivity(MessageActivity.class);

    }
}
