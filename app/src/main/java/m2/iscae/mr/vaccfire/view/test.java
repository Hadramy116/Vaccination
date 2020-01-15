package m2.iscae.mr.vaccfire.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import m2.iscae.mr.vaccfire.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class test extends AppCompatActivity {

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("enfant").child("2").setValue("slkfhk");

    }
}
