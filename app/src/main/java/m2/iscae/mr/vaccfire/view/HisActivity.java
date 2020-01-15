package m2.iscae.mr.vaccfire.view;


import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import m2.iscae.mr.vaccfire.R;
import m2.iscae.mr.vaccfire.modele.DatabaseHelper;

import java.util.ArrayList;

public class HisActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    DatabaseHelper db = new DatabaseHelper(this);
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his);
        openHelper = new DatabaseHelper(this);
        lst =(ListView)findViewById(R.id.list_histo);
        ShowData();
        VaccinationMenu();

    }
    public void ShowData(){
        ArrayList<String> listData = db.getAllrecord();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listData);
        lst.setAdapter(arrayAdapter);

    }

    private void VaccinationMenu(){
        ((ImageButton) findViewById(R.id.btnRetourDeHisto)).setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HisActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
