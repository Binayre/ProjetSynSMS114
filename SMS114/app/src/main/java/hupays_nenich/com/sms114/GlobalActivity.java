package hupays_nenich.com.sms114;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class GlobalActivity extends ActionBarActivity{

    protected Message message;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public Message getMessage() { return message; }
}
