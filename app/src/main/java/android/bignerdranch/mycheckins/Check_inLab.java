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
    }

    public void addCheck_in(Check_in c) {
        mCheckins.add(c);
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
