
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
    private final int DB_INCOME01 = 2;
    private final int DB_INCOME02 = 3;
    private final int DB_INCOME03 = 4;
    private final int DB_INCOME04 = 5;
    private final int DB_INCOME05 = 6;

    private static final String ARG_SECTION_NUMBER = "section_number";
    TextView money_tw,population_tw;
    SubmitProcessButton job01Button;
    SubmitProcessButton income01Button,income02Button;
    Button income01Plus,income02Plus,income03Plus,income04Plus;
    Button income01Minus,income02Minus,income03Minus,income04Minus;
    Button income01Start,income02Start,income03Start,income04Start;
    IsRepetable repetable,unrepetable;

    public JobsActivity() {
        repetable=IsRepetable.REPETABLE;
        unrepetable=IsRepetable.UNREPETABLE;
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
        setButtons(rootView);
        Income job01=new Income(rootView,job01Button,income01Plus,income01Minus,income01Start,money_tw,unrepetable,0,10,30);//plus,minus,start to change
        Income income01=new Income(rootView,income01Button,income01Plus,income01Minus,income01Start,money_tw,repetable,100,10,120);
        Income income02=new Income(rootView,income02Button,income02Plus,income02Minus,income02Start,money_tw,repetable,300,30,300);
        income01.checkIsBought(DB_INCOME01);
        income02.checkIsBought(DB_INCOME02);

        return rootView;
    }
    private void setButtons(View rootView){
        population_tw=(TextView)rootView.findViewById(R.id.population);
        population_tw.setText(GameLoop.getActualPopulationString());
        money_tw=(TextView)rootView.findViewById(R.id.money_tw);
        money_tw.setText(GameLoop.getTotalMoneyString()+ " $");
        job01Button = (SubmitProcessButton) rootView.findViewById(R.id.firstJobButton);
        income01Button = (SubmitProcessButton) rootView.findViewById(R.id.IncomeButton01);
        income01Plus = (Button) rootView.findViewById(R.id.IncomeButton01Plus);
        income01Minus = (Button) rootView.findViewById(R.id.IncomeButton01Minus);
        income01Start = (Button) rootView.findViewById(R.id.IncomeButton01Start);

        income02Button = (SubmitProcessButton) rootView.findViewById(R.id.IncomeButton02);
        income02Plus = (Button) rootView.findViewById(R.id.IncomeButton02Plus);
        income02Minus = (Button) rootView.findViewById(R.id.IncomeButton02Minus);
        income02Start = (Button) rootView.findViewById(R.id.IncomeButton02Start);
    }

}