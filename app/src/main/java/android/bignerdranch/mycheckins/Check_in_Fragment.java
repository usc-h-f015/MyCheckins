package android.bignerdranch.mycheckins;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class Check_in_Fragment extends Fragment {
    private static final String ARG_CHECK_IN_ID = "check_in_id";
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

    @SuppressLint("WrongViewCast")
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
        mDateButton.setText(mCheck_in.getDate().toString());
        mDateButton.setEnabled(false);

        return v;
    }
}
