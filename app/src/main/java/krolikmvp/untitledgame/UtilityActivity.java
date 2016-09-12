package krolikmvp.untitledgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Damian on 2016-09-04.
 */
public class UtilityActivity extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public UtilityActivity() {
    }
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UtilityActivity newInstance() {
        UtilityActivity fragment = new UtilityActivity();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_war, container, false);

        return rootView;
    }
}