package android.bignerdranch.mycheckins;

import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new Check_in_Fragment();
    }
}

