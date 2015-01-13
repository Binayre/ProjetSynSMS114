package hupays_nenich.com.sms114.detailVictime;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

import hupays_nenich.com.sms114.GlobalActivity;
import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class DetailVictimeActivity extends GlobalActivity{

    private ArrayList<CheckBox> liste;
    private CheckBox handicap, enceinte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_victime);

        liste = new ArrayList<CheckBox>();

        liste.add((CheckBox)findViewById(R.id.checkBoxNourrisson));
        liste.add((CheckBox)findViewById(R.id.checkBoxEnfant));
        liste.add((CheckBox)findViewById(R.id.checkBoxAdo));
        liste.add((CheckBox)findViewById(R.id.checkBoxAdulte));
        liste.add((CheckBox)findViewById(R.id.checkBoxSenior));

        handicap = (CheckBox)findViewById(R.id.checkBoxHandicap);
        enceinte = (CheckBox)findViewById(R.id.checkBoxEnceinte);

        btnRetour = (Button)findViewById(R.id.btnRetourNbVictime);
        btnRetour.setOnClickListener(new RetourListener(this));

        btnSuivant = (Button)findViewById(R.id.btnSymptome);
        btnSuivant.setOnClickListener(new ValiderDetailVictime(this));

    }

    public String detail(){
        String s="";

        for(int i=0;i<liste.size();i++){
            if(liste.get(i).isChecked())
                s = s+", "+liste.get(i).getText().toString();
        }

        if(handicap.isChecked())
            s = s + "\n\t" + handicap.getText().toString();

        if(enceinte.isChecked())
            s = s + "\n\t" + enceinte.getText().toString();

        return s;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_victime, menu);
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
