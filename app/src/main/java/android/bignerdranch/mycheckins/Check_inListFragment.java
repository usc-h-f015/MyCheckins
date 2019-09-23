package android.bignerdranch.mycheckins;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Check_inListFragment extends Fragment {



    private RecyclerView mCheck_inRecyclerView;
    private Check_inAdapter mAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_in_list, container, false);
        mCheck_inRecyclerView = (RecyclerView) view.findViewById(R.id.check_in_recycler_view);
        mCheck_inRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_check_in_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.Show_check_ins);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_check_ins);
        } else {
            subtitleItem.setTitle(R.string.show_check_ins);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_record:
                Check_in check_in = new Check_in();
                Check_inLab.get(getActivity()).addCheck_in(check_in);
                Intent intent = MainActivity
                        .newIntent(getActivity(), check_in.getId());
                startActivity(intent);
                return true;
            case R.id.Show_check_ins:
                mSubtitleVisible = !mSubtitleVisible; getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void updateSubtitle() {
        Check_inLab crimeLab = Check_inLab.get(getActivity());
        int check_inCount = crimeLab.getCheckins().size();
        String subtitle = getString(R.string.subtitle_format, check_inCount);
        if (!mSubtitleVisible) {
            subtitle = null;
        }
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI() {
        Check_inLab check_inLab = Check_inLab.get(getActivity());
        List<Check_in> checkins = check_inLab.getCheckins();
        if (mAdapter == null) {
        mAdapter = new Check_inAdapter(checkins);
        mCheck_inRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        updateSubtitle();
    }

    private class Check_inHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Check_in mCheck_in;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mPlaceTextView;

        public Check_inHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_check_in, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.check_in_title);
            //Typeface roboto =Typeface.createFromAsset(getContext().getAssets(), "font/Robot-Bold.ttf");
            //mTitleTextView.setTypeface(roboto);

            mDateTextView = (TextView) itemView.findViewById(R.id.date_picker_title);
            mPlaceTextView = (TextView) itemView.findViewById(R.id.check_in_place);

        }public void bind(Check_in check_in) {
            mCheck_in = check_in;
            mTitleTextView.setText(mCheck_in.getTitle());
            mDateTextView.setText(mCheck_in.getDate().toString());
            mPlaceTextView.setText(mCheck_in.getPlace());
        }
        @Override
        public void onClick(View view) {
            Intent intent = MainActivity.newIntent(getActivity(), mCheck_in.getId());
            startActivity(intent);
        }
    }

    private class Check_inAdapter extends RecyclerView.Adapter<Check_inHolder> {
        private List<Check_in> mCheckins;

        public Check_inAdapter(List<Check_in> checkins) {
            mCheckins = checkins;
        }

        @Override
        public Check_inHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new Check_inHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(Check_inHolder holder, int position) {
            Check_in check_in = mCheckins.get(position);
            holder.bind(check_in);
        }

        @Override
        public int getItemCount() {
            return mCheckins.size();
        }
    }


}
