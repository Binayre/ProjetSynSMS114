package hupays_nenich.com.sms114;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class GlobalActivity extends ActionBarActivity{

    protected Message message;
    protected Button btnRetour, btnSuivant;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();

        if(intent != null){
            this.message = (Message)intent.getSerializableExtra("message");
        }

    }

    public Button getBtnRetour() {
        return btnRetour;
    }

    public Button getBtnSuivant() {
        return btnSuivant;
    }

    public Message getMessage() { return message; }
}
