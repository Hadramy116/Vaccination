package m2.iscae.mr.vaccfire.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import m2.iscae.mr.vaccfire.R;
import m2.iscae.mr.vaccfire.modele.Enfant;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListHistoryFromFirebase extends AppCompatActivity {

    private DatabaseReference mDatabase;
    public static final String TAG = "HistoryAcctivity";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history_from_firebase);
        mDatabase = FirebaseDatabase.getInstance().getReference("enfant");
        mListView = (ListView) findViewById(R.id.list_enfant);

        Toast.makeText(this, "BB", Toast.LENGTH_SHORT).show();

        ValueEventListener enListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                getData(dataSnapshot);
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                getError(databaseError);
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(enListener);
        Toast.makeText(this, "ENLISTENER", Toast.LENGTH_SHORT).show();


    }

    private void getError(DatabaseError databaseError) {
        Toast.makeText(this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void getData(DataSnapshot dataSnapshot) {
        Toast.makeText(this, dataSnapshot.getChildrenCount()+" ------- ", Toast.LENGTH_SHORT).show();
        ArrayList<String> array  = new ArrayList<>();
        for (DataSnapshot item : dataSnapshot.getChildren()) {

                Enfant enfant  = item.getValue(Enfant.class);
                Log.d("ER", "Value is: " + enfant.getAge());

                array.add(enfant.getNom());
                array.add(enfant.getAge()+"");


        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        mListView.setAdapter(adapter);
    }
}
