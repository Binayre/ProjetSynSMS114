package hupays_nenich.com.sms114.causes;


import android.view.View;
import android.widget.Button;

/**
 * Created by Jérémy on 10/01/2015.
 */

/**
 * valide la cause et affiche l'activity permettant d'en selectionner les details
 */
public class CauseListener implements View.OnClickListener{

    private CauseActivity activity;
    private Class<?> suivante;

    public CauseListener(CauseActivity activity, Class<?> suivante) {
        this.activity = activity;
        this.suivante = suivante;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        activity.getMessage().setCause(b.getText().toString());
        
        activity.ecrireLog("Detail Causes "+ activity.getMessage().getCause(),1, 0, 0, activity.getMessage().getCause());

        activity.lancerActivity(suivante);
    }
}
