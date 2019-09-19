package android.bignerdranch.mycheckins;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;
import java.util.UUID;

public class Check_in_Fragment extends Fragment {
    private static final String ARG_CHECK_IN_ID = "check_in_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;

    private Check_in mCheck_in;
    private EditText mTitleField;
    private EditText mPlaceField;
    private EditText mDetailsField;
    private Button mDateButton;

    public static Check_in_Fragment newInstance(UUID check_inId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHECK_IN_ID, check_inId);
        Check_in_Fragment fragment = new Check_in_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID check_inId = (UUID) getArguments().getSerializable(ARG_CHECK_IN_ID);
        mCheck_in = Check_inLab.get(getActivity()).getCheck_in(check_inId);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_check_in, container, false);

        mTitleField = (EditText) v.findViewById(R.id.check_in_title);
        mTitleField.setText(mCheck_in.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck_in.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mPlaceField = (EditText) v.findViewById(R.id.check_in_place);
        mPlaceField.setText(mCheck_in.getPlace());
        mPlaceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck_in.setPlace(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mDetailsField = (EditText) v.findViewById(R.id.check_in_details_label);
        mDetailsField.setText(mCheck_in.getDetails());
        mDetailsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck_in.setDetails(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });

        mDateButton = (Button) v.findViewById(R.id.date_picker_title);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mCheck_in.getDate());
                dialog.setTargetFragment(Check_in_Fragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            } });

        return v;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCheck_in.setDate(date);
            updateDate();
        }
    }

    private void updateDate() {
        mDateButton.setText(mCheck_in.getDate().toString());
    }
}
