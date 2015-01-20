package hupays_nenich.com.sms114.localisation;

import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jérémy on 20/01/2015.
 */
public class AdresseListener implements View.OnClickListener{

    private LocalisationActivity activity;

    public AdresseListener(LocalisationActivity activity) {
        this.activity = activity;
    }

    public String chargerDonnees(){
        try {
            InputStream input= activity.openFileInput("adresse.txt");//open the text file for reading

            if(input!=null) {
                InputStreamReader inputreader = new InputStreamReader(input);
                BufferedReader fadresse = new BufferedReader(inputreader);

                String mot = fadresse.readLine(); //prenom
                mot = fadresse.readLine(); //nom
                mot = fadresse.readLine(); //telephone

                mot = "Adresse:"+fadresse.readLine()+"\n";
                mot = mot + "Ville: "+fadresse.readLine()+"\n";
                mot = mot + "Code postal: "+fadresse.readLine()+"\n";

                String immeuble = fadresse.readLine();
                if (Integer.parseInt(immeuble) == 1) {
                    mot = mot + "En immeuble\n";
                    mot = mot + "Etage: "+fadresse.readLine()+"\n";
                    mot = mot + "Porte: "+fadresse.readLine()+"\n";
                    mot = mot + "Code porte: "+fadresse.readLine()+"\n";
                }

                fadresse.close();
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
    public void onClick(View v) {
        activity.setTexte(chargerDonnees());
    }
}
