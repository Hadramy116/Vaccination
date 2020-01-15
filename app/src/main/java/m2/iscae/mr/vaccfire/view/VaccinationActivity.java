package m2.iscae.mr.vaccfire.view;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import m2.iscae.mr.vaccfire.R;
import m2.iscae.mr.vaccfire.modele.DatabaseHelper;
import m2.iscae.mr.vaccfire.modele.Enfant;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class VaccinationActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _buttonenrege;

    private DatabaseReference mDatabase;

    private Enfant en;
    TextInputLayout _TxtNom, _Txtprenom, _Txtage,_Txttel, _txtLieu ,_TxtVacc;

    DatabaseHelper Compagne_Vaccination;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Compagne_Vaccination = new DatabaseHelper(this);
        openHelper = new DatabaseHelper(this);
        _buttonenrege =(Button)findViewById(R.id.buttonenrege);
        _TxtNom=(TextInputLayout)findViewById(R.id.TxtNom) ;
        _Txtprenom = (TextInputLayout)findViewById(R.id.Txtprenom) ;
        _Txtage =  (TextInputLayout)findViewById(R.id.Txtage) ;
        _Txttel =  (TextInputLayout)findViewById(R.id.Txttel) ;
        _txtLieu = (TextInputLayout)findViewById(R.id.txtLieu) ;
        _TxtVacc = (TextInputLayout)findViewById(R.id.TxtVacc);

        en = new Enfant() ;


        _buttonenrege.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String Nom= _TxtNom.getEditText().getText().toString();
                String Prenom= _Txtprenom.getEditText().getText().toString();
                Integer age= Integer.valueOf(_Txtage.getEditText().getText().toString());
                Integer TelParent= Integer.valueOf(_Txttel.getEditText().getText().toString());
                String Lieu= _txtLieu.getEditText().getText().toString();
                String type_vaccination= _TxtVacc.getEditText().getText().toString();

                en.setNom(Nom);
                en.setPrenom(Prenom);
                en.setAge(age);
                en.setLieu(Lieu);
                en.setTelParent(TelParent);
                en.setType_vaccination(type_vaccination);

                String id = mDatabase.getKey();
                mDatabase.child("enfant").child("7").setValue(en);
             /*   String id = mDatabase.getKey();
                mDatabase.child("enfant").child(id).setValue(en);*/





                Toast.makeText(VaccinationActivity.this, "add............................................", Toast.LENGTH_SHORT).show();

              // Enfant e1 = new Enfant(Nom,Prenom,age,TelParent,Lieu,type_vaccination);
               //databaseVaccination.push().setValue(e1) ;
                insertdata(Nom,Prenom,age,TelParent,Lieu,type_vaccination);
                confirmInput(v);



            }
        });


        VaccinationMenu();

    }





    public  void  insertdata(String Nom,String Prenom,Integer Age,Integer TelParent,String Lieu,
                             String type_vaccination){
        ContentValues  contentValues =  new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,Nom);
        contentValues.put(DatabaseHelper.COL_3,Prenom);
        contentValues.put(DatabaseHelper.COL_4,Age);
        contentValues.put(DatabaseHelper.COL_5,TelParent);
        contentValues.put(DatabaseHelper.COL_6,Lieu);
        contentValues.put(DatabaseHelper.COL_7,type_vaccination);

        long id = db.insert(DatabaseHelper.TABLE_NAME2,null,contentValues);


    }

    private void VaccinationMenu(){
        ((ImageButton) findViewById(R.id.btnRetourDeVacciner)).setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( VaccinationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean valideNom(){

        String Nom= _TxtNom.getEditText().getText().toString().trim();

        if(Nom.isEmpty()){
            _TxtNom.setError("Est vide");
            return false;
        }else{
            _TxtNom.setError(null);
            return true;
        }
    }

    private boolean validePreNom(){

        String Prenom= _Txtprenom.getEditText().getText().toString().trim();

        if(Prenom.isEmpty()){
            _Txtprenom.setError("Est vide");
            return false;
        }else{
            _Txtprenom.setError(null);
            return true;
        }
    }
    private boolean valideLIEU(){

        String Lieu= _txtLieu.getEditText().getText().toString().trim();

        if(Lieu.isEmpty()){
            _txtLieu.setError("Est vide");
            return false;
        }else{
            _txtLieu.setError(null);
            return true;
        }
    }
    private boolean valideVaccination(){

        String Lieu= _TxtVacc.getEditText().getText().toString().trim();

        if(Lieu.isEmpty()){
            _TxtVacc.setError("Est vide");
            return false;
        }else{
            _TxtVacc.setError(null);
            return true;
        }
    }
    public void confirmInput(View v){

        if(!valideNom() | !validePreNom() | !valideLIEU() | !valideVaccination()){
            return;
        }
        String input ="Nom:" + _TxtNom.getEditText().getText().toString();
        input += "\n";
        input += "Prénom:" + _Txtprenom.getEditText().getText().toString();
        input += "\n";
        input += "Age:" + _Txtage.getEditText().getText().toString() +" mois";
        input += "\n";
        input += "Téléphone parent:"+ _Txttel.getEditText().getText().toString();
        input += "\n";
        input += "Lieu:" + _txtLieu.getEditText().getText().toString();
        input += "\n";
        input += "Type Vaccination:" + _TxtVacc.getEditText().getText().toString();
        input += "\n";
        input  += "register avec succes";

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();




    }


}


