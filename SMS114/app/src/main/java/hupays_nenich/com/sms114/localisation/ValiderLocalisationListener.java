package hupays_nenich.com.sms114.localisation;

import android.view.View;

import hupays_nenich.com.sms114.Dialogue;

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

        Dialogue d = new Dialogue(activity,activity.getMessage().toString(),"test");

        //activity.lancerActivity(??);

    }
}
