package hupays_nenich.com.sms114;

import android.view.View;

import hupays_nenich.com.sms114.causes.CauseActivity;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class SMS114Listener implements View.OnClickListener{

   private AccueilActivity activity;

    public SMS114Listener(AccueilActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setNumero("114");
        activity.ecrireLog("Cause",1, 0, 0, "");
        activity.lancerActivity(CauseActivity.class);
    }
}
