package hupays_nenich.com.sms114;

import java.io.Serializable;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class Message implements Serializable{

    private String numero, cause, details_causes, symptomes, adresse, precisions;
    private String nb_victime, profil_victime, zone_concernee;

    public Message() {
        this.numero = "";
        this.cause = "";
        this.details_causes = "";
        this.symptomes = "";
        this.adresse = "";
        this.precisions = "";
        this.nb_victime = "0";
        this.profil_victime = "";
        this.zone_concernee = "";
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

    public String getNb_victime() {
        return nb_victime;
    }

    public void setNb_victime(String nb_victime) {
        this.nb_victime = nb_victime;
    }

    public String getZone_concernee() {  return zone_concernee; }

    public void setZone_concernee(String zone_concernee) { this.zone_concernee = zone_concernee; }

    public String getProfil_victime() { return profil_victime; }

    public void setProfil_victime(String profil_victime) { this.profil_victime = profil_victime; }

    @Override
    public String toString() {

        String s = "";

        s="Je suis témoin de : "+ cause + " impliquant "+details_causes + "\n";
        s = s + "Nombre de victime(s) : "+ nb_victime+"\n";

        //la chaine contient au moins 1 chiffres
        if(nb_victime.matches("[1-9]+[^0-9]*")){
            s = s + "Profil des victime :"+ profil_victime+"\n" +
                    "Les victimes souffrent de "+ symptomes +"\n";

            if(!zone_concernee.equals(""))
                s = s + "Zone(s) douloureuse(s) : "+ zone_concernee +"\n";
        }

        if(!precisions.equals(""))
            s = s + "Précisions : "+ precisions +"\n";

        s = s + "Localisation : \n"+ adresse +"\n";


        return s;
    }
}
