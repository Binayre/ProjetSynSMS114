package hupays_nenich.com.sms114;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jérémy on 10/01/2015.
 */
public abstract  class GlobalActivity extends ActionBarActivity implements MediaScannerConnection.MediaScannerConnectionClient{

    protected Message message;
    protected String titre;
    protected Button btnRetour, btnSuivant;
    private static  int numero = -1;

    //pour les log
    protected static long heure_debut = 0;
    public static int nb_activite_visite = 0;
    private static MediaScannerConnection msConn;
    private static File log_file;
    private static int num_test;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();


        if(intent != null){
            this.message = (Message)intent.getSerializableExtra("message");
            this.titre = intent.getStringExtra("titre");
        }

        //log-------------------------------------------------------------------------------
        if(numero == -1) {
            msConn = new MediaScannerConnection(this.getApplicationContext(), this);
            String dir = Environment.getExternalStorageDirectory() + "/Documents/Tests_utilisateurs/";
            File directory = new File(dir);
            if (!directory.exists()) {
                Log.i("TEST","Le fichier/répertoire n'existe pas");
            } else if (!directory.isDirectory()) {
                Log.i("TEST","Le chemin correspond à un fichier et non à un répertoire");
            } else {
                File[] subfiles = directory.listFiles();
                num_test = subfiles.length;
            }
        }
        //-----------------------------------------------------------------------------------


        //pour la gestion du fil d'Arianne
        numero++;


        if(titre!=null) {
            if(numero >= 2) {
               int i = this.titre.lastIndexOf(">");
                if(i != -1)
                    this.titre = "..."+this.titre.substring(i);
            }

            /*if(numero%4 == 0)
                this.setTitle("...>" + getNouveauTitre());
             else*/

            this.setTitle(titre + ">" + getNouveauTitre());

        }
        else{
            this.setTitle(getNouveauTitre());
        }
    }

    public abstract String getNouveauTitre();

    public void animationNouvelleActivite(){
        //l'activite entrante arrive par la droite, l'activite sortante sort par la gauche
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }


    //servira a ecrire dans le fichier de log
    public void ecrireLog(String partie_message){


        msConn = new MediaScannerConnection(this.getApplicationContext(), this);

        String dir = Environment.getExternalStorageDirectory() + "/Documents/Tests_utilisateurs/";
        log_file = new File(dir, "log_"+Integer.toString(num_test)+".txt");

        msConn.connect();


        /*Write to file*/
        try {
            FileWriter fileWriter = new FileWriter(log_file,true);//= new FileWriter(log_file);
            fileWriter.append(Long.toString((System.currentTimeMillis()-heure_debut)/1000)+" secondes\n"+partie_message+ "\n\n");
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onMediaScannerConnected() {
        msConn.scanFile(log_file.getAbsolutePath(), null);
    }

    @Override
    public void onScanCompleted(String path, Uri uri) {
        msConn.disconnect();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        ecrireLog("Retour avec bouton Back du device");
    }

    @Override
    public void onResume(){
        super.onResume();
        nb_activite_visite++;
    }

    @Override
    public void finish(){
        super.finish();
        numero--;
        //log
        ecrireLog("Retour en arrière");


        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    public Button getBtnRetour() {
        return btnRetour;
    }

    public Button getBtnSuivant() {
        return btnSuivant;
    }

    public Message getMessage() { return message; }

    public void lancerActivity(Class<?> suivante){
        Intent intent = new Intent(this,suivante);
        intent.putExtra("message",message);
        intent.putExtra("titre",this.getTitle());
        startActivity(intent);
        animationNouvelleActivite();
    }
}
