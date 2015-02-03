package hupays_nenich.com.sms114.message;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;


public class MessageActivity extends GlobalActivity {

    private EditText edtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btnRetour = (Button)findViewById(R.id.btnRetourLocalisation);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnEnvoiMessage);
        btnSuivant.setOnClickListener(new EnvoiMessageListener(this));

        edtMessage = (EditText)findViewById(R.id.edtMessage);

        edtMessage.setText(chargerDonnees());
        edtMessage.append(getMessage().toString());
    }

    public String getMessageFinal(){
        return edtMessage.getText().toString();
    }

    public String chargerDonnees(){
        try {
            InputStream input= openFileInput("adresse.txt");

            if(input!=null) {
                InputStreamReader inputreader = new InputStreamReader(input);
                BufferedReader finfo = new BufferedReader(inputreader);

                String mot = "Je m'appelle "+ finfo.readLine()+" "; //prenom
                mot = mot + finfo.readLine()+"\n"; //nom
                mot = mot + "Mon numéro est le "+finfo.readLine(); //telephone

                finfo.close();
                inputreader.close();
                return mot;

            }

            input.close();


        } catch (FileNotFoundException e) {
            System.out.println("Erreur, fichier non trouve " + e.toString());
            return "Fiche non renseignée.";
        }
        catch (Exception e){
            System.out.println("Erreur");
            return "Erreur lors de la lecture";
        }

        return "Erreur";
    }

    @Override
    public String getNouveauTitre() {
        return "Message";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
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
}
