package com.killer.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.killer.myapplication.ui.gallery.GalleryFragment;

import java.sql.Blob;

public class DBHelper extends SQLiteOpenHelper {
    
    public static final String DATABASE_NAME ="Mentorapp2";
    public static final String TABLE_NAME ="profile";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="name";
    public static final String COL_3 ="email";
    public static final String COL_4 ="mobile";
    public static final String COL_5 ="address";
    public static final String COL_6 ="img";

    public static final String TABLE_NAME1 ="Payment";
    public static final String COL1 ="cardName";
    public static final String COL2 ="cardNumber";
    public static final String COL3 ="expiry";
    public static final String COL4 ="cvv";

    public DBHelper(FragmentActivity activity) {
        super(activity, DATABASE_NAME , null , 1);
    }


   // public void DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" ("+COL_1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_2+ " TEXT,"+COL_3+" VARCHAR,"+COL_4+" INTEGER,"+COL_5+" VARCHAR,"+COL_6+" BLOB)");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME1+" ("+COL1+ " TEXT,"+
                COL2+ " INTEGRE, "+COL3+" INTEGRE, "+COL4+" INTEGER)");
        //sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, fname TEXT, lname TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String name, String mail, String mobile, String address, Blob img){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",mail);
        contentValues.put("mobile",mobile);
        contentValues.put("address",address);
        //contentValues.put("img",img);
        long res = db.insert("profile",null,contentValues);
        db.close();
        return  res;
    }
    public long addPayment(String name, String number, String expiry1, String cvv1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cardName",name);
        contentValues.put("cardNumber",number);
        contentValues.put("expiry",expiry1);
        contentValues.put("cvv",cvv1);
        long res = db.insert("Payment",null,contentValues);
        db.close();
        return  res;
    }
    public Cursor fetchUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("profile", new String[]{"name", "email", "mobile", "address", "img"}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchPayment() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("Payment", new String[]{"cardName", "cardNumber", "expiry", "cvv"}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
   /* public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }*/

    public long updateUser(String name, String mail, String mobile, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",mail);
        contentValues.put("mobile",mobile);
        contentValues.put("address",address);
        long res = db.update("profile",contentValues, "mail = " +mail, null);
        db.close();
        return  res;
    }
    public long updatePayment(String name, String number, String expiry1, String cvv1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cardName",name);
        contentValues.put("cardNumber",number);
        contentValues.put("expiry",expiry1);
        contentValues.put("cvv",cvv1);
        long res = db.update("Payment",contentValues, "cvv = " +cvv1, null);
        db.close();
        return  res;
    }

}
