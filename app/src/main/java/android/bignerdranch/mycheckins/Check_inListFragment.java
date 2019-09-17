package android.bignerdranch.mycheckins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Check_inListFragment extends Fragment {

    private RecyclerView mCheck_inRecyclerView;
    private Check_inAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_in_list, container, false);
        mCheck_inRecyclerView = (RecyclerView) view
                .findViewById(R.id.check_in_recycler_view);
        mCheck_inRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    private void updateUI() {
        Check_inLab check_inLab = Check_inLab.get(getActivity());
        List<Check_in> checkins = check_inLab.getCheckins();
        mAdapter = new Check_inAdapter(checkins);
        mCheck_inRecyclerView.setAdapter(mAdapter);
    }

    private class Check_inHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Check_in mCheck_in;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mPlaceTextView;

        public Check_inHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_check_in, parent, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.check_in_title);
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
            Toast.makeText(getActivity(),
                    mCheck_in.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
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
