package hupays_nenich.com.sms114.symptome;

import android.view.View;

import hupays_nenich.com.sms114.body.BodyActivity;
import hupays_nenich.com.sms114.precisions.PrecisionActivity;

/**
 * Created by Jérémy on 14/01/2015.
 */
public class ValiderSymptomeListener implements View.OnClickListener{

    private SymptomeActivity activity;

    public ValiderSymptomeListener(SymptomeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setSymptomes(activity.boutonSelectionne());

        Class<?> suivante = PrecisionActivity.class;

        if(activity.lancerBody()) {
            suivante = BodyActivity.class;
            activity.ecrireLog("Body",1, 0, 0, activity.getMessage().getSymptomes());
        }
        else
            activity.ecrireLog("Précisions",1, 0, 0, activity.getMessage().getSymptomes());

        activity.lancerActivity(suivante);

    }
}
