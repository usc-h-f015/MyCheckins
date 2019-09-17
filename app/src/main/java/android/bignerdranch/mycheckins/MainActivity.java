package android.bignerdranch.mycheckins;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    public static final String EXTRA_CHECK_IN_ID =
            "com.bignerdranch.android.mycheckins.check_in_id";
    public static Intent newIntent(Context packageContext, UUID check_inId) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(EXTRA_CHECK_IN_ID, check_inId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID check_inId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CHECK_IN_ID);
        return Check_in_Fragment.newInstance(check_inId);
    }
}

