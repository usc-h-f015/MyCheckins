package android.bignerdranch.mycheckins;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Check_inLab {

    private static Check_inLab sCheck_inLab;
    private List<Check_in> mCheckins;

    public static Check_inLab get(Context context) {
        if (sCheck_inLab == null) {
            sCheck_inLab = new Check_inLab(context);
        }
        return sCheck_inLab;
    }
    private Check_inLab(Context context) {
        mCheckins = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Check_in check_in = new Check_in();
            check_in.setTitle("Check-in #" + i);
            //check_in.setDate("Date #" + i);
            check_in.setPlace("Place #" + i);
            //check_in.setSolved(i % 2 == 0); // Every other one
            mCheckins.add(check_in);
        }
    }
    public List<Check_in> getCheckins() {
        return mCheckins;
    }
    public Check_in getCheck_in(UUID id) {
        for (Check_in check_in : mCheckins) {
            if (check_in.getId().equals(id)) {
                return check_in;
            }
        }
        return null;
    }
}
