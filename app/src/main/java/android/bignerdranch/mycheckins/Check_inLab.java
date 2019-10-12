package android.bignerdranch.mycheckins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import database.Check_inDbSchema.Check_inBaseHelper;
import database.Check_inDbSchema.Check_inCursorWrapper;
import database.Check_inDbSchema.Check_inDbSchema;

import static android.content.Context.*;

public class Check_inLab {

    private static Check_inLab sCheck_inLab;
   //private List<Check_in> mCheckins;
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
        //mCheckins = new ArrayList<>();
    }

    public void addCheck_in(Check_in c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(Check_inDbSchema.Check_inTable.NAME, null, values);
       // mCheckins.add(c);
    }

    public List<Check_in> getCheckins() {
       // return mCheckins;
        //return new ArrayList<>();
        List<Check_in> check_ins = new ArrayList<>();
        Check_inCursorWrapper cursor = queryCheck_ins(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                check_ins.add(cursor.getCheck_in());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return check_ins;

    }
    public Check_in getCheck_in(UUID id) {
        /*for (Check_in check_in : mCheckins) {
            if (check_in.getId().equals(id)) {
                return check_in;
            }
        }*/
        Check_inCursorWrapper cursor = queryCheck_ins(
                Check_inDbSchema.Check_inTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCheck_in();
        } finally {
            cursor.close();
        }
    }
    public void updateCheck_in(Check_in check_in) {
        String uuidString = check_in.getId().toString();
        ContentValues values = getContentValues(check_in);
        mDatabase.update(Check_inDbSchema.Check_inTable.NAME, values,
                Check_inDbSchema.Check_inTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    private Check_inCursorWrapper queryCheck_ins(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                Check_inDbSchema.Check_inTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new Check_inCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Check_in check_in) {
        ContentValues values = new ContentValues();
        values.put(Check_inDbSchema.Check_inTable.Cols.UUID, check_in.getId().toString());
        values.put(Check_inDbSchema.Check_inTable.Cols.TITLE, check_in.getTitle());
        values.put(Check_inDbSchema.Check_inTable.Cols.PLACE, check_in.getPlace());
        values.put(Check_inDbSchema.Check_inTable.Cols.DATE, check_in.getDate().toString());
        values.put(Check_inDbSchema.Check_inTable.Cols.DETAILS, check_in.getDetails());
        values.put(Check_inDbSchema.Check_inTable.Cols.LATITUDE, check_in.getLatitude());
        values.put(Check_inDbSchema.Check_inTable.Cols.LONGITUDE, check_in.getmLongitude());
        //values.put(Check_inDbSchema.Check_inTable.Cols.IMAGE, Check_in.getImage());
        return values;
    }

    public void removeCheck_in(Check_in check_in) {
        String uuidString = check_in.getId().toString();
        mDatabase.delete(Check_inDbSchema.Check_inTable.NAME,
                Check_inDbSchema.Check_inTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }
}

