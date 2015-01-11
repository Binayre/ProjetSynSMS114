package hupays_nenich.com.sms114;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Jérémy on 10/01/2015.
 */
public class GlobalActivity extends ActionBarActivity{

    protected Message message;

    //pour savoir quelle est l'activite qui suit et celle qui precede
    private Class<?> suivante;
    private Class<?> precedente;

    public Message getMessage() { return message; }

    public Class<?> getSuivante() {
        return suivante;
    }

    public void setSuivante(Class<?> suivante) {
        this.suivante = suivante;
    }

    public Class<?> getPrecedente() {
        return precedente;
    }

    public void setPrecedente(Class<?> precedente) {
        this.precedente = precedente;
    }
}
