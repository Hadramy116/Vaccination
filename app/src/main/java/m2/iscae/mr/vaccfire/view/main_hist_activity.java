package m2.iscae.mr.vaccfire.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import m2.iscae.mr.vaccfire.R;

public class main_hist_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_hist_activity);
        VaccinationMenu((ImageButton) findViewById(R.id.btnMenuHistorique_locale), HisActivity.class);
        VaccinationMenu((ImageButton) findViewById(R.id.btnMenuHistorique_distant), hist_Distant_activity.class);
    }
    private void VaccinationMenu(ImageButton btn, final Class classe){
        btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( main_hist_activity.this, classe);
                startActivity(intent);
            }
        });
    }
}
