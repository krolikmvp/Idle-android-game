
package krolikmvp.untitledgame;

        import android.content.Context;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;
        import com.dd.processbutton.iml.ActionProcessButton;
        import com.dd.processbutton.iml.SubmitProcessButton;

        import java.util.zip.Inflater;

        import krolikmvp.untitledgame.ProgressGenerator;
/**
 * Created by Damian on 2016-09-04.
 */
public class JobsActivity extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    TextView money_tw;
    SubmitProcessButton jobButton;
    SubmitProcessButton firstIncomeButton;
    IsRepetable repetable,unretepable;
    public JobsActivity() {
        repetable=IsRepetable.REPETABLE;
        unretepable=IsRepetable.UNREPETABLE;
    }

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

        final View rootView = inflater.inflate(R.layout.activity_jobs, container, false);
        money_tw=(TextView)rootView.findViewById(R.id.money_tw);
        firstIncomeButton = (SubmitProcessButton) rootView.findViewById(R.id.firstIncomeButton);
        jobButton = (SubmitProcessButton) rootView.findViewById(R.id.firstJobButton);
        Income work=new Income(rootView,jobButton,money_tw,unretepable);
        Income income=new Income(rootView,firstIncomeButton,money_tw,repetable);

        return rootView;
    }


}