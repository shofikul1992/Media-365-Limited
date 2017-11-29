package com.media360.ltd;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.media360.ltd.Utils.DevicePermission;
import com.media360.ltd.Utils.GPSTracker;

/**
 * Created by admin on 28/11/2017.
 */

public class HomeActivity extends AppCompatActivity {

    private Context mContext;
    private GoogleMap mGoogleMap;
    private GPSTracker mGPSTracker;
    private Double latitude = 23.777176;
    private Double longitude = 90.399452;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext=this;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        }

        // Mothed call for checking  device location permission
        DevicePermission.setLocationPermission(HomeActivity.this);

        SetGoogleMat();
    }

    private void SetGoogleMat() {
        mGPSTracker = new GPSTracker(mContext);
        if (mGPSTracker.canGetLocation()) {
            latitude = mGPSTracker.getLatitude();
            longitude = mGPSTracker.getLongitude();
            if (latitude == 0) {
                latitude = 23.777176;
                longitude = 90.399452;
            }
        } else {
            mGPSTracker.showSettingsAlert();
        }

//        mGoogleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();//
//        mGoogleMap.getUiSettings().setZoomControlsEnabled(false);//

        if (!(mGoogleMap == null)) {
            mGoogleMap.clear();
            mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.getUiSettings().setZoomControlsEnabled(false);
            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
            mGoogleMap.getUiSettings().setCompassEnabled(false);
            mGoogleMap.getUiSettings().setRotateGesturesEnabled(true);
            mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);
            try {
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));
//                MarkerOptions options = new MarkerOptions();
//                options.position(new LatLng(latitude, longitude));
//                LatLng latLng = new LatLng(latitude, longitude);
//                drawMarkerWithCircle(latLng);
//                mGoogleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
//
//                    // Use default InfoWindow frame
//                    @Override
//                    public View getInfoWindow(Marker marker) {
//                        return null;
//                    }
//
//                    @Override
//                    public View getInfoContents(Marker marker) {
//
//                        View v = getLayoutInflater().inflate(R.layout.map_pop_up, null);
//
//                        return v;
//
//                    }
//
//                });


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}

