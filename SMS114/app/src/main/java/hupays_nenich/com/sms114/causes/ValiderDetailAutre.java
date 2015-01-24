package hupays_nenich.com.sms114.causes;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.Dialogue;
import hupays_nenich.com.sms114.nombreVictime.NombreVictimeActivity;

/**
 * Created by Jérémy on 12/01/2015.
 */
public class ValiderDetailAutre implements View.OnClickListener{

    DetailAutreActivity activity;

    public ValiderDetailAutre(DetailAutreActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        activity.getMessage().setDetails_causes(activity.getDetail());
        Intent intent = new Intent(activity, NombreVictimeActivity.class);
        activity.lancerActivity(NombreVictimeActivity.class);

    }
}
