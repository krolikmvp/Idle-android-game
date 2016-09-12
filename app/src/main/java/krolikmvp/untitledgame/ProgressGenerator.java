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
    public IsRepetable rpt;
    public ProgressGenerator(OnCompleteListener listener, IsRepetable _rpt) {
        rpt=_rpt;
        mListener = listener;
    }

    public void start(final ProcessButton button) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgress += 1;
                button.setProgress(mProgress);
                if (mProgress < 100)
                {
                    handler.postDelayed(this, 50);
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
            }
        }, 100);
    }

}