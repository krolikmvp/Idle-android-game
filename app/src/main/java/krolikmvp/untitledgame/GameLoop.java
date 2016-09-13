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
    private static int actualPopulation;
    private static int MONEY_POS=0;
    private static int POPULATION_POS=1;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static DBHelper db;
    public GameLoop(DBHelper db1)
    {
        db=db1;
        getVariables();
    }
    public static DBHelper getDb()
    {
        return db;
    }


    public void getVariables()
    {
        Cursor res = db.getAllData();
        if(res.getCount()==0) {
            totalMoney = 2000;
            actualPopulation = 60;
            return;
        }
        res.moveToPosition(MONEY_POS);
        String str= res.getString(res.getColumnIndex("value"));
        totalMoney=Integer.parseInt(str);
        res.moveToPosition(POPULATION_POS);
        str= res.getString(res.getColumnIndex("value"));
        actualPopulation=Integer.parseInt(str);
    }

    public static int getTotalMoney()
    {
        return totalMoney;
    }

    public static String getTotalMoneyString()
    {
        return Integer.toString(totalMoney);
    }

    public static String getActualPopulationString() {
        return Integer.toString(actualPopulation);
    }

    public static int getActualPopulation() {
        return actualPopulation;
    }

    public static void setActualPopulation(int val) {
        actualPopulation=val;
    }

    public static void seti(int val)
    {
        totalMoney=val;
        //db.updateData("money",totalMoney);
    }

}
