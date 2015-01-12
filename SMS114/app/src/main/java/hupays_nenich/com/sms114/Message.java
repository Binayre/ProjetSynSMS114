package hupays_nenich.com.sms114;

import java.io.Serializable;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class Message implements Serializable{

    private String numero, cause, details_causes, symptomes, adresse, precisions;
    private int nb_victime;

    public Message() {
        this.numero = "";
        this.cause = "";
        this.details_causes = "";
        this.symptomes = "";
        this.adresse = "";
        this.precisions = "";
        this.nb_victime = 0;
    }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDetails_causes() {
        return details_causes;
    }

    public void setDetails_causes(String details_causes) {
        this.details_causes = details_causes;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrecisions() {
        return precisions;
    }

    public void setPrecisions(String precisions) {
        this.precisions = precisions;
    }

    public int getNb_victime() {
        return nb_victime;
    }

    public void setNb_victime(int nb_victime) {
        this.nb_victime = nb_victime;
    }

    @Override
    public String toString() {
        return "Je suis témoin de : "+ cause +", "+ details_causes+"\n"+
               "Nombre de victime : "+ nb_victime+"\n"+
               "Profil de la victime :"+ "age approc\n"+
               "Symptômes : "+ symptomes +"\n"+
               "Zones concernées : "+ "emplacement\n"+
               "Précisions :"+ precisions +"\n"+
               "Localisation : "+ adresse +"\n";

    }
}
