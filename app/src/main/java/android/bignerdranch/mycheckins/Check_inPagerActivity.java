package android.bignerdranch.mycheckins;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class Check_inPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Check_in> mCheckins;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_pager);

        mViewPager = (ViewPager) findViewById(R.id.check_in_view_pager);
        mCheckins = Check_inLab.get(this).getCheckins();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Check_in check_in = mCheckins.get(position);
                return Check_in_Fragment.newInstance(check_in.getId());
            }
            @Override
            public int getCount() {
                return mCheckins.size();
            }
        });
    }
}
