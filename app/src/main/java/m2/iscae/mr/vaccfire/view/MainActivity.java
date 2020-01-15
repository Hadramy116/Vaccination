package m2.iscae.mr.vaccfire.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import m2.iscae.mr.vaccfire.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        VaccinationMenu((ImageButton) findViewById(R.id.btnMenuVaccination), VaccinationActivity.class);
        VaccinationMenu((ImageButton) findViewById(R.id.btnMenuHistorique), main_hist_activity.class);


    }
    private void VaccinationMenu(ImageButton btn, final Class classe){
        btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, classe);
                startActivity(intent);
            }
        });
    }


}


