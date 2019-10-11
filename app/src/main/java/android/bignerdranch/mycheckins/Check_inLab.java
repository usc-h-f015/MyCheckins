package android.bignerdranch.mycheckins;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import database.Check_inDbSchema.Check_inBaseHelper;

import static android.content.Context.*;

public class Check_inLab {

    private static Check_inLab sCheck_inLab;
    private List<Check_in> mCheckins;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static Check_inLab get(Context context) {
        if (sCheck_inLab == null) {
            sCheck_inLab = new Check_inLab(context);
        }
        return sCheck_inLab;
    }
    private Check_inLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new Check_inBaseHelper(mContext)
                .getWritableDatabase();
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

    public void removeCheck_in(Check_in check_in) {
        mCheckins.remove(check_in);
    }
}

