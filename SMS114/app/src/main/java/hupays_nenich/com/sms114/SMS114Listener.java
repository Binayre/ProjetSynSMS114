package hupays_nenich.com.sms114;

import android.accounts.AccountManager;
import android.content.Intent;
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
        activity.ecrireLog("Click sur SMS 114");

        activity.lancerActivity(CauseActivity.class);
    }
}
