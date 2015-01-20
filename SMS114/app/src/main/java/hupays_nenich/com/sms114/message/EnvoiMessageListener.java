package hupays_nenich.com.sms114.message;

import android.view.View;

import hupays_nenich.com.sms114.Dialogue;

/**
 * Created by Jérémy on 20/01/2015.
 */
public class EnvoiMessageListener implements View.OnClickListener{

    private MessageActivity activity;

    public EnvoiMessageListener(MessageActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Dialogue d = new Dialogue(activity,activity.getMessageFinal(),"test");

        //envoyer le message et mettre une pop-up l'indiquant
    }
}
