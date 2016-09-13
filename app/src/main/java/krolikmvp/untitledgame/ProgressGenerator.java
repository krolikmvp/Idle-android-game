package krolikmvp.untitledgame;
import com.dd.processbutton.ProcessButton;

import android.os.Handler;

import java.util.Random;

public class ProgressGenerator {

    public interface OnCompleteListener {

        public void onCompleteRp();
        public void onCompleteUrp();
    }

    private OnCompleteListener mListener;
    private int mProgress;
    private int mTime;
    private IsRepetable rpt;
    private String time;
    private int h,m,s,tmp;
    public ProgressGenerator(OnCompleteListener listener, IsRepetable _rpt,int cooldown) {
        rpt=_rpt;
        mListener = listener;
        mTime=cooldown;
    }

    public void setmTime(int val){

        mTime = val;
    }
    public String getTime(){
        tmp=mTime*100;
        s = (tmp/ 1000) % 60;
        m = (tmp / (1000 * 60)) % 60;
        h = (tmp / (1000 * 60 * 60)) % 24;

        if(h>0)
            time= String.format("%dh%02dm%02ds", h, m, s);
        else if (m>0 & h==0)
            time= String.format("%dm%02ds", m, s);
        else
            time= String.format("%ds", s);

        return time;
    }
    public void start(final ProcessButton button) {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                mProgress += 1;
                button.setProgress(mProgress);
                if (mProgress < 100)
                {
                    handler.postDelayed(this, mTime);
                }
                else
                {
                    if(rpt==IsRepetable.REPETABLE)
                    {
                        mListener.onCompleteRp();
                        mProgress=0;
                    }
                    else
                    {
                        mListener.onCompleteUrp();
                        mProgress=0;
                    }

                }
            };
        });
    }

}