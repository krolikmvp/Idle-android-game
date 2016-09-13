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
    private Button incomeButton,plusButton,minusButton,startButton;
    private TextView tw;
    private IsRepetable rp;
    private int isbought;
    private int baseCost,baseProfit,baseCooldown;
    public static  DBHelper db;
    public Income(View _view,Button _incomeButton,Button _plusButton,Button _minusButton,
                  Button _startButton, TextView _tw,IsRepetable _rp,int _baseCost,int _baseProfit,int _baseCooldown){
        view=_view;
        incomeButton=_incomeButton;
        plusButton=_plusButton;
        minusButton=_minusButton;
        startButton=_startButton;
        baseCost=_baseCost;
        baseProfit=_baseProfit;
        baseCooldown=_baseCooldown;
        tw=_tw;
        rp =_rp;
        db=GameLoop.getDb();
        Listener();
    }

    public void checkIsBought(int pos){
        Cursor res = db.getAllData();
        if(res.getCount()==0) {
            incomeButton.setText("database error");
        }
        StringBuffer sb = new StringBuffer();
        res.moveToPosition(pos);
        int isbought =res.getInt(res.getColumnIndex("value"));
        if(isbought>0)
            incomeButton.setText("owned");
        else {
            incomeButton.setEnabled(true);
            incomeButton.setText("BUILD FOR "+ Integer.toString(baseCost)+" $");
        }
    }

    @Override
    public void onCompleteRp() {

       incomeButton.setEnabled(true);
        GameLoop.seti(GameLoop.getTotalMoney()+baseProfit);
        tw.setText(GameLoop.getTotalMoneyString()+" $");
        startButton.setEnabled(true);
        incomeButton.performClick();

    }

    @Override
    public void onCompleteUrp() {
        incomeButton.setEnabled(true);
        GameLoop.seti(GameLoop.getTotalMoney()+1);
        tw.setText(GameLoop.getTotalMoneyString() +" $");
    }

    public void Listener(){
        final ProgressGenerator progressGenerator = new ProgressGenerator(this, rp,baseCooldown);

        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isbought==0 & GameLoop.getTotalMoney()>=baseCost & (rp==IsRepetable.REPETABLE)) {
                    isbought=1;
                    GameLoop.seti(GameLoop.getTotalMoney()-baseCost);
                    incomeButton.setEnabled(false);
                    progressGenerator.start((SubmitProcessButton) incomeButton);
                    incomeButton.setText(baseProfit+"$/"+progressGenerator.getTime());
                }
                else if(rp==IsRepetable.UNREPETABLE) {
                    incomeButton.setEnabled(false);
                    progressGenerator.start((SubmitProcessButton) incomeButton);
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(isbought>0) {
                        startButton.setEnabled(false);
                        progressGenerator.start((SubmitProcessButton) incomeButton);
                    }
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeButton.setText(baseProfit+"$/"+progressGenerator.getTime());
            }
        });

    }



}
