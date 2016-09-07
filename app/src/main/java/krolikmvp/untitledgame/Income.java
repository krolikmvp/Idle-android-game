package krolikmvp.untitledgame;

import android.app.Fragment;
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

    View view;
    Button incomeButton;
    TextView tw;
    IsRepetable rp;
    public Income(View _view,Button _incomeButton,TextView _tw,IsRepetable _rp){
        view=_view;
        incomeButton=_incomeButton;
        tw=_tw;
        rp = _rp;
        Listener();
    }

    @Override
    public void onCompleteRp() {
        tw.setText(Integer.toString( GameLoop.geti())+" $");
        GameLoop.seti(GameLoop.geti()+1);
       incomeButton.setEnabled(true);
        incomeButton.performClick();
    }
    @Override
    public void onCompleteUrp() {
        incomeButton.setEnabled(true);

    }
    public void Listener(){
        final ProgressGenerator progressGenerator = new ProgressGenerator(this, rp);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeButton.setEnabled(false);
                progressGenerator.start((SubmitProcessButton) incomeButton);

            }
        });

    }



}
