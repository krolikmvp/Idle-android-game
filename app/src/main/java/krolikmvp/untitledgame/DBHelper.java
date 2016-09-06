package krolikmvp.untitledgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Damian on 2016-09-05.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="test.db";
    public static final String TABLE_NAME="variables";
    public static final String KEY="key";
    public static final String VALUE="value";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (key text,value integer)");
        insertData("money",1000,db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String key,int value, SQLiteDatabase db){

        ContentValues cv= new ContentValues();
        cv.put(KEY,key);
        cv.put(VALUE,value);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String key,int value)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(VALUE,value);
        long result = db.update(TABLE_NAME,cv,"key = ?",new String[] {key});
        return true;
    }
    public void removeAll()
    {
        SQLiteDatabase db = getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(TABLE_NAME, null, null);
    }
}
