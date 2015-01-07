package hupays_nenich.com.sms114.mesInfos;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jérémy on 07/01/2015.
 */
public class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{

    private TextView txtEtage, txtCodePorte, txtPorte;
    private EditText edtEtage, edtCodePorte, edtPorte;

    public CheckBoxListener(TextView txtEtage, TextView txtCodePorte, TextView txtPorte, EditText edtEtage, EditText edtCodePorte, EditText edtPorte) {
        this.txtEtage = txtEtage;
        this.txtCodePorte = txtCodePorte;
        this.txtPorte = txtPorte;
        this.edtEtage = edtEtage;
        this.edtCodePorte = edtCodePorte;
        this.edtPorte = edtPorte;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){
            txtEtage.setVisibility(View.VISIBLE);
            txtCodePorte.setVisibility(View.VISIBLE);
            txtPorte.setVisibility(View.VISIBLE);
            edtEtage.setVisibility(View.VISIBLE);
            edtCodePorte.setVisibility(View.VISIBLE);
            edtPorte.setVisibility(View.VISIBLE);
        }
        else{
            txtEtage.setVisibility(View.INVISIBLE);
            txtCodePorte.setVisibility(View.INVISIBLE);
            txtPorte.setVisibility(View.INVISIBLE);
            edtEtage.setVisibility(View.INVISIBLE);
            edtCodePorte.setVisibility(View.INVISIBLE);
            edtPorte.setVisibility(View.INVISIBLE);
        }
    }
}
