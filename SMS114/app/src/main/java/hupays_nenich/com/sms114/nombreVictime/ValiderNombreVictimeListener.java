package hupays_nenich.com.sms114.nombreVictime;

import android.view.View;

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

        activity.ecrireLog("Nombre victimes ---> "+activity.suivanteLog());

        activity.lancerActivity(activity.suivante());


    }
}
