package com.example.praktiklogin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.praktiklogin.Model.ModelUser;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "USER";
    private static final String TABLE_LOGIN = "tbl_login";
    private static final String TABLE_USER ="tbl_user"
    private static final String KEY_ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String NAMA = "nama";
    private static final String ALAMAT = "alamat";
    private static final String TANGGAL_LAHIR = "tanggal_lahir";

    public DatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDB = "CREATE_TABLE"+TABLE_LOGIN+"("+KEY_ID+"INTEGER PRIMARY KEY,"+USERNAME+"TEXT,"+PASSWORD+"TEXT";
        sqLiteDatabase.execSQL(createDB);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDB = "CREATE_TABLE"+TABLE_USER+"("+KEY_ID+"INTEGER PRIMARY KEY,"+NAMA+"TEXT."+ALAMAT+"TEXT,"+TANGGAL_LAHIR+"TEXT";
        sqLiteDatabase.execSQL(createDB);
    }

    //Untuk insert query
    public void SaveLogin(ModelUser USER){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,USER.getUsername());
        cv.put(PASSWORD,USER.getPassword());
        db.insert(TABLE_LOGIN,null,cv);
        db.close();
    }

    //Untuk search data
    public ModelUser SearchQuery(ModelUser USER){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from"+TABLE_LOGIN+"where"+USERNAME+"="+USER.getUsername()+"and"+PASSWORD+"="+USER.getPassword(),null);
        ModelUser MU = new ModelUser();
        if (cursor.moveToFirst()){
            do {
                MU.setUsername(cursor.getString(1));
                MU.setPassword(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return MU;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
