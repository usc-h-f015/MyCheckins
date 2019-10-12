package database.Check_inDbSchema;

import android.bignerdranch.mycheckins.Check_in;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.media.Image;
import android.net.Uri;

import java.util.Date;
import java.util.UUID;

public class Check_inCursorWrapper extends CursorWrapper {
    public Check_inCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Check_in getCheck_in() {
        String uuidString = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.UUID));
        String title = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.TITLE));
        String place = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.PLACE));
        String date = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.DATE));
        String details = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.DETAILS));
        String latitude = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.LATITUDE));
        String longitude = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.LONGITUDE));
       // String image = getString(getColumnIndex(Check_inDbSchema.Check_inTable.Cols.IMAGE));

        Check_in check_in = new Check_in(UUID.fromString(uuidString));
        check_in.setTitle(title);
        check_in.setPlace(place);
        check_in.setDate(new Date(date));
        check_in.setDetails(details);
        check_in.setLatitude(latitude);
        check_in.setmLongitude(longitude);
       // check_in.setImage(image);
        return check_in;
    }
}
