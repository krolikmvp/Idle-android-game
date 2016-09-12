package krolikmvp.untitledgame;

import android.app.Fragment;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dd.processbutton.ProcessButton;
import com.dd.processbutton.iml.SubmitProcessButton;

import java.lang.annotation.Repeatable;

/**
 * Created by Damian on 2016-09-07.
 */
public class Income implements ProgressGenerator.OnCompleteListener {

    private View view;
    private Button incomeButton;
    private TextView tw;
    private IsRepetable rp;
    private int isbought;
    public static  DBHelper db;
    public Income(View _view,Button _incomeButton,TextView _tw,IsRepetable _rp){
        view=_view;
        incomeButton=_incomeButton;
        tw=_tw;
        rp = _rp;
        db=GameLoop.getDb();
        Listener();
    }
    public void checkIsBought(int pos){
        Cursor res = db.getAllData();
        if(res.getCount()==0) {
            incomeButton.setText("database error");
        }
        StringBuffer sb = new StringBuffer();
        res.moveToPosition(1);
        int isbought =res.getInt(res.getColumnIndex("value"));
        if(isbought>0)
            incomeButton.setText("owned");
        else {
            incomeButton.setEnabled(true);
            incomeButton.setText("BUY FOR 10$");
        }
    }

    @Override
    public void onCompleteRp() {

       incomeButton.setEnabled(true);
        GameLoop.seti(GameLoop.geti()+1);
        tw.setText(Integer.toString( GameLoop.geti())+" $");
        incomeButton.performClick();

    }

    @Override
    public void onCompleteUrp() {
        incomeButton.setEnabled(true);
        GameLoop.seti(GameLoop.geti()+1);
        tw.setText(Integer.toString( GameLoop.geti())+" $");
    }

    public void Listener(){
        final ProgressGenerator progressGenerator = new ProgressGenerator(this, rp);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isbought==0 & GameLoop.getTotalMoney()>1001 & (rp==IsRepetable.REPETABLE)) {
                    GameLoop.seti(GameLoop.geti()-10);
                    incomeButton.setEnabled(false);
                    progressGenerator.start((SubmitProcessButton) incomeButton);
                }
                else if(rp==IsRepetable.UNREPETABLE) {
                    incomeButton.setEnabled(false);
                    progressGenerator.start((SubmitProcessButton) incomeButton);
                }
            }
        });

    }



}
