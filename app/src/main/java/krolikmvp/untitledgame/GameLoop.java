package krolikmvp.untitledgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Damian on 2016-09-05.
 */
public final class GameLoop extends Activity {
    private static int totalMoney;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static  DBHelper db;
    public GameLoop(DBHelper db1)
    {
        db=db1;

    }

    public void getData(){
        Cursor res = db.getAllData();
        if(res.getCount()==0) {
            totalMoney =2;
            return;
        }
        StringBuffer sb = new StringBuffer();
        while(res.moveToNext()) {
            sb.append(res.getInt(0));

        }

    }
    public static int geti(){

        return totalMoney;
    }

    public static void seti(int val){
        totalMoney=val;
        db.insertData("money",val);


    }

}
