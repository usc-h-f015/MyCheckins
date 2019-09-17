package android.bignerdranch.mycheckins;

import androidx.fragment.app.Fragment;

public class Check_inListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new Check_inListFragment();
    }
}
