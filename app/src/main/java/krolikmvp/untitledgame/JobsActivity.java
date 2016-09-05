
package krolikmvp.untitledgame;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;
        import com.dd.processbutton.iml.ActionProcessButton;
        import com.dd.processbutton.iml.SubmitProcessButton;

        import krolikmvp.untitledgame.ProgressGenerator;
/**
 * Created by Damian on 2016-09-04.
 */
public class JobsActivity extends Fragment implements ProgressGenerator.OnCompleteListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public JobsActivity() {
    }
    TextView tw;
    Button bt;
    SubmitProcessButton btnSend;
    int counter=0;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static JobsActivity newInstance() {
        JobsActivity fragment = new JobsActivity();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_jobs, container, false);
        tw=(TextView)rootView.findViewById(R.id.firstJobCount);
       // bt=(Button)rootView.findViewById(R.id.firstJobButton);
        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        btnSend = (SubmitProcessButton) rootView.findViewById(R.id.firstJobButton);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSend.setEnabled(false);
                progressGenerator.start(btnSend);
                tw.setText(Integer.toString( GameLoop.geti()));
                GameLoop.seti(GameLoop.geti()+1);

            }
        });

        return rootView;
    }
    @Override
    public void onComplete() {
        //Toast.makeText(this, R.string.Loading_Complete, Toast.LENGTH_LONG).show();
        btnSend.setEnabled(true);
    }
}