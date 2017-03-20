package ac.phantom;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private GoogleMap mMap;
    public static final double
            AC_LAT = 45.352386,
            AC_LNG =-75.754869;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFrag != null)
            mapFrag.getMapAsync(this);
    }
    public boolean servicesOK() {

        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
            Dialog dialog =
                    GooglePlayServicesUtil.getErrorDialog(isAvailable, this, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "Can't connect to mapping service", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap m) {
        mMap = m;
        LatLng CurrentLocation = new LatLng(AC_LAT , AC_LNG);
            mMap
                .addMarker(new MarkerOptions()
                .position(CurrentLocation).title("Algonquin College - Current location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CurrentLocation,10));
        LatLng  RestaurantLocation = new LatLng(45.415313, -75.7560937);
        mMap.addMarker(new MarkerOptions()
                .position(RestaurantLocation)
                .title(" McDonald`s - locate at 1380 College Square,Ottawa,On")
                .snippet("2 min (550 m),via College Ave.Fastest route"));

        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(AC_LAT , AC_LNG), new LatLng(45.415313,-75.7560937 ))
                .width(5)
                .color(Color.RED));

    }


}