package hupays_nenich.com.sms114.body;

import android.widget.ToggleButton;

/**
 * Created by Jérémy on 23/01/2015.
 */
public class ElementBody {
    private ToggleButton btn;
    private String partie;

    public ElementBody(ToggleButton btn, String partie) {
        this.btn = btn;
        this.partie = partie;
    }

    public ToggleButton getBtn() {
        return btn;
    }

    public void setBtn(ToggleButton btn) {
        this.btn = btn;
    }

    public String getPartie() {
        return partie;
    }

    public void setPartie(String partie) {
        this.partie = partie;
    }
}
