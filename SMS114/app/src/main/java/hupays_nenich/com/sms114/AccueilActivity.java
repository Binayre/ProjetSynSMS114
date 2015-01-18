package hupays_nenich.com.sms114;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class AccueilActivity extends GlobalActivity {

    private Button btnMesInfos, btnSMS114;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btnMesInfos = (Button)findViewById(R.id.btnMesInfos);
        btnMesInfos.setOnClickListener(new MesInfosListener(this));

        btnSMS114 = (Button)findViewById(R.id.btnSMS114);

        this.message = new Message();

        btnSMS114.setOnClickListener(new SMS114Listener(this));
    }

    @Override
    public String getNouveauTitre() {
        return "Accueil";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
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
