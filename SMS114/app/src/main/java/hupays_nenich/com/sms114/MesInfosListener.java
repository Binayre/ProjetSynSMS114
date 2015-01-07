package hupays_nenich.com.sms114;

import android.content.Intent;
import android.view.View;

import hupays_nenich.com.sms114.mesInfos.MesInfosActivity;

/**
 * Created by Jérémy on 07/01/2015.
 */
public class MesInfosListener implements View.OnClickListener{

    AccueilActivity activity;

    public MesInfosListener(AccueilActivity activity){
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, MesInfosActivity.class);
        activity.startActivityForResult(intent,10);
    }
}
