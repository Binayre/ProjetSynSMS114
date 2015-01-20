package hupays_nenich.com.sms114;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class RetourListener implements View.OnClickListener{

    private GlobalActivity activity;

    public RetourListener(GlobalActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.finish();
    }
}
