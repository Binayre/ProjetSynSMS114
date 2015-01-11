package hupays_nenich.com.sms114.causes;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ToggleButton;

/**
 * Created by Jérémy on 11/01/2015.
 */

/**
 * change le background d'un ToggleButton
 */
public class DetailCauseListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        ToggleButton btn = (ToggleButton)v;

        if(btn.isChecked()){
            btn.setBackgroundColor(Color.argb(255,0,255,0));
        }
        else{
            btn.setBackgroundColor(Color.argb(255,224,224,224));
        }
    }
}
