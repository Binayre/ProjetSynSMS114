package hupays_nenich.com.sms114.mesInfos;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class MesInfosActivity extends GlobalActivity {

    private TextView txtEtage, txtCodePorte, txtPorte;
    private EditText edtPrenom, edtNom, edtPhone, edtAdresse, edtVille, edtCodePostal, edtEtage, edtCodePorte, edtPorte;
    private CheckBox chkImmeuble;

    public MesInfosActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_infos);

        txtEtage = (TextView)findViewById(R.id.txtEtage);
        txtCodePorte = (TextView)findViewById(R.id.txtCodePorte);
        txtPorte = (TextView)findViewById(R.id.txtPorte);

        edtPrenom = (EditText)findViewById(R.id.edtPrenom);
        edtNom = (EditText)findViewById(R.id.edtNom);
        edtPhone = (EditText)findViewById(R.id.edtTelephone);
        edtAdresse = (EditText)findViewById(R.id.edtAdresse);
        edtVille = (EditText)findViewById(R.id.edtVille);
        edtCodePostal = (EditText)findViewById(R.id.edtCodePostal);

        edtEtage = (EditText)findViewById(R.id.edtEtage);
        edtCodePorte = (EditText)findViewById(R.id.edtCodePorte);
        edtPorte = (EditText)findViewById(R.id.edtPorte);

        chkImmeuble = (CheckBox)findViewById(R.id.checkboxImmeuble);
        chkImmeuble.setOnCheckedChangeListener(new CheckBoxListener(txtEtage,txtCodePorte,txtPorte,edtEtage,edtCodePorte,edtPorte));

        btnSuivant = (Button)findViewById(R.id.btnEnregistrer);
        btnSuivant.setOnClickListener(new EnregistrerListener(this));

        btnRetour = (Button)findViewById(R.id.btnAnnuler);
        btnRetour.setOnClickListener(new RetourListener(this));

        chargerDonnees();
    }

    @Override
    public String getNouveauTitre() {
        return "Mes infos";
    }

    /**
     *
     */
    public void sauvegarderDonnees(){

        try {

            OutputStreamWriter out=new OutputStreamWriter(openFileOutput("adresse.txt",0));

            out.write(edtPrenom.getText().toString());
            out.write('\n');
            out.write(edtNom.getText().toString());
            out.write('\n');
            out.write(edtPhone.getText().toString());
            out.write('\n');
            out.write(edtAdresse.getText().toString());
            out.write('\n');
            out.write(edtVille.getText().toString());
            out.write('\n');
            out.write(edtCodePostal.getText().toString());
            out.write('\n');

            if(chkImmeuble.isChecked()) {
                out.write("1");
                out.write('\n');
                out.write(edtEtage.getText().toString());
                out.write('\n');
                out.write(edtPorte.getText().toString());
                out.write('\n');
                out.write(edtCodePorte.getText().toString());
                out.write('\n');
            }
            else{
                out.write("0");
                out.write('\n');
                out.write("-");
                out.write('\n');
                out.write("-");
                out.write('\n');
                out.write("-");
                out.write('\n');
            }

            out.close();
        }
        catch (java.io.IOException e) {
               System.out.println(e.toString());
        }

    }

    /**
     *
     */
    public void chargerDonnees(){
        try {
            InputStream input= openFileInput("adresse.txt");//open the text file for reading

            if(input!=null) {
                InputStreamReader inputreader = new InputStreamReader(input);
                BufferedReader fadresse = new BufferedReader(inputreader);

                String mot = fadresse.readLine();
                edtPrenom.setText(mot);

                mot = fadresse.readLine();
                edtNom.setText(mot);

                mot = fadresse.readLine();
                edtPhone.setText(mot);

                mot = fadresse.readLine();
                edtAdresse.setText(mot);

                mot = fadresse.readLine();
                edtVille.setText(mot);

                mot = fadresse.readLine();
                edtCodePostal.setText(mot);

                mot = fadresse.readLine();
                if (Integer.parseInt(mot) == 1) {
                    chkImmeuble.setChecked(true);

                    mot = fadresse.readLine();
                    edtEtage.setText(mot);

                    mot = fadresse.readLine();
                    edtPorte.setText(mot);

                    mot = fadresse.readLine();
                    edtCodePorte.setText(mot);

                }
                else{
                    chkImmeuble.setChecked(false);
                }

                fadresse.close();
                inputreader.close();

            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erreur, fichier non trouve " + e.toString());

        }
        catch (Exception e){
            System.out.println("Erreur");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mes_infos, menu);
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
}
