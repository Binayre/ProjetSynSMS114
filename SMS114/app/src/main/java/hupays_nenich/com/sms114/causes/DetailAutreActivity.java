package hupays_nenich.com.sms114.causes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import hupays_nenich.com.sms114.R;
import hupays_nenich.com.sms114.RetourListener;

public class DetailAutreActivity extends DetailCauseActivity {

    private EditText edtAutre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_autre);


        edtAutre = (EditText)findViewById(R.id.edtAutrePrecision);

        btnRetour = (Button)findViewById(R.id.btnRetourCauses);
        btnRetour.setOnClickListener(new RetourListener(this));
        btnSuivant =(Button)findViewById(R.id.btnNbVictime);

        btnSuivant.setOnClickListener(new ValiderDetailAutre(this));
    }

    @Override
    public String getNouveauTitre() {
        return "Autres";
    }

    public String getDetail(){
        return edtAutre.getText().toString();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_autre, menu);
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
