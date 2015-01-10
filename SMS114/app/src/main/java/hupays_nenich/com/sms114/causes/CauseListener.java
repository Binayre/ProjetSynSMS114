package hupays_nenich.com.sms114.causes;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Jérémy on 10/01/2015.
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


        Toast .makeText(activity.getApplicationContext(), ""+activity.getMessage().getCause(), Toast.LENGTH_LONG).show();
    }
}
