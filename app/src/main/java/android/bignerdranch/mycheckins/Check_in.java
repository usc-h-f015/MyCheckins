package android.bignerdranch.mycheckins;

import android.net.Uri;
import android.widget.Button;

import androidx.core.app.ShareCompat;
import java.util.Date;
import java.util.UUID;

public class Check_in {

    private UUID mId;
    private String mTitle;
    private  String mPlace;
    private  String mDetails;
    private Date mDate;
    private String mLocation;
    private Uri mImage;
    private ShareCompat mShare;
    private String mLatitude;
    private String mLongitude;
    private Button mShowLocation;


    public Check_in() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
    public UUID getId() {
        return mId; }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public String getPlace(){
        return mPlace;
    }
    public void setPlace(String place){
        mPlace = place;
    }
    public String getDetails(){
        return mDetails;
    }
    public void setDetails(String details){
        mDetails = details;
    }
    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
        mDate = date;
    }
    public void setLatitude(String latitude){
        mLatitude = latitude;
    }
    public String getLatitude(){
        return mLatitude;
    }
    public void setmLongitude(String longitude){
        mLongitude = longitude;
    }
    public String getmLongitude(){
        return mLongitude;
    }

    public void setShowLocation(Button showlocation) {
        mShowLocation = showlocation;
    }
    public Button getmShowLocation() {
        return mShowLocation;
    }

    /*public String getLocation() {
        return mLocation;
    }
    public void setLocation(String location) {
        mLocation = location;
    }*/
    public Uri getImage() {
        return mImage;
    }
    public void setImage(Uri image) {
        mImage = image;
    }
    public ShareCompat getShare() {
        return mShare;
    }
    public void setShare(ShareCompat share) {
        mShare = share;
    }



}
