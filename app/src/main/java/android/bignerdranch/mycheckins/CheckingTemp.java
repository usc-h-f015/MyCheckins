package android.bignerdranch.mycheckins;

import android.location.Geocoder;
import android.media.Image;

import androidx.core.app.ShareCompat;

import java.util.Date;
import java.util.UUID;

public class CheckingTemp {

    private UUID mId;
    private String mTitle;
    private  String mPlace;
    private  String mDetails;
    private Date mDate;
    private Geocoder mLocation;
    private Image mImage;
    private ShareCompat mShare;

    public CheckingTemp() {
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
    public Geocoder getLocation() {
        return mLocation;
    }
    public void setLocation(Geocoder location) {
        mLocation = location;
    }
    public Image getImage() {
        return mImage;
    }
    public void setImage(Image image) {
        mImage = image;
    }
    public ShareCompat getShare() {
        return mShare;
    }
    public void setShare(ShareCompat share) {
        mShare = share;
    }
}
