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

        // Envoi le message
        String msg = activity.getMessageFinal();


        /*try {
            SmsManager.getDefault().sendTextMessage(activity.getMessage().getNumero(), null, msg, null, null);
            Toast.makeText(activity.getApplicationContext(), "SMS Envoyé!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(activity.getApplicationContext(),"L'envoi du SMS a échoué", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }*/

        // Utiliser l application SMS du telephone
        /*try {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.putExtra(msg, "default content");
            sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"L'envoi du SMS a échoué", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }*/
        activity.ecrireLog("Fin",1, 0, 0, msg);
    }
}
