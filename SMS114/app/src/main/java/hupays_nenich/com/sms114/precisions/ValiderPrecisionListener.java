package hupays_nenich.com.sms114.precisions;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.Dialogue;

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

        Dialogue d = new Dialogue(activity,activity.getMessage().toString(),"test");

       // activity.lancerActivity(??);
    }
}
