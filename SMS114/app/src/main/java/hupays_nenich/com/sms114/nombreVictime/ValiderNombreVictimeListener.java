package hupays_nenich.com.sms114.nombreVictime;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.Dialogue;

/**
 * Created by Jérémy on 13/01/2015.
 */
public class ValiderNombreVictimeListener implements View.OnClickListener{

    private NombreVictimeActivity activity;

    public ValiderNombreVictimeListener(NombreVictimeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setNb_victime(activity.nbVictime());
        Dialogue d = new Dialogue(activity,activity.getMessage().toString(),"test");

        /*Intent intent = new Intent(activity,activity.suivante());
        intent.putExtra("message",activity.getMessage());
        activity.startActivity(intent);*/


    }
}
