package hupays_nenich.com.sms114.symptome;

import android.view.View;

import hupays_nenich.com.sms114.Dialogue;

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
        Dialogue d = new Dialogue(activity,activity.getMessage().toString(),"test");

        //intent

    }
}
