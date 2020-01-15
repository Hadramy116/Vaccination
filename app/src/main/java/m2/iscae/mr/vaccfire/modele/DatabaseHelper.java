package m2.iscae.mr.vaccfire.modele;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Compagne_Vaccination.db";
    public static final String TABLE_NAME2="Enfant";
    public static final String TABLE_NAME1="Vaccination";
    public static final String COL_1="ID";
    public static final String COL_2="Nom";
    public static final String COL_3="Prenom";
    public static final String COL_4="Age";
    public static final String COL_5="TelParent";
    public static final String COL_6="Lieu";
    public static final String COL_7="Type_vaccination";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE  " + TABLE_NAME1  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Type_vaccination TEXT)");

        db.execSQL( "CREATE TABLE  " + TABLE_NAME2  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Prenom TEXT,Nom TEXTE," +
                "Age INTEGRE,TelParent INTEGRE,Lieu TEXTE,Type_vaccination TEXTE," +
                "FOREIGN KEY (Type_vaccination)REFERENCES Vaccination (ID) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }
    public ArrayList getAllrecord(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from Enfant",null);

        res.moveToFirst();
        while (res.isAfterLast()==false){
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            String t4 = res.getString(3);
            String t5 = res.getString(4);
            String t6 = res.getString(5);
            String t7 = res.getString(6);

            arrayList.add("ID: "+t1 +"\n"+ "Nom: "+t2 +"\n"+"Prénom: "+ t3 +"\n"+"Age: "
                    + t4 +" mois "+"\n"+" Téléphone parent: "+ t5 +"\n"+" Lieu: "+ t6 +"\n" +"Type Vaccaccination: "+ t7 );
            res.moveToNext();
        }
        return arrayList;
    }


}


