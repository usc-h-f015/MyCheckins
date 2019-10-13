package android.bignerdranch.mycheckins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import java.util.Date;
import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    private static final String ARG_DATE = "date";
    private static final String ARG_MAP = "showmap";
    private DatePicker mDatePicker;
    private GoogleMap mGoogleMap;


    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static final String EXTRA_CHECK_IN_ID =
            "android.bignerdranch.mycheckins.check_in_id";
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

