package hupays_nenich.com.sms114;

import java.io.Serializable;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class Message implements Serializable{

    private String numero, cause, details_causes, symptomes, adresse, precisions;
    private String nb_victime, profil_victime, zone_concernee;


    private int chifreNombreVictime; //peut etre utile d'avoir directement le chiffre


    public Message() {
        this.numero = "";
        this.cause = "";
        this.details_causes = "";
        this.symptomes = "";
        this.adresse = "";
        this.precisions = "";
        this.nb_victime = "0";
        this.chifreNombreVictime = 0;
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

    public int getChifreNombreVictime() { return chifreNombreVictime; }

    public void setChifreNombreVictime(int chifreNombreVictime) { this.chifreNombreVictime = chifreNombreVictime;}


    @Override
    public String toString() {

        String s = new String();

        /*
            Accident de la route impliquant ...
            Incendie de ...
            Blessure animales de ...
            Catastrophe naturelle : ...
            Autres : ...
         */

        s = "\nJe suis témoin de : " + cause;

        if(cause.contains("Accident"))
            s = s + " impliquant " + details_causes;
        else if(cause.contains("Incendie") || cause.contains("Blessure"))
            s = s + " de " + details_causes;
        else
            s = s + " : " + details_causes;

        s = s + "\nNombre de victimes : " + nb_victime;

        //la chaine contient au moins 1 chiffres
        if(chifreNombreVictime > 0){
            if(!(profil_victime.isEmpty()))
                s = s + "\nProfils des victimes : " + profil_victime;

            if(!(symptomes.isEmpty()))
                s = s + "\nSymptômes : " + symptomes;

            if(!(zone_concernee.isEmpty()))
                s = s + "\nZones douloureuses : " + zone_concernee;
        }

        if(!(precisions.isEmpty()))
            s = s + "\nPrécisions : " + precisions;

        s = s + "\nLocalisation : " + adresse;
        return s;
    }
}
