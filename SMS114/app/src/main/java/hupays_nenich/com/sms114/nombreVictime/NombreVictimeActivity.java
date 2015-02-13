package hupays_nenich.com.sms114.nombreVictime;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;
import hupays_nenich.com.sms114.detailVictime.DetailVictimeActivity;
import hupays_nenich.com.sms114.precisions.PrecisionActivity;


public class NombreVictimeActivity extends GlobalActivity implements SeekBar.OnSeekBarChangeListener{

    public SeekBar barre;
    public TextView nbvict;
    public CheckBox environ, inconnu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_victime);


        barre = (SeekBar)findViewById(R.id.barreNbVictime);
        nbvict = (TextView)findViewById(R.id.txtNombre);

        barre.setOnSeekBarChangeListener(this);

        barre.setProgress(Integer.parseInt(message.getNb_victime()));
        nbvict.setText(message.getNb_victime());


        inconnu = (CheckBox)findViewById(R.id.checkBoxInconnu);
        inconnu.setOnCheckedChangeListener(new InconnuListener(this));

        environ = (CheckBox)findViewById(R.id.checkBoxEnviron);
        environ.setOnCheckedChangeListener(new EnvironListener(this));


        btnRetour = (Button)findViewById(R.id.btnRetourDetailCause);
        btnSuivant = (Button)findViewById(R.id.btnSuivantNbVictime);


        btnRetour.setOnClickListener(new RetourListener(this));
        btnSuivant.setOnClickListener(new ValiderNombreVictimeListener(this));

        barre.setProgress(0);
        nbvict.setText("?");
    }

    @Override
    public String getNouveauTitre() {
        return "Nombre de victimes";
    }

    /**
     * renvoi le nombre saisi par l'utilisateur
     * @return
     */
    public String nbVictime(){

        message.setChifreNombreVictime(barre.getProgress()-1);

        if(inconnu.isChecked()){
            message.setChifreNombreVictime(2);//n'a pas de sens, juste pour dire: on ne sait pas
            return inconnu.getText().toString();
        }
        else{
            if(environ.isChecked())
                if(barre.getProgress() == 0)
                    return "Je ne sais pas "+ environ.getText().toString();
                else if(barre.getProgress() < 11)
                    return nbvict.getText().toString() + " "+ environ.getText().toString();
                else
                    return "plus de 10";
            else
                 if(barre.getProgress() == 0)
                    return "Je ne sais pas ";
                else if(barre.getProgress() < 11)
                    return nbvict.getText().toString();
                else return "plus de 10";
        }
    }

    /**
     * savoir quelle activity lancer apres
     * @return
     */
    public Class<?> suivante(){
        if((barre.getProgress()==0) && (!inconnu.isChecked())){
            return PrecisionActivity.class; //renvoyer l'activity qui s'occupe de l'adresse ou des precisions
        }
        else{
            return DetailVictimeActivity.class; //renvoyer l'activity qui s'occuper de detailler les victimes
        }
    }

    public String suivanteLog(){
        if((barre.getProgress()==0) && (!inconnu.isChecked())){
            return "Précisions"; //renvoyer l'activity qui s'occupe de l'adresse ou des precisions
        }
        else{
            return "Détail victime"; //renvoyer l'activity qui s'occuper de detailler les victimes
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        nbvict.setText(Integer.toString(progress-1));

        if(progress < 2){
            environ.setChecked(false);
        }

         if (progress > 1) {
             btnSuivant.setText(R.string.DetailVictime);
             inconnu.setChecked(false);

             if(progress == 11){
                 nbvict.setText("10+");
             }
         }
         else {

             btnSuivant.setText(R.string.precision);
             inconnu.setChecked(false);
             if(progress < 1)
              nbvict.setText("?");
         }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
