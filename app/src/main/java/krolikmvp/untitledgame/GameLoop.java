package krolikmvp.untitledgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Damian on 2016-09-05.
 */
public final class GameLoop{
    private static int totalMoney;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static  DBHelper db;
    public GameLoop(DBHelper db1)
    {
        db=db1;
        getMoney();
    }

    public void getMoney(){
        Cursor res = db.getAllData();
        if(res.getCount()==0) {
            totalMoney =1000;
            return;
        }
        StringBuffer sb = new StringBuffer();
        while(res.moveToNext()) {
            sb.append(res.getInt(1));
        }
        totalMoney=Integer.parseInt(sb.toString());
    }
    public static int geti(){

        return totalMoney;
    }

    public static void seti(int val){
        totalMoney=val;
        db.updateData("money",totalMoney);
    }

}
