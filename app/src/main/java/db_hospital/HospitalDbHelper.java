package db_hospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HospitalDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Hospital.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Doctor";

    public HospitalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Dname TEXT, " +
                        "specialization TEXT, " +
                        "Experience REAL)";
        db.execSQL(query);
    }

    public long insertDoctor(String name, String specialization, double experience) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Dname", name);
        values.put("specialization", specialization);
        values.put("Experience", experience);
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllDoctor() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public int updateDoctor(int id, String name, String specialization, double experience) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Dname", name);
        values.put("specialization", specialization);
        values.put("Experience", experience);
        return db.update(TABLE_NAME, values, "id=?", new String[]{String.valueOf(id)});
    }

    public int deleteDoctor(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
