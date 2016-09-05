package krolikmvp.untitledgame;
import com.dd.processbutton.ProcessButton;

import android.os.Handler;

import java.util.Random;

public class ProgressGenerator {

    public interface OnCompleteListener {

        public void onComplete();
    }

    private OnCompleteListener mListener;
    private int mProgress;

    public ProgressGenerator(OnCompleteListener listener) {
        mListener = listener;
    }

    public void start(final ProcessButton button) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgress += 5;
                button.setProgress(mProgress);
                if (mProgress < 100) {
                    handler.postDelayed(this, 100);
                } else {
                    mListener.onComplete();
                    mProgress=0;
                }
            }
        }, 100);
    }

}