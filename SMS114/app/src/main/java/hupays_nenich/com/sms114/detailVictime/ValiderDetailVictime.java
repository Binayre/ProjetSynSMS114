package hupays_nenich.com.sms114.detailVictime;

import android.view.View;

import hupays_nenich.com.sms114.symptome.SymptomeActivity;

/**
 * Created by Jérémy on 13/01/2015.
 */
public class ValiderDetailVictime implements View.OnClickListener{

    private DetailVictimeActivity activity;

    public ValiderDetailVictime(DetailVictimeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setProfil_victime(activity.detail());

        activity.ecrireLog("Détail victimes --> Symptômes");

        activity.lancerActivity(SymptomeActivity.class);
    }
}
