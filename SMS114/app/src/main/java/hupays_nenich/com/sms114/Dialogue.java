package hupays_nenich.com.sms114;

/**
 * Created by Jérémy on 11/01/2015.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * affiche une boite de dialogue
 */
public class Dialogue extends AlertDialog.Builder implements DialogInterface.OnClickListener {

    public Dialogue(Context context, String msg, String titre) {
        super(context);

        this.setMessage(msg);
        this.setTitle(titre);
        this.setPositiveButton("OK", this);
        this.setCancelable(true);
        this.create().show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
    }


}
