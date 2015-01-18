package hupays_nenich.com.sms114.nombreVictime;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;


import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;
import hupays_nenich.com.sms114.detailVictime.DetailVictimeActivity;
import hupays_nenich.com.sms114.precisions.PrecisionActivity;


public class NombreVictimeActivity extends GlobalActivity implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener{

    private SeekBar barre;
    private TextView nbvict;
    private CheckBox environ, inconnu;

    public NombreVictimeActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_victime);


        barre = (SeekBar)findViewById(R.id.barreNbVictime);
        nbvict = (TextView)findViewById(R.id.txtNombre);

        barre.setOnSeekBarChangeListener(this);

        barre.setProgress(Integer.parseInt(message.getNb_victime()));
        nbvict.setText(message.getNb_victime());

        environ = (CheckBox)findViewById(R.id.checkBoxEnviron);
        inconnu = (CheckBox)findViewById(R.id.checkBoxInconnu);
        inconnu.setOnCheckedChangeListener(this);


        btnRetour = (Button)findViewById(R.id.btnRetourDetailCause);
        btnSuivant = (Button)findViewById(R.id.btnSuivantNbVictime);


        btnRetour.setOnClickListener(new RetourListener(this));
        btnSuivant.setOnClickListener(new ValiderNombreVictimeListener(this));
    }

    @Override
    public String getNouveauTitre() {
        return "Nombre de victime";
    }

    /**
     * renvoi le nombre saisi par l'utilisateur
     * @return
     */
    public String nbVictime(){

        if(inconnu.isChecked()){
            return inconnu.getText().toString();
        }
        else{
            if(environ.isChecked())
                return nbvict.getText().toString() + " "+ environ.getText().toString();
            else
                return nbvict.getText().toString();
        }
    }

    /**
     * savoir quelle activity lancer apres
     * @return
     */
    public Class<?> suivante(){
        if((inconnu.isChecked()) || (barre.getProgress()==0)){
            return PrecisionActivity.class; //renvoyer l'activity qui s'occupe de l'adresse ou des precisions
        }
        else{
            return DetailVictimeActivity.class; //renvoyer l'activity qui s'occuper de detailler les victimes
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nombre_victime, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        nbvict.setText(Integer.toString(progress));

        if(!inconnu.isChecked()) {
            if (progress > 0)
                btnSuivant.setText(R.string.DetailVictime);
            else
                btnSuivant.setText(R.string.precision);
        }
       else
           btnSuivant.setText(R.string.precision);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(inconnu.isChecked())
            btnSuivant.setText(R.string.precision);
        else{
            if (barre.getProgress() > 0)
                btnSuivant.setText(R.string.DetailVictime);
            else
                btnSuivant.setText(R.string.precision);
        }

    }
}
