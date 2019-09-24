package android.bignerdranch.mycheckins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapGoogle extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_google);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10F));
    }

   /* public void onLocationChanged(Location location) {
        TextView locationTv = (TextView) findViewById(R.id.map);
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(21));
        locationTv.setText("Latitude:" + latitude + ", Longitude:" + longitude);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Change the map type based on the users selection.
        switch (item.getItemId()){
            case   (R.id.normal_map):
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
            case  (R.id.hybrid_map):
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            return true;
            case (R.id.satellite_map):
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            case (R.id.terrain_map):
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
